package EquipementDefense;

public class Philtre extends EquipementDefensif {
    public Philtre() {
        this.setName("Aucun");
        this.setType("Philtre");
        this.setDefense(0);
    }

    public Philtre(String name) {
        this.setName(name);
        this.setType("Philtre");
        this.setDefense(10);
    }
}