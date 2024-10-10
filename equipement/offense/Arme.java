package equipement.offense;

public class Arme extends EquipementOffensif {

    public Arme() {
        this("Aucune", 0);
    }

    public Arme(String name, int atk) {
        super(name, "Arme", atk);
    }
}