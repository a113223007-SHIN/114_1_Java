public class Magician extends RangedRole implements Healable {

    private int mana;
    private int magicPower;

    public Magician(String name, int health, int attackPower, int mana, int magicPower) {
        super(name, health, attackPower);
        this.mana = mana;
        this.magicPower = magicPower;
    }

    @Override
    public void prepareBattle() {
        System.out.println("🔮 " + getName() + " 集中精神，魔力開始凝聚……");
    }

    @Override
    public void attack(Role target) {
        if (mana >= 10) {
            System.out.println("✨ " + getName() + " 對 " + target.getName() + " 施放魔法攻擊！");
            target.takeDamage(getAttackPower() + magicPower);
            mana -= 10;
        } else {
            System.out.println("❗ " + getName() + " 魔力不足，只能使用普通攻擊！");
            target.takeDamage(getAttackPower());
        }
    }

    @Override
    public void afterBattle() {
        System.out.println("🔮 " + getName() + " 調整呼吸，慢慢恢復魔力。");
        mana += 5;
    }

    @Override
    public void heal(Role target) {
        int amount = 20;
        target.setHealth(target.getHealth() + amount);
        System.out.println("💖 " + getName() + " 對 " + target.getName() + " 施放治癒術，恢復 " + amount + " 點生命值！");
    }

    @Override
    public void onDeath() {
        System.out.println("💀 " + getName() + " 的魔杖掉落地面，光芒逐漸熄滅……");
    }
}







