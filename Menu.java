import java.util.Scanner;

public class Menu {

    public void startGame() {
        clearScreen();
        Scanner scanner = new Scanner(System.in);
        boolean isGameOver = false;

        System.out.println("\u001B[35m \nChoisir une classe (mage/guerrier) : \u001B[0m");

        String classe = scanner.next();
        System.out.println("\n\u001B[35mVotre nom : \u001B[0m");
        String name = scanner.next();

        Personnage perso_1 = new Personnage(classe, name);
        EquipementOffensif weapon_1 = new EquipementOffensif("Lame de Doran", perso_1);
        EquipementDefensif defensive_1 = new EquipementDefensif("Bouclier Dentelé", perso_1);

        perso_1.equipWeapon(weapon_1);
        perso_1.equipDefensive(defensive_1);

        while (!isGameOver) {

            System.out.println(
                    "\u001B[31m \n 1-Regarder les statistiques du personnage \n 2-Modifier le personnage \n 3-Quitter le jeu \u001B[0m");

            String showPersonnage = scanner.next();

            switch (showPersonnage) {
                case "1" -> {
                    clearScreen();
                    if (perso_1.classe != null) {
                        System.out
                                .println(perso_1.toString());
                    }
                }
                case "2" -> {
                    clearScreen();
                    System.out.println("\u001B[35m \nChoisir une classe (mage/guerrier) : \u001B[0m");

                    classe = scanner.next();
                    System.out.println("\n\u001B[35mVotre nom : \u001B[0m");
                    name = scanner.next();

                    perso_1 = new Personnage(classe, name);
                    weapon_1 = new EquipementOffensif("Lame de Doran", perso_1);
                    defensive_1 = new EquipementDefensif("Bouclier Dentelé", perso_1);

                    perso_1.equipWeapon(weapon_1);
                    perso_1.equipDefensive(defensive_1);
                }
                case "3" -> {
                    clearScreen();
                    isGameOver = true;
                    scanner.close();
                    clearScreen();
                }
                default -> System.out.println("\u001B[35m \nImpossible de montrer le personnage \u001B[0m");
            }
        }
        scanner.close();

    }


    public void choseMenu() {
        printDragon();
        System.out.println("\u001B[31m \t\t 1-Créer un personnage \n \t\t 2-Quitter le jeu \u001B[0m\n");
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

                 \u001b[0m              ~ Un dragongue guarde le donjongue ~
                """);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}