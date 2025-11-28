public class ShieldSwordsMan extends SwordsMan implements Defendable {

    public ShieldSwordsMan(String name, int hp) {
        super(name, hp);
    }

    @Override
    public int getDefense() {
        return 10;
    }
}






