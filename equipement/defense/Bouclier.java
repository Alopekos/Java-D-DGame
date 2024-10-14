package equipement.defense;

public class Bouclier extends EquipementDefensif {
    public Bouclier() {
        this("Bouclier en bois", 0);
    }

    public Bouclier(String name, int defense) {
        super(name, "Bouclier", defense);
    }
}