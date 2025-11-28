public class Paladin extends MeleeRole implements Defendable, Healable {

    private int defenseCapacity;
    private int healPower;
    private int holyPower;      // 聖能，最大 100

    public Paladin(String name, int maxHealth, int attackPower, int armor, int defenseCapacity, int healPower, int initialHoly) {
        super(name, maxHealth, attackPower, armor, "聖劍");
        this.defenseCapacity = defenseCapacity;
        this.healPower = healPower;
        this.holyPower = Math.min(100, Math.max(0, initialHoly));
    }

    // Melee 行為實作
    @Override
    public void prepareBattle() {
        System.out.println("⚔️ " + getName() + " 以聖劍宣誓，守護同伴...");
    }

    @Override
    public void attack(Role opponent) {
        System.out.println("⚔️ " + getName() + " 用聖劍斬向 " + opponent.getName() + "！");
        opponent.takeDamage(getAttackPower());
        // 攻擊可以小幅回復聖能
        int gain = 4;
        holyPower = Math.min(100, holyPower + gain);
        System.out.println("（攻擊回復 " + gain + " 點聖能，當前聖能：" + holyPower + "/100）");
    }

    @Override
    public void afterBattle() {
        // 戰後恢復少量聖能
        int recover = 6;
        holyPower = Math.min(100, holyPower + recover);
        System.out.println("🛡️ " + getName() + " 靜心祈禱，恢復 " + recover + " 點聖能（目前：" + holyPower + "/100）。");
    }

    @Override
    public void showSpecialSkill() {
        System.out.println("🌟 " + getName() + " 使用技能：聖光庇佑（同時攻擊與治療）！");
    }

    @Override
    public void onDeath() {
        System.out.println("💀 " + getName() + " 倒下，聖光微弱地閃爍後消失...");
    }

    // Defendable 實作
    @Override
    public int getDefenseCapacity() {
        return defenseCapacity;
    }

    @Override
    public boolean canDefend() {
        return isAlive() && holyPower >= 10;
    }

    @Override
    public void defend() {
        if (!canDefend()) {
            System.out.println("❌ " + getName() + " 無法啟動防禦（聖能不足）");
            return;
        }
        int use = 10;
        holyPower = Math.max(0, holyPower - use);
        setHealth(getHealth() + getDefenseCapacity());
        System.out.println("🛡️ " + getName() + " 以聖盾防禦並恢復 " + getDefenseCapacity() + " 點生命（消耗 " + use + " 聖能）。");
    }

    // Healable 實作
    @Override
    public int getHealPower() {
        return healPower;
    }

    @Override
    public boolean canHeal() {
        return isAlive() && holyPower >= 12;
    }

    @Override
    public void heal(Role target) {
        if (!canHeal()) {
            System.out.println("❌ " + getName() + " 無法施放聖療（聖能不足）");
            return;
        }
        int cost = 12;
        holyPower = Math.max(0, holyPower - cost);
        target.setHealth(target.getHealth() + healPower);
        System.out.println("💚 " + getName() + " 以聖光治癒 " + target.getName() + "，恢復 " + healPower + " 點生命（消耗 " + cost + " 聖能）。");
    }

    // 額外 getter
    public int getHolyPower() {
        return holyPower;
    }
}

