package com.rpg.core;

public abstract class Role {
    private String name;
    private int health;
    private int attackPower;

    public Role(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttackPower() { return attackPower; }

    public void setHealth(int health) {
        this.health = Math.max(0, health);
    }

    public void takeDamage(int dmg) {
        setHealth(this.health - dmg);
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public String toString() {
        return String.format("%s (HP:%d ATK:%d)", name, health, attackPower);
    }
}








