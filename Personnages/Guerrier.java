package Personnages;

public class Guerrier extends Personnage {

    public Guerrier(String name) {
        this.setName(name);
        this.setClass("guerrier");
        this.setForceDAttaque((int) ((Math.random() * 5) + 5));
        this.setNiveauDeVie((int) ((Math.random() * 5) + 5));
    }

}