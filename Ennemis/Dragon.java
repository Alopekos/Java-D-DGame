package Ennemis;

public class Dragon extends Ennemi {

    public Dragon() {
        this.setName("Dragon");
        this.setHp(15);
        this.setAtk(4);
    }

    @Override
    public String toString() {
        String msg = "Case: Dragon";
        return msg;
    }
}