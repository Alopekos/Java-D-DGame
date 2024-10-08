package EquipementOffense;

public abstract class EquipementOffensif {
    private String name;
    private String type;
    private int forceDAttaque;

    public EquipementOffensif() {
        this.name = "unknown";
        this.type = "unknown";
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
    public String toString() {
        String message = "\nNom: " + this.name
                + " / Type: "
                + this.type
                + "\n🗡️: +" + this.forceDAttaque;
        return message;
    }
}