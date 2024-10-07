import java.util.Scanner;

public class Menu {

    public void startGame() {
        clearScreen();
        Scanner scanner = new Scanner(System.in);
        boolean isMenuOver = false;

        System.out.println("\u001B[35m \nChoisir une classe (mage/guerrier) : \u001B[0m");
        String classe = scanner.next();
        System.out.println("\n\u001B[35mVotre nom : \u001B[0m");
        String name = scanner.next();

        Game ongoingGame = new Game();
        Personnage perso_1 = new Personnage(classe, name);
        EquipementOffensif weapon_1 = new EquipementOffensif("Lame de Doran", perso_1);
        EquipementDefensif defensive_1 = new EquipementDefensif("Bouclier Dentelé", perso_1);

        perso_1.equipWeapon(weapon_1);
        perso_1.equipDefensive(defensive_1);
        ongoingGame.setCharacter(perso_1);

        while (!isMenuOver) {

            System.out.println(
                    "\u001B[31m \n 1-Regarder les statistiques du personnage \n 2-Modifier le personnage \n 3-Démarrer le jeu \n 4-Quitter le jeu \u001B[0m");

            String showPersonnage = scanner.next();

            switch (showPersonnage) {
                case "1" -> {
                    clearScreen();
                    if (perso_1.classe.equals("mage") || perso_1.classe.equals("guerrier")) {
                        System.out
                                .println(perso_1.toString());
                    } else {
                        System.out.println("Veuillez choisir une classe valide!");
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
                    System.out.println("\n \u001b[31m Veuillez lancer les dés pour commencer.\u001B[0m\n");
                    isMenuOver = true;
                    throwDice(ongoingGame.getCharacter(), scanner);
                }
                case "4" -> {
                    clearScreen();
                    isMenuOver = true;
                    clearScreen();
                }
                default -> System.out.println("\u001B[35m \nImpossible de montrer le personnage \u001B[0m");
            }
        }
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

                 \u001b[0m              ~ Un dragon guarde le donjon ~
                """);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean throwDice(Personnage personnage, Scanner scannerGame) {
        int tileNumber = 1;
        boolean isGameOver = false;

        while (!isGameOver) {
            System.out.println("\n1-Lancer les dès \n2-Statistiques du personnage");
            String showPersonnage = scannerGame.next();

            switch (showPersonnage) {
                case "1" -> {
                    clearScreen();
                    if (tileNumber < 64) {
                        System.out.println(
                                "\u001b[33m ***Vous lancez les dés*** \u001b[0m \n\n \u001b[31m Vous vous trouvez sur la case n°"
                                        + tileNumber + "/64. \u001b[0m \n");
                        tileNumber += (int) ((Math.random() * 5) + 1);
                    } else if (tileNumber >= 64) {
                        System.out.println("\u001b[33m VOUS AVEZ GAGNE !!! \u001b[0m");
                        System.out.println("\n1-Rejouer \n2-Quitter le jeu");
                        String restartOrClose = scannerGame.next();
                        clearScreen();
                        switch (restartOrClose) {
                            case "1" -> throwDice(personnage, scannerGame);
                            case "2" -> {
                                isGameOver = true;
                                clearScreen();
                                System.exit(0);
                            }
                        }
                    }
                }
                case "2" -> {
                    clearScreen();
                    if (personnage.classe.equals("mage") || personnage.classe.equals("guerrier")) {
                        System.out
                                .println(personnage.toString());
                    } else {
                        System.out.println("Veuillez choisir une classe valide!");
                    }
                }
            }

        }

        return false;
    }
}
