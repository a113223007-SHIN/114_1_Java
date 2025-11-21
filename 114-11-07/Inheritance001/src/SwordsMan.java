//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SwordsMan extends Role {
    /**
     * 建構子：建立一個 SwordsMan 物件
     * @param name 角色名稱
     * @param health 初始生命值
     * @param attackPower 攻擊力
     */
    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    // 顯示目前生命值（繁體中文）
    public void healpower() {
        System.out.println(this.getName() + " 目前生命值: " + this.getHealth() + " 點。");
    }

    // 攻擊對手
    public void attack(SwordsMan opponent){
        // 不能將 opponent.getHealth() 當作左值，改用 getHealth() 取得再用 setHealth() 設回
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 攻擊 " + opponent.getName() + "，造成 " +
                this.getAttackPower() + " 點傷害。" );
        // 顯示被攻擊者剩餘生命值
        System.out.println(opponent.getName() + " 剩餘生命: " + opponent.getHealth() + " 點。");
    }

//    // 簡單範例主程式，展示互動（保留原有範例輸出，改為繁體中文）
//    public static void main(String[] args) {
//        System.out.printf("歡迎！這是一個劍客與魔法師互動的簡單範例。\n");
//
//        // 範例：建立劍客與魔法師並示範攻擊/治療
//        SwordsMan swords1 = new SwordsMan("Arthur", 80, 12);
//        SwordsMan swords2 = new SwordsMan("Lancelot", 90, 15);
//        Magician mage = new Magician("Merlin", 60, 8);
//
//        for (int i = 1; i <= 3; i++) {
//            System.out.println("回合 " + i + ":");
//            swords1.attack(swords2);
//            mage.attack(new Magician("Dummy", 30, 0)); // 示範魔法師攻擊
//            mage.heal(swords1);
//            System.out.println(swords1.getName() + " 生命=" + swords1.getHealth());
//        }
//    }

}