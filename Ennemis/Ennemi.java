package Ennemis;

import Cases.Case;
import Personnages.Personnage;

public class Ennemi implements Case {
    private String name;
    private int atk;
    private int hp;

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
            System.out.println("Vous avez abbatu l'ennemi");
        } else {
            personnage.setNiveauDeVie(personnage.getNiveauDeVie() - this.atk);
            if (personnage.getNiveauDeVie() > 0) {

                System.out.println("Il ne vous reste plus que " + personnage.getNiveauDeVie() + "PDV.");
            }

        }
    }

    @Override
    public String toString() {
        String msg = "Vous rencontrez un " + this.name;
        return msg;
    }
}