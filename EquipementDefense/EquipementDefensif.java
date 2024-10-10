package EquipementDefense;

import Cases.Case;
import Personnages.Personnage;

public abstract class EquipementDefensif implements Case {
    private String name;
    private String type;
    private int defense;

    public EquipementDefensif() {
        this.name = "unknown";
        this.type = "unknown";
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
    }

    @Override
    public String toString() {
        String message = "Case: Item\n\u001b[0mVous obtenez un " + this.type + ": \"" + this.name + "\" +"
                + this.defense
                + "🛡️";
        return message;
    }
}