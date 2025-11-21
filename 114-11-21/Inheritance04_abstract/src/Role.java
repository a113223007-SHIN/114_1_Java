public abstract class Role {
    // 角色名稱
    private String name;
    // 生命值
    private int health;
    // 攻擊力
    private int attackPower;
    /**
     * 展示角色的特殊技能
     * 為什麼設計成抽象方法？
     * 1. 每個角色都有特殊技能（共同規格）
     * 2. 但每個角色的技能內容都不同（個別實作）
     * 3. 我們無法在 Role 類別中提供一個「適合所有角色」的預設實作
     */
    public abstract void showSpecialSkill();
    // 建構子：初始化角色的名稱、生命值和攻擊力
    public Role(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    // 取得角色名稱
    public String getName() {
        return name;
    }

    // 取得生命值
    public int getHealth() {
        return health;
    }

    // 取得攻擊力
    public int getAttackPower() {
        return attackPower;
    }
    // 設定生命值
    public void setHealth(int health) {
        this.health = health;
    }

    // 檢查角色是否存活
    public boolean isAlive() {
        return health > 0;
    }

    public abstract void attack(Role opponent);


    @Override
    public String toString() {
        return "角色名稱: " + name + ", 生命值: " + health;
    }

    public class Priest extends Role {
        private int groupHealPower;

        public Priest(String name, int health, int attackPower, int groupHealPower) {
            super(name, health, attackPower);
            this.groupHealPower = groupHealPower;
        }

        @Override
        public void attack(Role opponent) {
            opponent.setHealth(opponent.getHealth() - this.getAttackPower());
            System.out.println(this.getName() + " 發出神聖之光攻擊 " +
                    opponent.getName() + " 造成 " +
                    this.getAttackPower() + " 點傷害。" + opponent);
        }

        @Override
        public void showSpecialSkill() {
            System.out.println("╔═════════════════════════════╗");
            System.out.println("║ " + this.getName() + " 的特殊技能        ║");
            System.out.println("╠═════════════════════════════╣");
            System.out.println("║ 技能名稱：群體治療          ║");
            System.out.println("║ 技能描述：治療所有隊友      ║");
            System.out.println("║ 治療量：" + groupHealPower + " 點生命值       ║");
            System.out.println("╚═════════════════════════════╝");
        }
    }


    // 在 Role 類別中
    public void showBasicInfo() {
        System.out.println("角色：" + name);
        System.out.println("生命值：" + health);
        System.out.println("攻擊力：" + attackPower);
    }
    public class SwordsMan extends Role {
        // 建構子
        public SwordsMan(String name, int health, int attackPower) {
            super(name, health, attackPower);
        }

        // 攻擊對手(劍客/魔法師)
        @Override
        public void attack(Role opponent) {
            opponent.setHealth(opponent.getHealth() - this.getAttackPower());
            System.out.println(this.getName() + " 揮劍攻擊 " + opponent.getName() +
                    " 造成 " + this.getAttackPower() + " 點傷害。" + opponent);
        }

        // ★★★ 必須實作的抽象方法 ★★★
        @Override
        public void showSpecialSkill() {
            System.out.println(getName() + " 使用特殊技能：旋風斬！");
        }
    }

}
