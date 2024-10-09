import Cases.Case;
import Personnages.Personnage;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public String choseMenu() {
        printDragon();

        System.out.println("\u001B[31m \t\t 1-Créer un personnage \n \t\t 2-Quitter le jeu \u001B[0m\n");
        String menu_choice = scanner.next();
        return menu_choice;

    }

    public void printDragon() {
        System.out.println("""
                \u001b[33m                      ___====-_  _-====___
                \u001b[31m                _--^^^#####//      \\\\#####^^^--_
                \u001b[35m             _-^##########// (    ) \\\\##########^-_
                \u001b[34m            -############//  |\\^^/|  \\\\############-
                \u001b[36m          _/############//   (@::@)   \\\\############\\_
                \u001b[32m         /#############((     \\\\//     ))#############\\
                \u001b[33m        -###############\\\\    (oo)    //###############-
                \u001b[31m       -#################\\\\  / "" \\  //#################-
                \u001b[35m      -###################\\\\/  (_)  \\//###################-
                \u001b[34m     _#/|##########/\\######(   '---'   )######/\\##########|\\#_
                \u001b[36m     |/ |#/\\#/\\#/\\/  \\#/\\##\\  |     |  /##/\\#/  \\/\\#/\\#/\\| \\|
                \u001b[32m     |/  V  V  V     V  V  V              V  V     V  V  V  \\|

                 \u001b[0m              ~ Un dragon guarde le donjon ~
                """);
    }

    public String choseClassType() {
        System.out.println("\u001B[35m \nChoisir une classe (mage/guerrier) : \u001B[0m");
        String classe = scanner.next();
        return classe;
    }

    public String choseName() {
        System.out.println("\n\u001B[35mVotre nom : \u001B[0m");
        String name = scanner.next();
        return name;
    }

    public String main_menu() {
        System.out.println(
                "\u001B[31m \n 1-Regarder les statistiques du personnage \n 2-Modifier le personnage \n 3-Démarrer le jeu \n 4-Quitter le jeu \u001B[0m");
        String showPersonnage = scanner.next();
        return showPersonnage;
    }

    public void printInvalidClass() {
        System.out.println("❌ Veuillez modifier votre personnage pour une classe valide! ❌");
    }

    public void printPersonnage(Personnage personnage) {
        System.out.println(personnage.toString());
    }

    public void printDices() {
        System.out.println("""

                \t  .-------.    ______
                \t /   o   /|   /\\     \\
                \t/_______/o|  /o \\  o  \\
                \t| o     | | /   o\\_____\\
                \t|   o   |o/ \\o   /o    /
                \t|     o |/   \\ o/  o  /
                \t'-------'     \\/____o/
                """);
        System.out.println("\n  Veuillez lancer les dés pour commencer.");
    }

    public void printSingleDice(int choice) {
        String msg = "";
        switch (choice) {
            case 1 -> msg = """
                     \n
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬜️⬛️⬜️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                    """;
            case 2 -> msg = """
                     \n
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬛️⬜️⬜⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬜️⬜️⬛️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                    """;
            case 3 -> msg = """
                     \n
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬛️⬜️⬜⬜️
                     \t\t  ⬜️⬜️⬛️⬜️⬜️
                     \t\t  ⬜️⬜️⬜️⬛️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                    """;
            case 4 -> msg = """
                     \n
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬛️⬜️⬛️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬛️⬜️⬛️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                    """;
            case 5 -> msg = """
                     \n
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬛️⬜️⬛️⬜️
                     \t\t  ⬜️⬜️⬛️⬜️⬜️
                     \t\t  ⬜️⬛️⬜️⬛️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                    """;
            case 6 -> msg = """
                     \n
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬛️⬛️⬛️⬜️
                     \t\t  ⬜️⬛️⬛️⬛️⬜️
                     \t\t  ⬜️⬛️⬛️⬛️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                    """;
            default -> {
            }
        }
        System.out.println(msg);
    }

    public String dice_menu() {
        System.out.println("\n\u001B[35m1-Lancer les dès \n2-Statistiques du personnage\n3-Quitter le jeu\u001b[0m");
        String showPersonnage = scanner.next();
        return showPersonnage;
    }

    public String win_menu() {
        System.out.println("\u001b[33m \t\t***VOUS AVEZ GAGNE*** \u001b[0m \n\n");
        System.out.println("""
                \u001b[31m                    ⣀⣀⡠⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                \u001b[32m        ⠀⢸⢉⡗⠀⠀⠀⠀⠀⠀⠀⠀⠈⡆⠀⠈⡱⠖⠀⠀⠀⠀⠀⠀⠀⠀⣄⣠⠆⠀
                \u001b[33m        ⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠰⠓⠒⢴⠀⠀⠀⠀⠀⠀⠀⣀⠀⠀⢨⠀⣰⠃
                \u001b[34m        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠜⢹⡀⠀⠀⠀⠈⠀
                \u001b[35m        ⠀⠀⠀⠀⢠⣀⣶⠀⠀⠀⠀⠀⠀⠀⠀⢤⢀⣀⣀⣀⡠⠋⠀⠀⢇⠀⠀⠀⠀⠀
                \u001b[36m        ⠀⠀⠀⠀⠀⡇⣄⠊⠁⠀⠀⠀⠀⠀⢀⡨⢦⠀⠀⠀⠀⠀⠀⠀⠘⠒⠤⣀⡀⠀
                \u001b[37m        ⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⡀⠔⠊⠁⢀⡀⠳⡀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠼⠋
                \u001b[31m        ⠀⠀⠀⠀⠀⠀⠀⠀⣀⠔⠈⡀⠄⠂⠉⢀⡀⢰⠁⠀⠀⠀⠀⠀⠀⡴⠊⠁⠀⠀
                \u001b[32m        ⠀⠀⠀⠀⠀⠀⡠⢊⠠⠒⣁⠤⠐⣀⡁⠤⢤⠃⢀⣀⡠⢄⡀⠀⠀⡇⠀⠀⠀⠀
                \u001b[33m        ⠀⠀⠀⠀⡠⡪⢐⡡⢐⠩⠐⠊⠁⠀⠀⠀⠚⠉⠉⠀⠀⠀⠙⠢⣀⡇⠀⠀⠀⠀
                \u001b[34m        ⠀⠀⢠⡪⡪⡲⠕⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠈⠃⠀⠀⠀
                \u001b[35m        ⠀⣰⣿⠞⠉⠀⠀⠀⠀⠀⡄⡰⡆⠀⠀⠀⠀⠀⠀⢐⣌⡶⠀⠀⠀⠀⠀⠀⠀⠀
                \u001b[36m        ⡰⠋⠀⠀⠀⠀⠀⠀⠀⠀⣸⠤⡐⠁⠀⠀⠀⠀⠀⠀⠀⠃⠀⠀⠀⠀⠀⠀⠀⠀
                                                       """);
        System.out.println("\n\u001B[35m1-Rejouer \n2-Quitter le jeu \u001b[0m");
        String restartOrClose = scanner.next();
        return restartOrClose;
    }

    public String lose_menu(String tileString) {
        System.out.println("\u001b[33m \t\t***VOUS AVEZ PERDU*** \u001b[0m \n\n");
        System.out.println("Vous avez été tué par un " + tileString);
        System.out.println("\n\u001B[35m1-Rejouer \n2-Quitter le jeu \u001b[0m");
        String restartOrClose = scanner.next();
        return restartOrClose;
    }

    public void printTileEvent(Case tableau) {
        System.out.println("\u001B[36m");
        System.out.println(tableau);
        System.out.println("\u001B[0m");
    }

    public void showPlayerTile(int tileNumber) {
        System.out.println(
                "\n\n  Vous vous trouvez sur la case n°" + (tileNumber + 1)
                        + "/64. \u001b[0m \n");

    }

    public void showDiceThrow() {
        System.out.println("\t\u001b[33m ***Vous lancez les dés*** \u001b[0m ");
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
