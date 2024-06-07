
import org.arenaGame.Arena;
import org.arenaGame.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;


/**
 * Test cases for the Arena class.
 */
public class ArenaTest {

    /**
     * Test the startFight method.
     * Ensures that the fight ends with one player's health reaching zero.
     */
    @Test
    public void testStartFight() {
        Player playerA = new Player(50, 5, 10); // Player A has less health and will attack first
        Player playerB = new Player(100, 10, 5); // Player B has more health
        Arena arena = new Arena(playerA, playerB);
        arena.startFight();
        assertTrue(playerA.getHealth() <= 0 || playerB.getHealth() <= 0);
        if (playerA.getHealth() <= 0) {
            assertEquals(0, playerA.getHealth());
            assertTrue(playerB.getHealth() > 0);
        } else {
            assertEquals(0, playerB.getHealth());
            assertTrue(playerA.getHealth() > 0);
        }
    }

    /**
     * Test the performTurn method.
     * Simulates a single turn of attack and defense between two players.
     */

    @Test
    public void testPerformTurn() {
        // Create players with initial health, attack, and defense values
        Player playerA = Mockito.spy(new Player(50, 5, 10)); // Player A has less health and will attack first
        Player playerB = Mockito.spy(new Player(100, 10, 5)); // Player B has more health

        // Mock the dice rolls
        when(playerA.rollAttackDice()).thenReturn(3); // Mock playerA's attack roll
        when(playerB.rollDefenseDice()).thenReturn(2); // Mock playerB's defense roll

        Arena arena = new Arena(playerA, playerB);

        // Capture initial health
        int initialHealthB = playerB.getHealth();

        // Simulate a single turn where playerA is the attacker and playerB is the defender
        arena.performTurn(playerA, playerB);

        // Calculate expected health based on mocked values
        int attackRoll = playerA.rollAttackDice();
        int defenseRoll = playerB.rollDefenseDice();
        int attackDamage = attackRoll * playerA.getAttack();
        int defenseDamage = defenseRoll * playerB.getStrength();
        int damage = attackDamage - defenseDamage;

        int expectedHealth = initialHealthB;
        if (damage > 0) {
            expectedHealth -= damage;
        }

        // Ensure that playerB's health has decreased by the expected amount
        assertEquals(expectedHealth, playerB.getHealth());
    }

    /**
     * Test the determineFirstAttacker method.
     * Ensures that the correct player is determined as the first attacker based on their health.
     */
    @Test
    public void testDetermineFirstAttacker(){
        Player playerA = new Player(50, 5, 10); // Player A has less health and will attack first
        Player playerB = new Player(100, 10, 5); // Player B has more health
        Arena arena = new Arena(playerA, playerB);
        Player firstAttacker = arena.determineFirstAttacker();
        assertEquals(playerA, firstAttacker);
    }
}
