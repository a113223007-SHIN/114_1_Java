package com.rpg.roles.ranged;

import com.rpg.core.Role;
import com.rpg.interfaces.Healable;

public class Magician extends RangedRole implements Healable {

    private int healPower;

    public Magician(String name, int health, int attackPower,
                    int healPower, int range, int maxEnergy) {
        super(name, health, attackPower, range, maxEnergy);
        this.healPower = healPower;
    }

    @Override
    public void heal(Role target) {
        target.setHealth(target.getHealth() + healPower);
        System.out.println(getName() + " casts heal on " + target.getName() + " for " + healPower + " HP.");
    }

    @Override
    public int getHealPower() {
        return healPower;
    }
}









