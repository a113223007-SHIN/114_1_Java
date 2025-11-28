public class Paladin extends SwordsMan implements Defendable, Healable {

    private int holyPower = 100;

    public Paladin(String name, int hp) {
        super(name, hp);
    }

    @Override
    public int getDefense() {
        return 12;
    }

    @Override
    public int getHealPower() {
        return 12;
    }

    @Override
    public void heal(Role target) {
        System.out.println("💚✨ 聖騎士 施放聖光治療 " + target.getName());
        System.out.println("🌟 神聖的光芒包圍著 " + target.getName());
        target.receiveHeal(getHealPower());

        int before = holyPower;
        holyPower += 10;
        System.out.println("🙏 聖騎士 感謝聖光的庇護。");
        System.out.println("🌟 恢復 10 點聖能 (" + before + " → " + holyPower + ")");
    }

    public int getHolyPower() {
        return holyPower;
    }
}



