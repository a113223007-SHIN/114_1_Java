public abstract class priest extends Role {

    private int groupHealPower;

    public priest(String name, int health, int attackPower, int groupHealPower) {
        super(name, health, attackPower);
        this.groupHealPower = groupHealPower;
    }

    @Override
    public void attack(Role opponent) {
        opponent.takeDamage(getAttackPower());
        System.out.println(getName() + " 發出神聖之光攻擊 " +
                opponent.getName() + " 造成 " + getAttackPower() + " 點傷害。" + opponent);
    }

    @Override
    public void showSpecialSkill() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ " + getName() + " 的特殊技能        ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║ 技能名稱：群體治療          ║");
        System.out.println("║ 技能描述：治療所有隊友      ║");
        System.out.println("║ 治療量：" + groupHealPower + " 點生命值       ║");
        System.out.println("╚═════════════════════════════╝");
    }

    @Override
    public void onDeath() {
        System.out.println(getName() + " 已倒下，祈禱聲逐漸消散。");
    }

    @Override
    public void prepareBattle() {
        System.out.println(getName() + " 默禱準備迎戰。");
    }

    @Override
    public void afterBattle() {
        System.out.println(getName() + " 幫隊友恢復精神。");
    }
}
