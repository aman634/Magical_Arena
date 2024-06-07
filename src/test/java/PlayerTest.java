import org.arenaGame.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for the Player class.
 */
public class PlayerTest {

    private Player player;

    /**
     * Sets up the test fixture.
     * Creates player instances and initializes the arena.
     */
    @BeforeEach
    public void setup() {
        player = new Player(50, 5, 10); // Player A has less health and will attack first
    }

    /**
     * Test the takeDamage method.
     * Verifies that the player's health decreases correctly when taking damage.
     */
    @Test
    public void testTakeDamage() {
        player.takeDamage(20);
        assertEquals(30, player.getHealth());
        player.takeDamage(40);
        assertEquals(0, player.getHealth());
    }

    /**
     * Test the isAlive method.
     * Checks if the player is alive when their health is above zero and dead when their health reaches zero.
     */
    @Test
    public void testIsAlive() {
        Player player = new Player(50, 5, 10);
        assertTrue(player.isAlive());
        player.takeDamage(50);
        assertFalse(player.isAlive());
    }

    /**
     * Test the rollAttackDice method.
     * Ensures that the rollAttackDice method returns values between 1 and 6.
     */
    @Test
    public void testRollAttackDice(){
        Player player = new Player(50,5,10);
        int rolledAttackValue=player.rollAttackDice();
        assertTrue(rolledAttackValue >= 1 && rolledAttackValue <= 6);
    }

    /**
     * Test the rollDefenseDice method.
     * Checks that the rollDefenseDice method returns values between 1 and 6.
     */
    @Test
    public void testRollDefenseDice(){
        Player player = new Player(50,5,10);
        int rolledDefenceValue = player.rollDefenseDice();
        assertTrue(rolledDefenceValue >= 1 && rolledDefenceValue <= 6);
    }
}
