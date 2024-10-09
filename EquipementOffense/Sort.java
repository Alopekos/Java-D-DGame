package EquipementOffense;

public class Sort extends EquipementOffensif {
    public Sort() {
        this.setName("Aucun");
        this.setType("Sort");
        this.setForceDAttaque(0);
    }

    public Sort(String name) {
        this.setName(name);
        this.setType("Sort");
        this.setForceDAttaque(10);
    }
}