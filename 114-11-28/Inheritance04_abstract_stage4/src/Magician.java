public class Magician extends RangedRole implements Healable {

    public Magician(String name, int hp) {
        super(name, hp);
    }

    @Override
    public int getHealPower() {
        return 10;
    }

    @Override
    public void heal(Role target) {
        System.out.println("💚 光明法師 施放治療魔法，治療 " + target.getName());
        System.out.println("✨ 恢復 " + getHealPower() + " 點生命值 (" + target.getHp() + " → " + (target.getHp() + getHealPower()) + ")");
        target.receiveHeal(getHealPower());
    }
}








