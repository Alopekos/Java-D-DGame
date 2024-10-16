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
    public int interact(Personnage personnage, int tileNumber) {
        System.out.print("Vous trouvez un item defensif pour la classe ");
        switch (this.type) {
            case "Philtre" -> System.out.print("mage.\n");
            case "Bouclier" -> System.out.print("guerrier.\n");
            default -> {
                break;
            }
        }

        if (personnage.getBouclier().defense < this.defense && personnage.getClasse().equals("mage")
                && this.type.equals("Philtre")
                || personnage.getClasse().equals("guerrier") && this.type.equals("Bouclier")) {
            personnage.equipDefensive(this);
        }
        return 0;
    }

    @Override
    public String printArt() {
        return """
                \t            _______________________
                \t         / \\$$$$$$$$$$$$$$$$$$$$$$\\
                \t        (    \\$$$$$$$$$k\\;\\&j$$$$$$)
                \t        |\\     \\$$$$$$$,'    `^<$$$|
                \t        |$$\\     \\$$$;' __n,    `:$|
                \t        |$$$$\\     \\$$jT$$$$i. ,$$$|
                \t         |$$$$$\\     \\$$$$$$$;J$$$|
                \t         |$$$$$$$\\     \\$$$$$$$$$$|
                \t          \\$$$$$$$$\\     \\$$$$$$$/
                \t           \\$$$$$$$$$\\     \\$$$$/
                \t            \\$$$$$$$$$$\\     \\$/
                \t             \\$$$$$$$$$$$\\    /
                \t              \\$$$$$$$$$$$$\\ /
                \t                \\$$$$$$$$$$/
                \t                  \\$$$$$$/
                \t                    \\$$/
                                        """;
    }

    @Override
    public String toString() {

        return printArt() + "\n\u001b[0m" + this.type + ": \"" + this.name + "\" +"
                + this.defense
                + "🛡️";
    }
}