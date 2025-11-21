public class Role extends Object {
    // 角色名稱
    private String name;
    // 角色生命值
    private int health;

    // 攻擊力
    private int attackPower;


    /**
     * 建構子：建立一個 Role 物件
     *
     * @param name        角色名稱
     * @param health      初始生命值
     * @param attackPower 攻擊力
     */
    public Role(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;

    }

    // 取得角色名稱
    public String getName() {
        return name;

    }

    // 取得生命值
    public int getHealth() {
        return health;
    }

    // 設定生命值
    public void setHealth(int health) {
        this.health = health;

    }

    // 取得攻擊力
    public int getAttackPower() {
        return attackPower;

    }



    //攻擊對手
    public void attack(SwordsMan opponent) {
        opponent.setHealth(opponent.getHealth() - this.attackPower);
        System.out.println(this.name + " 攻擊 " + opponent.getName() + "，造成 " + this.attackPower + " 點傷害。");
    }

}
