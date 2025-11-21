public class Magician extends Role {

    private int mana;

    public Magician(String name, int health, int attackPower, int mana) {
        super(name, health, attackPower);
        this.mana = mana;
    }

    @Override
    public void prepareBattle() {
        System.out.println("📖 " + getName() + " 翻開魔法書，開始吟唱古老的咒語...");
        System.out.println("✨ 魔法能量在周圍凝聚，空氣中閃爍著神秘的光芒。");
    }

    @Override
    public void attack(Role target) {
        System.out.println("✨ " + getName() + " 施放魔法攻擊 " + target.getName() + "！");
        target.takeDamage(getAttackPower());
    }

    public void heal(Role ally) {
        int healAmount = 10;
        ally.setHealth(ally.getHealth() + healAmount);
        System.out.println("💖 " + getName() + " 對 " + ally.getName() + " 施放治療術，恢復 " + healAmount + " 點生命值。");
    }

    @Override
    public void afterBattle() {
        System.out.println("🧘 " + getName() + " 閉目冥想，恢復消耗的魔力。");
    }

    @Override
    public void showSpecialSkill() {
        System.out.println("🔥 " + getName() + " 使用技能：火球術！");
    }

    @Override
    public void onDeath() {
        System.out.println("💀 " + getName() + " 的生命之火熄滅了...");
        System.out.println("✨ " + getName() + " 的身體化為無數魔法粒子，消散在空氣中。");
        System.out.println("🌟 魔法書掉落在地上，微微發光。");
    }
}

