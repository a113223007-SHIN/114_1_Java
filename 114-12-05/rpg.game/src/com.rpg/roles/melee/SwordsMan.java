package com.rpg.roles.melee;

public class SwordsMan extends MeleeRole {

    public SwordsMan(String name, int health, int attackPower, int armor) {
        super(name, health, attackPower, armor);
    }

    public void attack(MeleeRole target) {
        int dmg = getAttackPower();
        dmg = target.reduceDamageByArmor(dmg);
        target.takeDamage(dmg);
        System.out.println(getName() + " attacks " + target.getName() + " for " + dmg + " damage.");
    }
}











