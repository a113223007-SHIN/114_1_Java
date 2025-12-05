package com.rpg.roles.melee;

import com.rpg.interfaces.Defendable;

public class ShieldSwordsMan extends SwordsMan implements Defendable {

    private int defenseCapacity;

    public ShieldSwordsMan(String name, int health, int attackPower, int armor, int defenseCapacity) {
        super(name, health, attackPower, armor);
        this.defenseCapacity = defenseCapacity;
    }

    @Override
    public void defend() {
        System.out.println(getName() + " raises shield! Defense capacity: " + defenseCapacity);
    }
}









