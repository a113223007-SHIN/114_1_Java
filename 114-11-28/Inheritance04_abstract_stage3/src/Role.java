public abstract class Role {

    private String name;
    private int health;
    private int attackPower;

    public Role(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttackPower() { return attackPower; }

    public void setHealth(int health) {
        this.health = Math.max(0, health);
        if (this.health == 0) {
            onDeath();
        }
    }

    public void takeDamage(int damage) {
        System.out.println(name + " 受到 " + damage + " 點傷害！");
        setHealth(health - damage);
    }

    // 三個抽象方法
    public abstract void prepareBattle();
    public abstract void attack(Role target);
    public abstract void afterBattle();
    public abstract void onDeath();

}





