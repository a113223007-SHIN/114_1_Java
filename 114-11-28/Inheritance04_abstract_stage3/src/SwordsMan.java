public class SwordsMan extends Role {

    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void prepareBattle() {
        System.out.println("⚔️  " + getName() + " 抽出長劍，擺出戰鬥姿勢！");
    }

    @Override
    public void attack(Role target) {
        System.out.println("⚔️  " + getName() + " 用劍砍向 " + target.getName() + "！");
        target.takeDamage(getAttackPower());
    }

    @Override
    public void afterBattle() {
        System.out.println("⚔️  " + getName() + " 收起長劍。");
    }

    @Override
    public void onDeath() {
        System.out.println("💀 " + getName() + " 的長劍掉落地面...");
    }
}








