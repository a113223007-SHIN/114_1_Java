public class SwordsMan extends Role {

    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void prepareBattle() {
        System.out.println("🗡️  " + getName() + " 擦拭劍刃，劍身反射出凜冽的寒光...");
    }

    @Override
    public void attack(Role target) {
        System.out.println("⚔️  " + getName() + " 揮劍攻擊 " + target.getName() + "！");
        target.takeDamage(getAttackPower());
    }

    @Override
    public void afterBattle() {
        System.out.println("🗡️  " + getName() + " 將劍收入劍鞘。");
    }

    @Override
    public void showSpecialSkill() {
        System.out.println("✨ " + getName() + " 使用技能：劍氣斬！");
    }

    @Override
    public void onDeath() {
        System.out.println("💀 " + getName() + " 倒下了...");
    }
}





