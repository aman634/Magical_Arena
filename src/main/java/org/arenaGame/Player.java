package org.arenaGame;

/**
 * Represents a player in the Magical Arena.
 */

public class Player {

    private int health;
    private int strength;
    private int attack;


    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    /**
     * Rolls the attacking dice and returns the result.
     */
    public int rollAttackDice() {
        return (int)(Math.random() * 6) + 1;
    }

    /**
     * Rolls the defending dice and returns the result.
     */
    public int rollDefenseDice() {
        return (int)(Math.random() * 6) + 1;
    }

    /**
     * Takes damage and reduces the player's health.
     *
     * @param damage the amount of damage to take
     */
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }

    /**
     * To check the player is alive or not
     *
     */
    public boolean isAlive() {
        return this.health > 0;
    }

    // Getters for health, strength, and attack
    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }
}
