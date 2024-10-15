import java.util.*;
import cases.Vide;
import cases.Case;
import customException.OutOfMenuException;
import ennemis.Dragon;
import ennemis.Gobelin;
import ennemis.Sorcier;
import equipement.defense.Bouclier;
import equipement.defense.Philtre;
import equipement.offense.Arme;
import equipement.offense.Sort;
import equipement.potion.GrandePotion;
import equipement.potion.PotionMineure;
import java.util.ArrayList;
import java.util.Collections;
import personnages.Guerrier;
import personnages.Mage;
import personnages.Personnage;

public class Game {
    private Personnage personnage;
    private ArrayList<Case> tableau;
    private final Menu menu;

    /**
     * The Game class represents the logic that connects different aspects
     * of the game.
     * It initializes a character (Personnage) with offensive and defensive
     * equipment.
     * It also creates a game board as an ArrayList for the character to move on.
     * 
     * The Menu class is used to gather input from the user for character
     * customization.
     */
    public Game() {
        this.menu = new Menu();
    }

    /**
     * Starts the game and presents the initial menu to the user.
     * Depending on the user's choice, the game either begins or exits.
     */
    public void startGame() {
        try {
            createBoard();
            String menuChoice = menu.choseMenu();

            switch (menuChoice) {
                case "1" -> this.mainScreenMenu();
                case "2" -> menu.clearScreen();
                default -> {
                    menu.clearScreen();
                    throw new OutOfMenuException("OutOfMenuException: Choix de menu non-valide. Veuillez réessayer.\n");
                }
            }
        } catch (OutOfMenuException e) {
            System.out.println(e.getMessage());
            mainScreenMenu();
        }
    }

    /**
     * Displays the main menu, allowing the user to:
     * 1. Check the character's stats
     * 2. Change the character
     * 3. Start the game
     * 4. Quit the game
     */
    public void mainScreenMenu() {
        menu.clearScreen();

        boolean isMenuOver = false;

        choseCharacter();

        while (!isMenuOver) {

            String mainMenuChoice = menu.mainMenu();

            switch (mainMenuChoice) {
                case "1" -> {
                    menu.clearScreen();
                    if (checkClassCompatibility(personnage.getClasse())) {
                        menu.printPersonnage(personnage);
                    } else {
                        menu.printInvalidClass();
                    }
                }
                case "2" -> {
                    choseCharacter();
                }
                case "3" -> {
                    menu.clearScreen();
                    if (checkClassCompatibility(personnage.getClasse())) {
                        menu.printDices();

                        isMenuOver = true;
                        jouerUnTour(this.personnage);
                    } else {
                        menu.printInvalidClass();
                    }
                }
                case "4" -> {
                    menu.clearScreen();
                    isMenuOver = true;
                    menu.clearScreen();
                }
                default -> {
                    break;
                }
            }
        }
    }

    /**
     * Plays a turn in the game by rolling a dice and advancing the character.
     * Based on the tile the character lands on, an event occurs (enemy encounter,
     * item pickup, etc.). The game checks if the player has lost after each move.
     * 
     * @param personnage the character playing the game
     * @return true if the game continues, false if it ends
     */
    private boolean jouerUnTour(Personnage personnage) {
        int tileNumber = 0;
        Random random = new Random();
        menu.showPlayerTile(tileNumber);
        
        while (true) {
            menu.printTileEvent(tableau.get(tileNumber));

            String showPersonnage = menu.diceMenu();
            int diceRoll = random.nextInt(6) + 1;

            switch (showPersonnage) {
                case "1" -> {
                    tileNumber = diceGame(tileNumber, diceRoll);
                    tableau.get(tileNumber).interact(personnage);
                    checkForLose(tableau.get(tileNumber));
                }
                case "2" -> {
                    menu.clearScreen();

                    if (checkClassCompatibility(personnage.getClasse())) {
                        menu.printPersonnage(personnage);
                    } else {
                        menu.printInvalidClass();
                    }
                }
                case "3" -> {
                    menu.clearScreen();
                    System.exit(0);
                }
                default -> {
                    break;
                }
            }

        }

    }

    /**
     * Checks if the given class (either mage or warrior) is valid.
     * 
     * @param classe the class of the character
     * @return true if the class is valid, false otherwise
     */
    private boolean checkClassCompatibility(String classe) {
        return (classe.equals("mage") || classe.equals("guerrier"));
    }

