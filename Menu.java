
import cases.Case;
import java.util.Scanner;
import personnages.Personnage;

public class Menu {
    private final Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public String choseMenu() {
        printDragon();
        System.out.println("\t\t========================================");
        System.out.println("\t\t||\u001B[35m 🎨  1-\u001B[0mCréer un personnage          ||");
        System.out.println("\t\t||\u001B[35m ❌  2-\u001B[0mQuitter le jeu\u001B[0m               ||");
        System.out.println("\t\t========================================");

        return scanner.next();

    }

    public void printDragon() {
        System.out.println(
                """
                        \u001b[31m           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣴⣶⡿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣴⣾⣿⣿⡿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡴⢚⢫⣽⣿⣿⡿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⡶⠛⠳⣎⢥⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⡿⠁⠀⠀⠀⣹⢾⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣆⣆⣶⣶⣶⡶⣶⢶⣀⣀⣀
                        \u001b[31m           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡴⢛⡏⠀⠀⠀⣠⡖⢏⠺⣿⣿⣷⣦⣤⣤⣤⠶⠖⠊⠀⠀⣀⣤⣤⡴⣖⡾⠟⠛⠉⠉⠉⠙⣏⡞⣼⣼⣷⣿⡿⠿⠛⠉⠀
                        \u001b[31m           ⠀⠀⠀⠀⠀⠀⠀⠀⣠⠾⣉⠖⡩⢝⡦⠴⣞⠱⡸⢌⣣⣽⣿⣿⠿⠛⠉⣀⣠⣤⣶⡾⠟⠛⠋⠉⠙⣾⣇⠀⠀⠀⢀⣀⣤⣿⣿⣿⠿⠛⠉⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⠀⠀⠀⢀⣴⢋⠖⡱⢊⡕⢪⢔⠫⡔⢫⣱⣾⠿⠛⢉⣠⡴⣶⠿⠟⠋⠁⠀⠀⠀⠀⠀⢀⣠⡿⣹⢳⣻⠻⡽⣹⣿⣿⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⠀⠀⣰⠟⣤⢋⡎⢵⡩⢜⢣⢎⣣⣽⠟⢋⣡⡴⣞⣯⠟⠋⠁⠀⠀⠀⠀⣀⣤⢶⢶⣛⢯⣓⢧⣓⡏⣶⢫⣽⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⠀⠼⢯⣞⡤⢳⡸⢅⡞⣩⣖⠷⠋⠳⢶⣏⢧⣽⠋⠀⠀⠀⢀⣠⡴⣞⡻⡝⣮⢝⡲⣭⢞⡼⣣⢧⣛⢶⣫⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⠀⠀⠀⠈⠻⣵⢊⠷⡸⢥⣧⠀⠀⠀⠀⠉⠳⣾⣦⣠⣤⡞⣯⠳⣝⡲=========⢮⡝⣮⢳⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⠀⠀⠀⠀⠀⣸⣏⣞⣱⡧⠾⢷⣄⡀⠀⠀⠀⠈⠳⣏⡶⣹⢖⡻⣜⡳|\u001B[33m D & D \u001b[31m|⢧⣻⠼⣏⢿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⠀⠀⠀⠀⠀⣤⣿\u001B[33m⣩⣥⣶⣿\u001b[31m⣭⣶⣿⠿⠛⠛\u001b[31m⠀⠀⠙⣷⡹⣎⠷⣭⢳|\u001B[33m JAVA☕\u001b[31m|⣟⢮⣟⣭⢿⣮⣝⠻⢿⣧⡀⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⠀⠀⠀⣠⡴⣞⡟⣻⣛⠷⡻⣿⣿\u001B[33m⣦⣤⣄⡀\u001b[31m⠀⠀⠀⢹⡷⣭⣻⢼⡳|\u001B[33mEDITION\u001b[31m|⣯⢽⣻⡼⣏⡾⣞⡽⣞⡿⣿⣦⣈⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⠀⣰⠿⣭⣷⣭⡞⣵⡹⣎⠷⣭⣛⣿⣿⣭⣉\u001b[31m⠀⠀⠀⠀⢿⣧⣛⣮⢷=========⣯⠾⣽⢶⣻⣭⢷⡯⣟⣳⣟⡿⣿⣿⣷⣤⡀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⢀⣹⡿⣯\u001B[32m⣴⢿\u001b[31m⡹⢶⡹⣎⡟⣶⡹⣖\u001B[33m⢿⣿⡿⠛⠦\u001b[31m⠀⠀⢸⡷⣏⣾⡳⣽⡺⣟⡽⣾⣭⢿⡽⣞⣷⣫⣟⡾⣽⣳⣯⣿⣿⡿⠿⠛⠛⠲⠀⠀⠀⠀
                        \u001b[31m           ⣾⣤⡶⣿⡹⣞⡵⣫⣞⣽⣣⣟⣵⣻⠷⣟⡾⣭\u001B[33m⢿⣿⣦⡀\u001b[31m⠀⠀⢸⡿⣽⢶⣻⣳⢿⣹⡽⣶⢯⣟⡾⣿⡷⣟⣾⣽⣳⣿⣿⠟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠻⣷⣝⡶⠟⣳⡿⠋⠉⠀⠈⠉⠛⡿⣸⢻⣽⡞⣯⣿\u001B[33m⡿⣷⠀\u001b[31m⠀⣿⢿⡽⣞⡷⣯⣟⣷⣻⣽⣻⢾⣽⣻⢿⣜⢿⣾⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠘⠻⣤⣾⡟⠀⠀⠀⠀⠀⠀⣀⣴⣿⢸⣿⣽⡳⣿\u001B[33m⣷⡌⠁\u001b[31m⣰⣿⢯⡿⣽⣻⣵⣻⣞⡷⣯⣟⡿⣾⣽⣻⢿⣦⠙⢿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⠀⠉⠉⠀⠀⠀⢀⣰⣾⣿⣿⢇⣿⡿⣶⢿\u001B[33m⡿⠉⢷\u001b[31m⢀⣿⣏⣿⣹⢷⡿⣾⢷⣏⣿⢿⣾⣿⣷⣿⣿⣿⣿⣷⠾⢿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⠀⠀⠀⢀⣤⣾⣿⣿⣿⡿⣣⣿⢿⡽⣯⢿\u001B[33m⡇\u001b[31m⠀⣠⣿⣟⣾⣳⣯⢿⣽⢯⣟⣯⣿⡟⣿⣿⣿⣿⠿⠿⠿⣿⣷⣅⠓⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        \u001b[31m           ⠀⠀⠀⠀⢀⣶⣿⣿⣿⣿⡿⣫⣾⢿⡽⣯⢿⡽⣿⣠⣼⣿⣻⢾⣳⣯⣿⣟⣾⣟⣯⣿⣽⣷⢻⡿⠋⠀⠀⠀⠀⠀⠉⠙⢷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                    \u001b[0m
                                                   """);
    }

