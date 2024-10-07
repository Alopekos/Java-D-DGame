public class Personnage {
    public String name;
    public String classe;
    public int niveauDeVie;
    public int forceDAttaque;
    public EquipementOffensif arme;
    public EquipementDefensif bouclier;

    public Personnage() {
        this("Unknown", "Unknown");

    }

    public Personnage(String name) {
        this("Unknown", name);
    }

    public Personnage(String classePersonnage, String name) {
        this.classe = classePersonnage;
        this.name = name;

        switch (classePersonnage) {
            case "mage" -> {
                this.niveauDeVie = 6;
                this.forceDAttaque = 15;
            }
            case "guerrier" -> {
                this.niveauDeVie = 10;
                this.forceDAttaque = 10;
            }
            default -> {
                System.out.println("Cette classe n'est pas disponible : " + classePersonnage);
            }
        }

    }

    public void equipWeapon(EquipementOffensif weapon) {
        this.arme = weapon;
    }

    public void equipDefensive(EquipementDefensif defensive) {
        this.bouclier = defensive;
    }

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