
import cases.Case;
import java.util.Scanner;
import personnages.Personnage;

/**
 * The {@code Menu} class handles the user interactions in the game, including
 * displaying various menus,
 * reading input from the player, and printing various messages or visuals.
 * It uses a {@link Scanner} for reading user input and contains methods to
 * interact with the player
 * at different stages of the game.
 */
public class Menu {
    private final Scanner scanner;

    /**
     * Constructs a new {@code Menu} and initializes the {@code Scanner} for user
     * input.
     */
    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu to the user and allows them to choose between creating
     * a character or quitting the game.
     * 
     * @return A {@link String} representing the user's menu choice.
     */
    public String choseMenu() {
        printDragon();
        System.out.println("\t\t========================================");
        System.out.println("\t\t||\u001B[35m 🎨  1-\u001B[0mCréer un personnage          ||");
        System.out.println("\t\t||\u001B[35m ❌  2-\u001B[0mQuitter le jeu\u001B[0m               ||");
        System.out.println("\t\t========================================");

        return scanner.next();

    }

    /**
     * Prints a dragon ASCII art to the console as part of the menu display.
     */
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

    /**
     * Prompts the user to choose a character class between mage and warrior.
     * 
     * @return A {@link String} representing the chosen class.
     */
    public String choseClassType() {
        System.out.println("\u001B[35m \n\nChoisir une classe (mage🧙/guerrier🪓) : \u001B[0m");
        return scanner.next();
    }

    /**
     * Prompts the user to enter a name for their character.
     * 
     * @return A {@link String} representing the name chosen by the user.
     */
    public String choseName() {
        System.out.println("\n\u001B[35mVotre nom : \u001B[0m");
        return scanner.next();
    }

    /**
     * Displays the main game menu with options for viewing statistics, modifying
     * the character,
     * starting the game, or quitting the game.
     * 
     * @return A {@link String} representing the user's menu choice.
     */
    public String mainMenu() {
        System.out.println("\n=======================================================");
        System.out.println("||\u001B[35m 🧬   1-\u001B[0mRegarder les statistiques                  || ");
        System.out.println("||\u001B[35m 🎨   2-\u001B[0mModifier le personnage                     ||");
        System.out.println("||\u001B[35m 🎲   3-\u001B[0mDémarrer le jeu                            ||");
        System.out.println("||\u001B[35m ❌   4-\u001B[0mQuitter le jeu                             ||");
        System.out.println("=======================================================");
        return scanner.next();
    }

    /**
     * Prints an error message indicating that the user has selected an invalid
     * character class.
     * This method should be called when the user tries to choose a class that does
     * not exist.
     */
    public void printInvalidClass() {
        System.out.println("❌ Veuillez modifier votre personnage pour une classe valide! ❌");
    }

    /**
     * Displays the details of the given {@link Personnage} by calling its
     * {@code toString} method.
     *
     * @param personnage The character whose details are to be printed.
     */
    public void printPersonnage(Personnage personnage) {
        System.out.println(personnage.toString());
    }

    /**
     * Displays a visual representation of the dice and prompts the user to roll the
     * dice to begin the game.
     */
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

    /**
     * Displays a visual representation of a single die based on the user's choice.
     * 
     * @param choice An {@link int} representing the face of the die (1-6).
     */
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

    /**
     * Displays a menu for rolling dice, viewing character statistics, or quitting
     * the game.
     * 
     * @return A {@link String} representing the user's menu choice.
     */
    public String diceMenu() {
        System.out.println("=======================================================");
        System.out.println("||\u001B[35m 🎲  1-\u001b[0mLancer les dès                              ||");
        System.out.println("||\u001B[35m 🧬  2-\u001b[0mStatistiques du personnage                  ||");
        System.out.println("||\u001B[35m ❌  3-\u001b[0mQuitter le jeu \u001b[0m                             ||");
        System.out.println("=======================================================\n");
        return scanner.next();
    }

    /**
     * Displays a win message to the user and presents the option to restart the
     * game or quit.
     * 
     * @return A {@link String} representing the user's choice to restart or quit.
     */
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

    /**
     * Displays a lose message to the user and presents the option to restart the
     * game or quit.
     * 
     * @param tileString name of the monster that killed the player
     * @return A {@link String} representing the user's choice to restart or quit.
     */
    public String loseMenu(String tileString) {
        System.out.println("Vous avez été tué par un " + tileString);
        System.out.println("\n\u001B[35m1-Rejouer \n2-Quitter le jeu \u001b[0m");
        return scanner.next();
    }

    /**
     * Displays to the player a lose sentence.
     */
    public void printLose() {
        System.out.println("\u001b[33m \n\t---VOUS AVEZ PERDU--- \u001b[0m \n");
    }

    /**
     * Prints the event associated with a given tile depending on the player
     * position on the board.
     *
     * @param tableau the Case object representing the current tile to display.
     */
    public void printTileEvent(Case tableau) {
        System.out.println("\u001B[36m");
        System.out.println(tableau);
        System.out.println("\u001B[0m");
    }

    /**
     * Displays the result of a dice throw in a formatted message.
     * This method can be called after a player rolls the dice.
     * 
     * @param tileNumber tile on which the player is stationed
     */
    public void showPlayerTile(int tileNumber) {
        System.out.println(
                "\n\n\u001b[33m  Vous vous trouvez sur la case n°" + (tileNumber + 1)
                        + "/64. \u001b[0m \n\n=======================================================\n\n");

    }

    /**
     * Show result of the random (1-6) dice throw.
     */
    public void showDiceThrow() {
        System.out.println("\t\u001b[33m Résultat du lancer de dés: \u001b[0m ");
    }

    /**
     * Clears the console screen.
     * This method uses ANSI escape codes to clear the terminal screen.
     */
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
