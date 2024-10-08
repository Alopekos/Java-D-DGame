package EquipementDefense;

public abstract class EquipementDefensif {
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
        String message = "\n\nNom: " + this.name
                + " / Type: "
                + this.type
                + "\n🛡️: +" + this.defense;
        return message;
    }
}