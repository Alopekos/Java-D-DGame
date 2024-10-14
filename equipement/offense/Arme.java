package equipement.offense;

public class Arme extends EquipementOffensif {

    public Arme() {
        this("Epée en bois", 0);
    }

    public Arme(String name, int atk) {
        super(name, "Arme", atk);
    }
}