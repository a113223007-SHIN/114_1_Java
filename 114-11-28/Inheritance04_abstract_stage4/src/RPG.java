public class RPG {

    public static void main(String[] args) {

        Role swordsman = new SwordsMan("光明劍士", 100);
        Role shield = new ShieldSwordsMan("持盾劍士", 100);
        Paladin paladin = new Paladin("聖騎士", 110);
        Magician magician = new Magician("光明法師", 100);

        System.out.println("════════════════════════════════════════");
        System.out.println("🎮 RPG 遊戲 - 第四階段 展示：介面的應用");
        System.out.println("════════════════════════════════════════");

        System.out.println("\n📋 類別與介面結構：");
        System.out.println("Role (抽象類別)");
        System.out.println("├─ MeleeRole");
        System.out.println("│  ├─ SwordsMan");
        System.out.println("│  ├─ ShieldSwordsMan (實作 Defendable)");
        System.out.println("│  └─ Paladin (實作 Defendable + Healable) ⭐");
        System.out.println("└─ RangedRole");
        System.out.println("   ├─ Magician (實作 Healable)");
        System.out.println("   └─ Archer");

        System.out.println("\n介面 (Interface)：");
        System.out.println("├─ Defendable：防禦能力");
        System.out.println("└─ Healable：治療能力");

        System.out.println("\n════════════════════════════════════════");
        System.out.println("🔍 介面能力展示");
        System.out.println("════════════════════════════════════════");

        System.out.println("\n【可防禦角色 (Defendable)】");
        if (shield instanceof Defendable d1) {
            System.out.println("✅ 持盾劍士 - 防禦力：" + d1.getDefense() + " (可防禦：true)");
        }
        if (paladin instanceof Defendable d2) {
            System.out.println("✅ 聖騎士 - 防禦力：" + d2.getDefense() + " (可防禦：true)");
        }

        System.out.println("\n【可治療角色 (Healable)】");
        if (magician instanceof Healable h1) {
            System.out.println("✅ 光明法師 - 治療力：" + h1.getHealPower() + " (可治療：true)");
        }
        if (paladin instanceof Healable h2) {
            System.out.println("✅ 聖騎士 - 治療力：" + h2.getHealPower() + " (可治療：true)");
        }

        System.out.println("\n【多重能力角色】");
        System.out.println("⭐ 聖騎士 - 同時擁有防禦和治療能力！");

        System.out.println("\n════════════════════════════════════════");
        System.out.println("⚔️ 戰鬥開始！");
        System.out.println("════════════════════════════════════════");

        System.out.println("\n━━━━━━━━━━ 第 1 回合 ━━━━━━━━━━");
        System.out.println("🙏 聖騎士 低聲祈禱，聖光開始聚集...");
        System.out.println("✨ 聖劍和聖盾都散發出神聖的光芒。");
        System.out.println("📊 聖能值：100 / 100");

        paladin.heal(swordsman);

        System.out.println("\n━━━━━━━━━━ 第 2 回合 ━━━━━━━━━━");
        System.out.println("📖 光明法師 翻開魔法書，開始吟唱古老的咒語...");
        System.out.println("✨ 魔法能量在周圍凝聚，空氣中閃爍著神秘的光芒。");

        magician.heal(paladin);
    }
}





