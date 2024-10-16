package ennemis;

import cases.Case;
import personnages.Personnage;
import menu.Menu;
import java.util.*;

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
    public int interact(Personnage personnage, int tileNumber) {
        Menu menu = new Menu();
        boolean isFightOver = false;
        while (!isFightOver) {
            menu.clearScreen();
            System.out.println("\tUn " + this.name + " vous attaque !!!");
            System.out.println(printArt());
            String choice = menu.fightMenu();

            switch (choice) {
                case "1":
                    if (personnage.getAttack() >= this.hp) {
                        System.out.println("Le monstre ne fait pas le poids face à vous, vous le pourfendez.");
                        isFightOver = true;
                    } else {
                        personnage.setNiveauDeVie(personnage.getNiveauDeVie() - this.atk);
                        if (personnage.getNiveauDeVie() > 0) {
                            System.out.println(
                                    "Il vous assène un coup vous enlevant " + this.atk + "PDV. \nIl ne vous reste que "
                                            + personnage.getNiveauDeVie() + "PDV.");
                        } else {
                            isFightOver = true;
                        }

                    }
                    break;
                case "2":
                    Random random = new Random();
                    tileNumber -= 1 + random.nextInt(6);
                    System.out.println("Vous vous enfuyez en case " + tileNumber + ".");
                    isFightOver = true;
                    break;

                default:
                    break;
            }
        }
        return tileNumber;
    }

    @Override
    public String toString() {
        return "";

    }
}