    public String choseClassType() {
        System.out.println("\u001B[35m \n\nChoisir une classe (mage🧙/guerrier🪓) : \u001B[0m");
        return scanner.next();
    }

    public String choseName() {
        System.out.println("\n\u001B[35mVotre nom : \u001B[0m");
        return scanner.next();
    }

    public String mainMenu() {
        System.out.println("\n=======================================================");
        System.out.println("||\u001B[35m 🧬   1-\u001B[0mRegarder les statistiques                  || ");
        System.out.println("||\u001B[35m 🎨   2-\u001B[0mModifier le personnage                     ||");
        System.out.println("||\u001B[35m 🎲   3-\u001B[0mDémarrer le jeu                            ||");
        System.out.println("||\u001B[35m ❌   4-\u001B[0mQuitter le jeu                             ||");
        System.out.println("=======================================================");
        return scanner.next();
    }

    public void printInvalidClass() {
        System.out.println("❌ Veuillez modifier votre personnage pour une classe valide! ❌");
    }

    public void printPersonnage(Personnage personnage) {
        System.out.println(personnage.toString());
    }

    public void printDices() {
        System.out.println("""
                \t        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣠⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀
                \t        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⡻⣯⣙⣿⣷⣾⣿⣦⣄⠀⠀⠀⠀⠀
                \t        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣝⣿⣟⣛⣿⣷⣭⣿⢦⠀⠀⠀
                \t        ⠀⠀⠀⠀⠀⣀⣤⢤⣤⣤⣴⣿⣿⢿⣿⡟⢿⣮⢛⣿⣽⣷⣿⡟⠀⠀⠀
                \t        ⠀⢀⣠⡴⣾⣿⣚⣿⣿⣷⢾⣫⣷⣿⣾⣧⣼⡟⣾⣿⢿⣿⡟⠀⠀⠀⠀
                \t        ⣒⣻⣷⠾⢿⣯⣵⢾⣫⣷⣿⣿⡇⢸⣷⣿⣿⣽⣿⣿⣾⡿⠁⠀⠀⠀⠀
                \t        ⢻⡻⣿⠿⣿⣿⣦⢿⣿⠉⣻⣿⣿⣿⣿⣾⣳⣿⡿⠟⠋⠁⠀⠀⠀⠀⠀
                \t        ⠈⢷⣾⣧⣽⣧⣹⡞⣿⣶⣿⣿⣿⡟⢹⣷⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀
                \t        ⠀⠘⡟⢿⡿⣿⣿⣿⣻⣿⡟⢻⣿⣷⡿⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                \t        ⠀⠀⠹⣾⣷⣬⣯⡙⣏⣿⣧⣾⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                \t        ⠀⠀⠀⠀⠈⠉⠛⠻⠿⠼⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                             """);
        System.out.println("\n  Veuillez lancer les dés pour commencer 🎲");
    }

