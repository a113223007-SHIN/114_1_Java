package com.rpg.roles.ranged;

import com.rpg.core.Role;

public abstract class RangedRole extends Role {

    private int range;
    private int maxEnergy;
    private int currentEnergy;

    public RangedRole(String name, int health, int attackPower, int range, int maxEnergy) {
        super(name, health, attackPower);
        this.range = range;
        this.maxEnergy = maxEnergy;
        this.currentEnergy = maxEnergy;
    }

    public int getRange() { return range; }

    public int getCurrentEnergy() { return currentEnergy; }

    public void useEnergy(int amount) {
        currentEnergy = Math.max(0, currentEnergy - amount);
    }

    public void recoverEnergy(int amount) {
        currentEnergy = Math.min(maxEnergy, currentEnergy + amount);
    }
}




