public class EquipementDefensif {
    private String name;
    private String type;
    private int defense;

    public EquipementDefensif() {
        this.name = "unknown";
        this.type = "unknown";
    }

    public EquipementDefensif(String name, Personnage classe) {
        this.name = name;
        switch (classe.classe) {
            case "mage":
                this.type = "Philtre";
                this.defense = 10;
                break;
            case "guerrier":
                this.type = "Bouclier";
                this.defense = 15;
            default:
                this.name = name;
                break;
        }
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

    public String toString() {
        String message = "\n\nNom: " + this.name
                + " / Type: "
                + this.type
                + "\n🛡️: +" + this.defense;
        return message;
    }
}