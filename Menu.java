import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isGameOver = false;

        System.out.println("\u001B[35m \nChoisir une classe (mage/guerrier) : \u001B[0m");

        String classe = scanner.next();
        System.out.println("\n\u001B[35mVotre nom : \u001B[0m");
        String name = scanner.next();

        Personnage perso_1 = new Personnage(classe, name);

        while (!isGameOver) {
            System.out.println("\u001B[35m \nVoulez-vous regarder les statistiques du personnage (y/n) ?\u001B[0m");
            String showPersonnage = scanner.next();
            switch (showPersonnage) {
                case "y":
                    if (perso_1.classe != null) {
                        System.out
                                .println("\n \u001B[33m*** Caracteristiques ***\u001B[0m \nNom: " + perso_1.name
                                        + " / Classe: "
                                        + perso_1.classe
                                        + "\n💖: "
                                        + perso_1.niveauDeVie
                                        + "\n🗡️: " + perso_1.forceDAttaque);
                    }
                    break;
                case "n":
                    System.out.println("\u001B[35m \nVoulez-vous quitter le jeu (y/n)? \u001B[0m");
                    String exitGame = scanner.next();
                    if (exitGame.equals("y")) {
                        isGameOver = true;
                        scanner.close();
                        break;
                    }
                    break;

                default:
                    System.out.println("\u001B[35m \nImpossible de montrer le personnage \u001B[0m");
                    break;
            }
        }
        scanner.close();
    }

}