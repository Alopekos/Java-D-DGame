public class EquipementOffensif {
    private String name;
    private String type;
    private int forceDAttaque;

    public EquipementOffensif() {
        this.name = "unknown";
        this.type = "unknown";
    }

    public EquipementOffensif(String name, Personnage classe) {
        this.name = name;
        switch (classe.getClasse()) {
            case "mage":
                this.type = "Sort";
                this.forceDAttaque = 10;
                break;
            case "guerrier":
                this.type = "Arme";
                this.forceDAttaque = 15;
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

    public int getAttack() {
        return forceDAttaque;
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