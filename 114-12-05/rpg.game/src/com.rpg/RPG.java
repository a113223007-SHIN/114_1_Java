package com.rpg;

import com.rpg.roles.melee.*;
import com.rpg.roles.ranged.*;

public class RPG {
    public static void main(String[] args) {

        SwordsMan s = new SwordsMan("劍士", 100, 20, 5);
        Magician m = new Magician("法師", 80, 15, 10, 8, 100);
        Paladin p = new Paladin("聖騎士", 120, 12, 8, 20, 15, 5);
        ShieldSwordsMan ss = new ShieldSwordsMan("盾劍士", 110, 18, 6, 25);

        System.out.println(s);
        System.out.println(m);
        System.out.println(p);
        System.out.println(ss);

        s.attack(ss);
        ss.defend();
        p.heal(s);
        m.heal(p);
    }
}








