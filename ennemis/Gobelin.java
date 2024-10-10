package ennemis;

public class Gobelin extends Ennemi {

    public Gobelin() {
        this.setName("Gobelin");
        this.setHp(6);
        this.setAtk(1);
    }

    @Override
    public String toString() {
        String msg = "Case: Gobelin";
        return msg;
    }
}