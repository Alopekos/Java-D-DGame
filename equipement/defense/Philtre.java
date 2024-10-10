package equipement.defense;

public class Philtre extends EquipementDefensif {
    public Philtre() {
        this("Aucun");
    }

    public Philtre(String name) {
        super(name, "Philtre", 10);
    }
}