public abstract class Role {

    protected String name;
    protected int hp;

    public Role(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public void receiveHeal(int amount) {
        int before = hp;
        hp += amount;
        System.out.println("💚 恢復 " + amount + " 點生命值 (" + before + " → " + hp + ")");
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }
}






