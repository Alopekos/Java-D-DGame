package Ennemis;

public class Sorcier extends Ennemi {

    public Sorcier() {
        this.setName("Sorcier");
        this.setHp(9);
        this.setAtk(2);
    }

    @Override
    public String toString() {
        String msg = "Case: Sorcier";
        return msg;
    }
}