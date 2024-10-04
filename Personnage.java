public class Personnage {
    public String name;
    public String classe;
    public int niveauDeVie;
    public int forceDAttaque;

    public Personnage(String classePersonnage, String name /* String equipOffensif, String equipDefensif */) {
        // EquipementOffensif offense = new EquipementOffensif();
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
                this.classe = null;
            }
        }

    }
}