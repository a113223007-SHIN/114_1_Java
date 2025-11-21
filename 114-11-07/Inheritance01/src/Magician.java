public class Magician extends Role {
    // 治癒力
    private int healthPower;

    /**
     * 建構子：建立一個 Magician 物件，使用預設治癒力
     */
    public Magician(String name, int health, int attackPower) {
        // 呼叫父類別 Role 的建構子
        super(name, health, attackPower);
        // 預設治癒力為20
        this.healthPower = 20;
    }

    /**
     * 建構子：建立一個 Magician 物件，允許指定治癒力
     */
    public Magician(String name, int health, int attackPower, int healthPower) {
        super(name, health, attackPower);
        this.healthPower = healthPower;
    }

    //顯示生命值
    public void healpower() {
        System.out.println(this.getName() + " 生命值: " + this.getHealth());
    }

    // 取得治癒力
    public int getHealPower() {
        return healthPower;
    }

    // 攻擊對手（接受 Role，使魔法師可攻擊 SwordsMan 或其他 Role）
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 攻擊 " + opponent.getName() + "，造成 " + this.getAttackPower() + " 點傷害。" );
        System.out.println(opponent.getName() + " 剩餘生命: " + opponent.getHealth() + " 點。" );
    }

    // 治療劍客
    public void heal(SwordsMan ally){
        int healAmount = getHealPower();
        // 使用 SwordsMan 的 getter/setter 以維持封裝性
        ally.setHealth(ally.getHealth() + healAmount);
        System.out.println(this.getName() + " 治療 " + ally.getName() + "，恢復 " + healAmount + " 點生命。" );
        // 顯示被治療者剩餘生命值
        System.out.println(ally.getName() + " 目前生命: " + ally.getHealth() + " 點。" );
    }
}
