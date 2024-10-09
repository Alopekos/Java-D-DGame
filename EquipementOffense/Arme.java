package EquipementOffense;

public class Arme extends EquipementOffensif {

    public Arme() {
        this.setName("Aucune");
        this.setType("Arme");
        this.setForceDAttaque(0);
    }

    public Arme(String name) {
        this.setName(name);
        this.setType("Arme");
        this.setForceDAttaque(15);
    }
}