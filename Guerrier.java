public class Guerrier extends Personnage {

    public Guerrier(String name) {
        this.setName(name);
        this.setClass("guerrier");
        this.setForceDAttaque(10);
        this.setNiveauDeVie(10);
    }

}