    public void printSingleDice(int choice) {
        String msg = "";
        switch (choice) {
            case 1 -> msg = """

                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬜️⬛️⬜️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                    """;
            case 2 -> msg = """

                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬛️⬜️⬜⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬜️⬜️⬛️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                    """;
            case 3 -> msg = """

                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬛️⬜️⬜⬜️
                     \t\t  ⬜️⬜️⬛️⬜️⬜️
                     \t\t  ⬜️⬜️⬜️⬛️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                    """;
            case 4 -> msg = """

                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬛️⬜️⬛️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬛️⬜️⬛️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                    """;
            case 5 -> msg = """

                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬛️⬜️⬛️⬜️
                     \t\t  ⬜️⬜️⬛️⬜️⬜️
                     \t\t  ⬜️⬛️⬜️⬛️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                    """;
            case 6 -> msg = """

                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                     \t\t  ⬜️⬛️⬛️⬛️⬜️
                     \t\t  ⬜️⬛️⬛️⬛️⬜️
                     \t\t  ⬜️⬛️⬛️⬛️⬜️
                     \t\t  ⬜️⬜️⬜️⬜️⬜️
                    """;
            default -> {
                break;
            }
        }
        System.out.println(msg);
    }

    public String diceMenu() {
        System.out.println("=======================================================");
        System.out.println("||\u001B[35m 🎲  1-\u001b[0mLancer les dès                              ||");
        System.out.println("||\u001B[35m 🧬  2-\u001b[0mStatistiques du personnage                  ||");
        System.out.println("||\u001B[35m ❌  3-\u001b[0mQuitter le jeu \u001b[0m                             ||");
        System.out.println("=======================================================\n");
        return scanner.next();
    }

    public String winMenu() {
        System.out.println("\u001b[33m \t\t-*-VOUS AVEZ GAGNE-*- \u001b[0m \n\n");
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
        System.out.println("\n\u001B[35m1-Rejouer 🔄\n2-Quitter le jeu ❌\u001b[0m");
        return scanner.next();
    }

    public String loseMenu(String tileString) {
        System.out.println("Vous avez été tué par un " + tileString);
        System.out.println("\n\u001B[35m1-Rejouer \n2-Quitter le jeu \u001b[0m");
        return scanner.next();
    }

    public void printLose() {
        System.out.println("\u001b[33m \n\t---VOUS AVEZ PERDU--- \u001b[0m \n");
    }

    public void printTileEvent(Case tableau) {
        System.out.println("\u001B[36m");
        System.out.println(tableau);
        System.out.println("\u001B[0m");
    }

    public void showPlayerTile(int tileNumber) {
        System.out.println(
                "\n\n\u001b[33m  Vous vous trouvez sur la case n°" + (tileNumber + 1)
                        + "/64. \u001b[0m \n\n=======================================================\n\n");

    }

    public void showDiceThrow() {
        System.out.println("\t\u001b[33m Résultat du lancer de dés: \u001b[0m ");
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
