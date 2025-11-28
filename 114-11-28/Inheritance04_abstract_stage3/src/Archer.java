public class Archer extends Role {

    public Archer(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void prepareBattle() {
        System.out.println("🏹 " + getName() + " 拉開弓弦，準備射擊！");
    }

    @Override
    public void attack(Role target) {
        System.out.println("🏹 " + getName() + " 射出箭矢攻擊 " + target.getName() + "！");
        target.takeDamage(getAttackPower());
    }

    @Override
    public void afterBattle() {
        System.out.println("🏹 " + getName() + " 收起弓。");
    }

    @Override
    public void onDeath() {
        System.out.println("💀 " + getName() + " 的弓箭散落一地...");
    }
}

