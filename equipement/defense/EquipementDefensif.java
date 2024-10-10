package equipement.defense;

import cases.Case;
import personnages.Personnage;

public abstract class EquipementDefensif implements Case {
    private String name;
    private String type;
    private int defense;

    protected EquipementDefensif(String name, String type, int defense) {
        this.name = name;
        this.type = type;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getDefense() {
        return defense;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public void interact(Personnage personnage) {
        System.out.println("Vous trouvez un item défensif");
        if (personnage.getBouclier().defense < this.defense) {
            if (personnage.getClasse().equals("mage") && this.type.equals("Philtre")
                    || personnage.getClasse().equals("guerrier") && this.type.equals("Bouclier")) {
                personnage.equipDefensive(this);
            }
        }

    }

    @Override
    public String toString() {
        String message = "Case: Item\n\u001b[0m" + this.type + ": \"" + this.name + "\" +"
                + this.defense
                + "🛡️";
        return message;
    }
}