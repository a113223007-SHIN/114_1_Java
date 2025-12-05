package com.rpg.roles.ranged;

public class Archer extends RangedRole {

    public Archer(String name, int health, int attackPower, int range, int maxEnergy) {
        super(name, health, attackPower, range, maxEnergy);
    }

    public void shoot(RangedRole target) {
        int dmg = getAttackPower();
        target.takeDamage(dmg);
        System.out.println(getName() + " shoots " + target.getName() + " for " + dmg + " damage.");
    }
}



