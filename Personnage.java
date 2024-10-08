
public abstract class Personnage {
    private String name;
    private String classe;
    private int niveauDeVie;
    private int forceDAttaque;
    private EquipementOffensif arme;
    private EquipementDefensif bouclier;

    // public Personnage() {
    // this("Unknown", "Unknown");

    // }

    // public Personnage(String name) {
    // this("Unknown", name);
    // }

    // public Personnage(String classePersonnage, String name) {
    // this.classe = classePersonnage;
    // this.name = name;

    // switch (classePersonnage) {
    // case "mage" -> {
    // Personnage personnage = new Guerrier(name);
    // }
    // case "guerrier" -> {
    // Personnage personnage = new Mage(name);
    // }
    // default -> {
    // // System.out.println("\n❌ Cette classe n'est pas disponible : " +
    // // classePersonnage + " ❌");
    // }
    // }
    // }

    public String getName() {
        return name;
    }

    public String getClasse() {
        return classe;
    }

    public void equipWeapon(EquipementOffensif weapon) {
        this.arme = weapon;
    }

    public void equipDefensive(EquipementDefensif defensive) {
        this.bouclier = defensive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClass(String classe) {
        this.classe = classe;
    }

    public void setNiveauDeVie(int lifePoints) {
        this.niveauDeVie = lifePoints;
    }

    public void setForceDAttaque(int atk) {
        this.forceDAttaque = atk;
    }

    @Override
    public String toString() {
        String message = "\n \u001B[33m*** Caracteristiques ***\u001B[0m \nNom: " + this.name
                + " / Classe: "
                + this.classe
                + "\nPdv: "
                + this.niveauDeVie + "\u001B[34m (+" + this.bouclier.getDefense() + ") \u001B[0m"
                + "\nAtk: " + this.forceDAttaque + "\u001B[34m (+" + this.arme.getAttack()
                + ") \u001B[37m \n\nTotal: \n💖 " + (this.niveauDeVie + this.bouclier.getDefense()) + "\n🗡️  "
                + (this.forceDAttaque + this.arme.getAttack())
                + " \n\n \u001B[33m*** Equipement ***\u001B[0m "
                + this.arme.toString()
                + this.bouclier.toString();
        return message;
    }
}