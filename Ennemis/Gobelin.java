package Ennemis;

public class Gobelin extends Ennemi {

    public Gobelin() {
        this.setName("Gobelin");
        this.setHp(6);
        this.setAtk(1);
    }

    @Override
    public String toString() {
        String msg = "Gobelin";
        return msg;
    }
}