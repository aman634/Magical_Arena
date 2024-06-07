package org.arenaGame;

/**
 * Represents the arena where players fight.
 */
public class Arena {

    private Player playerA;
    private Player playerB;

    public Arena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    /**
     * Starts the fight between the players in the arena.
     * The fight continues until one player's health reaches zero.
     */
    public void startFight() {
        Player attacker = determineFirstAttacker();
        Player defender = (attacker == playerA) ? playerB : playerA;

        while (playerA.isAlive() && playerB.isAlive()) {
            performTurn(attacker, defender);
            // Swap roles
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
        System.out.println("\n                Fight Over! Winner: " + (playerA.isAlive() ? "Player A" : "Player B"));
    }

    /**
     * Performs a single turn of attack and defense between the given players.
     *
     * @param attacker the attacking player
     * @param defender the defending player
     */
    public void performTurn(Player attacker, Player defender) {
        int attackRoll = attacker.rollAttackDice();
        int defenseRoll = defender.rollDefenseDice();
        int attackDamage = attackRoll * attacker.getAttack();
        int defenseDamage = defenseRoll * defender.getStrength();
        int damage = attackDamage - defenseDamage;

        String attackerName = (attacker == playerA) ? "PlayerA" : "PlayerB";
        String defenderName = (defender == playerA) ? "PlayerA" : "PlayerB";

        if (damage > 0) {
            defender.takeDamage(damage);
            System.out.println(attackerName + " attacked " + defenderName + " for " + damage + " damage. " + defenderName + " health: " + defender.getHealth());
        } else {
            System.out.println(attackerName + " attack was fully defended by " + defenderName);
        }
    }


    /**
     * Determines which player attacks first based on their health.
     *
     * @return the player who attacks first
     */
    public Player determineFirstAttacker() {
        return (playerA.getHealth() < playerB.getHealth()) ? playerA : playerB;
    }
}


