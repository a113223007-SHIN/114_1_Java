public abstract class MeleeRole extends Role {
    private int armor;
    private String weaponType;

    public MeleeRole(String name, int maxHealth, int attackPower, int armor, String weaponType) {
        super(name, maxHealth, attackPower);
        this.armor = armor;
        this.weaponType = weaponType;
    }

    public int getArmor() { return armor; }
    public String getWeaponType() { return weaponType; }

    /**
     * 護甲在受傷時減免固定數值（簡單模型）
     */
    @Override
    public void takeDamage(int damage) {
        int reduced = Math.max(0, damage - armor);
        System.out.println("[護甲減免] 原始傷害：" + damage + "，護甲：" + armor + "，實際傷害：" + reduced);
        super.takeDamage(reduced);
    }
}

