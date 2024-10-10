package equipement.offense;

public class Sort extends EquipementOffensif {
    public Sort() {
        this("Aucun", 0);
    }

    public Sort(String name, int atk) {
        super(name, "Sort", atk);
    }
}