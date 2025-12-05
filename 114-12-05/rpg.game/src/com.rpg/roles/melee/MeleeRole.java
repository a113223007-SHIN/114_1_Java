package com.rpg.roles.melee;

import com.rpg.core.Role;

public abstract class MeleeRole extends Role {

    private int armor;

    public MeleeRole(String name, int health, int attackPower, int armor) {
        super(name, health, attackPower);
        this.armor = armor;
    }

    public int getArmor() { return armor; }

    public int reduceDamageByArmor(int damage) {
        return Math.max(0, damage - armor);
    }
}







