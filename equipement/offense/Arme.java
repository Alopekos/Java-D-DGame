package equipement.offense;

public class Arme extends EquipementOffensif {

    public Arme() {
        this("Aucune");
    }

    public Arme(String name) {
        super(name, "Arme", 15);
    }
}