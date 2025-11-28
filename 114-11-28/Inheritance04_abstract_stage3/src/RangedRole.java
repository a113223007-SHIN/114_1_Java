public abstract class RangedRole extends Role {

    public RangedRole(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void prepareBattle() {
        System.out.println("🏹 " + getName() + " 舉起遠程武器……");
    }
}

