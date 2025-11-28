public class ShieldSwordsMan extends SwordsMan implements Defendable {

    private int defenseCapacity;

    public ShieldSwordsMan(String name, int health, int attackPower, int defenseCapacity) {
        super(name, health, attackPower);
        this.defenseCapacity = defenseCapacity;
    }

    @Override
    public void prepareBattle() {
        System.out.println("🛡️  " + getName() + " 調整盾牌姿勢，準備迎敵！");
    }

    @Override
    public void attack(Role target) {
        int reducedDamage = getAttackPower() - 5;
        System.out.println("🛡️  " + getName() + " 使用盾牌輔助攻擊 " + target.getName() + "！");
        target.takeDamage(Math.max(1, reducedDamage));
    }

    @Override
    public void defend() {
        setHealth(getHealth() + defenseCapacity);
        System.out.println("🛡️  " + getName() + " 使用盾牌防禦，恢復 " + defenseCapacity + " 點生命值。");
    }

    @Override
    public void afterBattle() {
        System.out.println("🛡️  " + getName() + " 保持防禦姿態。");
    }

    @Override
    public void onDeath() {
        System.out.println("💀 " + getName() + " 的盾牌重重落地...");
    }
}





