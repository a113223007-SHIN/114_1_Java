package com.rpg.roles.melee;

import com.rpg.core.Role;
import com.rpg.interfaces.Defendable;
import com.rpg.interfaces.Healable;

public class Paladin extends MeleeRole implements Defendable, Healable {

    private int defenseCapacity;
    private int healPower;
    private int holyPower;

    public Paladin(String name, int health, int attackPower, int armor,
                   int defenseCapacity, int healPower, int holyPower) {
        super(name, health, attackPower, armor);
        this.defenseCapacity = defenseCapacity;
        this.healPower = healPower;
        this.holyPower = holyPower;
    }

    @Override
    public void heal(Role target) {
        target.setHealth(target.getHealth() + healPower);
        System.out.println(getName() + " heals " + target.getName() + " for " + healPower + " HP.");
    }

    @Override
    public int getHealPower() {
        return healPower;
    }

    @Override
    public void defend() {
        System.out.println(getName() + " defends with holy shield (capacity " + defenseCapacity + ").");
    }
}










