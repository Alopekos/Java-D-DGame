package EquipementOffense;

import Cases.Case;
import Personnages.Personnage;

public abstract class EquipementOffensif implements Case {
    private String name;
    private String type;
    private int forceDAttaque;

    public EquipementOffensif() {
        this.name = "aucun";
        this.type = "aucun";
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAttack() {
        return forceDAttaque;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setForceDAttaque(int atk) {
        this.forceDAttaque = atk;
    }

    @Override
    public void interact(Personnage personnage) {
        System.out.println("Vous trouvez un item offensif");
    }

    @Override
    public String toString() {
        String message = "Case: Item\n\u001b[0mVous obtenez une " + this.type + ": \"" + this.name + "\" +"
                + this.forceDAttaque + "🗡️";
        return message;
    }
}