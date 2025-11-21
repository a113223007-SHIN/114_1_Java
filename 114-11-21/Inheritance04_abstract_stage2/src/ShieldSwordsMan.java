public class ShieldSwordsMan extends SwordsMan {

    private int defenseCapacity;

    public ShieldSwordsMan(String name, int health, int attackPower, int defenseCapacity) {
        super(name, health, attackPower);
        this.defenseCapacity = defenseCapacity;
    }

    @Override
    public void prepareBattle() {
        System.out.println("🛡️  " + getName() + " 調整盾牌姿勢，做好迎戰準備...");
    }

    @Override
    public void attack(Role target) {
        int reducedDamage = getAttackPower() - 5;
        System.out.println("🛡️  " + getName() + " 使用盾牌輔助揮劍攻擊 " + target.getName() + "！");
        target.takeDamage(reducedDamage);
    }

    @Override
    public void afterBattle() {
        System.out.println("🛡️  " + getName() + " 收回盾牌，保持防禦姿勢。");
    }

    public void defence() {
        setHealth(getHealth() + defenseCapacity);
        System.out.println("🛡️  " + getName() + " 使用盾牌防禦，恢復 " + defenseCapacity + " 點生命值。");
    }

    @Override
    public void onDeath() {
        System.out.println("💀 " + getName() + " 的盾牌掉落地面，發出沉悶的聲響...");
    }
}


