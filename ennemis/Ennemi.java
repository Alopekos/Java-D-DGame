package ennemis;

import cases.Case;
import personnages.Personnage;

public abstract class Ennemi implements Case {
    private String name;
    private int atk;
    private int hp;

    protected Ennemi(String name, int atk, int hp) {
        this.name = name;
        this.atk = atk;
        this.hp = hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return this.name;
    }

    public int getAtk() {
        return this.atk;
    }

    public int getHp() {
        return this.hp;
    }

    @Override
    public void interact(Personnage personnage) {
        if (personnage.getAttack() >= this.hp) {
            System.out.println("\tUn " + this.name + " vous attaque !!!");
            System.out.println(printArt());
            System.out.println("Mais il ne fait pas le poids face à vous, vous le pourfendez.");
        } else {
            personnage.setNiveauDeVie(personnage.getNiveauDeVie() - this.atk);
            if (personnage.getNiveauDeVie() > 0) {
                System.out.println("Un " + this.name + " vous attaque !!!");
                System.out.println(printArt());
                System.out.println(
                        "Il vous assène un coup vous enlevant " + this.atk + "PDV. \nIl ne vous reste que "
                                + personnage.getNiveauDeVie() + "PDV.");
            }

        }
    }

    @Override
    public String toString() {
        return "";

    }
}