package equipement.defense;

public class Bouclier extends EquipementDefensif {
    public Bouclier() {
        this("Aucun");
    }

    public Bouclier(String name) {
        super(name, "Bouclier", 15);
    }
}