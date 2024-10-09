package EquipementDefense;

import Cases.Case;

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
    public String toString() {
        String message = "\n" + this.type + ": " + this.name + "\n   +" + this.defense + "🛡️";
        return message;
    }
}