package personnages;

public class Mage extends Personnage {

    public Mage(String name) {
        this.setName(name);
        this.setClass("mage");
        this.setForceDAttaque((int) ((Math.random() * 7) + 8));
        this.setNiveauDeVie((int) ((Math.random() * 3) + 3));
    }
}