    /**
     * Rolls a dice and advances the character on the board.
     * The function ensures that the character doesn't go beyond the final tile
     * (tile 63).
     * If the player lands exactly on tile 63, they win.
     * 
     * @param tileNumber the current tile number
     * @param dice_roll  the value rolled on the dice
     * @return the new tile number
     */
    private int diceGame(int tileNumber, int diceRoll) {
        menu.clearScreen();

        if (tileNumber + diceRoll < 63) {
            menu.showDiceThrow();
            menu.printSingleDice(diceRoll);
            tileNumber += diceRoll;
            menu.showPlayerTile(tileNumber);
        } else if (tileNumber + diceRoll == 63) {
            tileNumber += diceRoll;
            String restartOrClose = menu.winMenu();

            switch (restartOrClose) {
                case "1" -> {
                    choseCharacter();
                    menu.clearScreen();
                    menu.printDices();
                    jouerUnTour(this.personnage);
                }
                case "2" -> {
                    menu.clearScreen();
                    System.exit(0);
                }
                default -> {
                    break;
                }
            }
        } else if (tileNumber + diceRoll > 63) {
            tileNumber = 63 - ((tileNumber + diceRoll) - 63);
            menu.showDiceThrow();
            menu.printSingleDice(diceRoll);
            menu.showPlayerTile(tileNumber);
        }
        return tileNumber;
    }

    /**
     * Allows the user to select a character, either a mage or a warrior,
     * and equips the character with the appropriate weapon and defensive equipment.
     * 
     * @return the chosen character (Personnage)
     */
    public Personnage choseCharacter() {

        String classe = "";

        while (!checkClassCompatibility(classe)) {
            menu.clearScreen();
            classe = menu.choseClassType();
        }

        String name = menu.choseName();
        switch (classe) {
            case "mage" -> {
                personnage = new Mage(name);
                personnage.equipDefensive(new Philtre());
                personnage.equipWeapon(new Sort());
            }
            case "guerrier" -> {
                personnage = new Guerrier(name);
                personnage.equipDefensive(new Bouclier());
                personnage.equipWeapon(new Arme());
            }
            default -> {
                break;
            }
        }

        return personnage;
    }

    /**
     * Creates the game board with 64 tiles and randomly assigns encounters.
     * Fills the board with enemies, items, and empty tiles, then shuffles it.
     */
    public void createBoard() {
        tableau = new ArrayList<>();

        int numberOfEntries = 0;

        numberOfEntries += insertEncounter(10, new Gobelin());
        numberOfEntries += insertEncounter(10, new Sorcier());
        numberOfEntries += insertEncounter(4, new Dragon());
        numberOfEntries += insertEncounter(5, new Philtre("Potion divine", 2));
        numberOfEntries += insertEncounter(5, new Bouclier("Bouclier  divin", 2));
        numberOfEntries += insertEncounter(4, new Arme("Epée", 5));
        numberOfEntries += insertEncounter(5, new Arme("Massue", 3));
        numberOfEntries += insertEncounter(2, new Sort("Boule de feu", 7));
        numberOfEntries += insertEncounter(5, new Sort("Eclair", 2));
        numberOfEntries += insertEncounter(2, new GrandePotion());
        numberOfEntries += insertEncounter(6, new PotionMineure());

        int numberOfVide = 64 - numberOfEntries;

        for (int i = 0; i < numberOfVide; i++) {
            tableau.add(new Vide());
        }

        Collections.shuffle(tableau);
        tableau.set(0, new Vide());
    }

    /**
     * Inserts a specified number of encounters (entities) into the game board.
     * 
     * @param number the number of encounters to insert
     * @param name   the encounter entity (e.g., an enemy or item)
     * @return the number of encounters inserted
     */
    private int insertEncounter(int number, Case name) {
        for (int i = 0; i < number; i++) {
            tableau.add(name);
        }
        return number;
    }

    /**
     * Checks if the player's health is below 1. If so, it presents a menu to either
     * restart the game or exit.
     * 
     * @param tile the current tile the player is on
     */
    private void checkForLose(Case tile) {
        if (personnage.getNiveauDeVie() < 1) {
            menu.clearScreen();
            menu.printLose();
            menu.printTileEvent(tile);
            String restartOrClose = menu.loseMenu(tile.toString());

            switch (restartOrClose) {
                case "1" -> {
                    choseCharacter();
                    menu.clearScreen();
                    menu.printDices();
                    jouerUnTour(this.personnage);
                }
                case "2" -> {
                    menu.clearScreen();
                    System.exit(0);
                }
                default -> {
                    break;
                }
            }
        }
    }
}
