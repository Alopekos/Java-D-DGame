package equipement.offense;

import cases.Case;
import personnages.Personnage;

public abstract class EquipementOffensif implements Case {
    private String name;
    private String type;
    private int forceDAttaque;

    protected EquipementOffensif(String name, String type, int forceDAttaque) {
        this.name = name;
        this.type = type;
        this.forceDAttaque = forceDAttaque;
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
        System.out.print("Vous trouvez un item offensif pour la classe ");
        switch (this.type) {
            case "Sort" -> System.out.print("mage.\n");
            case "Arme" -> System.out.print("guerrier.\n");
            default -> {
                break;
            }
        }

        if (personnage.getArme().forceDAttaque < this.forceDAttaque && personnage.getClasse().equals("mage")
                && this.type.equals("Sort")
                || personnage.getClasse().equals("guerrier") && this.type.equals("Arme")) {
            personnage.equipWeapon(this);
        }
    }

    @Override
    public String printArt() {
        return """
                \t       .m.
                \t       (;)
                \t       (;)
                \t       (;)
                \t    .  (;)  .
                \t    |\\_(;)_/|
                \t    |/ )|( \\|
                \t      ( o )
                \t       )8(
                \t      ( o )
                \t       )8(
                \t      ;|S|;
                \t      ||S||
                \t      ||S||
                \t      ||S|<
                \t      ||S||
                \t      ||S||
                \t      ||S||
                \t      ||S||
                \t      >|S||
                \t      ||S||
                \t      ||S||
                \t      \\\\ //
                \t       \\V/
                \t        V
                        """;
    }

    @Override
    public String toString() {
        return printArt() + "\n\u001b[0m" + this.type + ": \"" + this.name + "\" +"
                + this.forceDAttaque + "🗡️";
    }
}