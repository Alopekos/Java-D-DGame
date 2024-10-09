package EquipementDefense;

public class Bouclier extends EquipementDefensif {
    public Bouclier() {
        this.setName("Aucun");
        this.setType("Bouclier");
        this.setDefense(0);
    }

    public Bouclier(String name) {
        this.setName(name);
        this.setType("Bouclier");
        this.setDefense(15);
    }
}