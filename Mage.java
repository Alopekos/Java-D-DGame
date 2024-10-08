public class Mage extends Personnage {

    public Mage(String name) {
        this.setName(name);
        this.setClass("mage");
        this.setForceDAttaque(15);
        this.setNiveauDeVie(6);
    }
}