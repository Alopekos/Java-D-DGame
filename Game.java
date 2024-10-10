import Cases.Case;
import Cases.Vide;
import CustomException.OutOfMenuException;
import Ennemis.Dragon;
import Ennemis.Gobelin;
import Ennemis.Sorcier;
import EquipementDefense.Bouclier;
import EquipementDefense.EquipementDefensif;
import EquipementDefense.Philtre;
import EquipementOffense.Arme;
import EquipementOffense.EquipementOffensif;
import EquipementOffense.Sort;
import Personnages.Guerrier;
import Personnages.Mage;
import Personnages.Personnage;
import Potionspkg.GrandePotion;
import Potionspkg.PotionMineure;
import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private Personnage personnage;
    private EquipementOffensif weapon;
    private EquipementDefensif defensive;
    // private int positionJoueur;
    private ArrayList<Case> tableau;
    private final Menu menu;

    public Game() {
        this.menu = new Menu();
    }

    public void start_game() {
        createBoard();
        String menu_choice = menu.choseMenu();

        switch (menu_choice) {

            case "1" -> this.startGame();
            case "2" -> menu.clearScreen();
            default -> {
                menu.clearScreen();
                start_game();
            }
        }
    }

    public void startGame() {
        menu.clearScreen();

        boolean isMenuOver = false;

        choseCharacter();

        while (!isMenuOver) {

            String main_menu_choice = menu.main_menu();

            switch (main_menu_choice) {
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
                        jouer_un_tour(this.personnage);
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
                }
            }
        }
    }

    private boolean jouer_un_tour(Personnage personnage) {
        int tileNumber = 0;

        menu.showPlayerTile(tileNumber);
        while (true) {
            menu.printTileEvent(tableau.get(tileNumber));

            String showPersonnage = menu.dice_menu();
            int dice_roll = (int) ((Math.random() * 6) + 1);

            switch (showPersonnage) {
                case "1" -> {

                    tileNumber = dice_game(tileNumber, dice_roll);
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
            }

        }

    }

    private boolean checkClassCompatibility(String classe) {
        return (classe.equals("mage") || classe.equals("guerrier"));
    }

    private int dice_game(int tileNumber, int dice_roll) {

        menu.clearScreen();

        if (tileNumber + dice_roll < 63) {
            menu.showDiceThrow();
            menu.printSingleDice(dice_roll);
            tileNumber += dice_roll;
            menu.showPlayerTile(tileNumber);
        } else if (tileNumber + dice_roll == 63) {
            tileNumber += dice_roll;
            String restartOrClose = menu.win_menu();

            switch (restartOrClose) {
                case "1" -> {
                    choseCharacter();
                    menu.clearScreen();
                    menu.printDices();
                    jouer_un_tour(this.personnage);
                }
                case "2" -> {
                    menu.clearScreen();
                    System.exit(0);
                }
            }
        } else if (tileNumber + dice_roll > 63) {
            tileNumber = 63 - ((tileNumber + dice_roll) - 63);
            menu.showDiceThrow();
            menu.printSingleDice(dice_roll);
            menu.showPlayerTile(tileNumber);
        }
        return tileNumber;
    }

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
                weapon = new Sort();
                defensive = new Philtre();
                personnage.equipDefensive(defensive);
                personnage.equipWeapon(weapon);
            }
            case "guerrier" -> {
                personnage = new Guerrier(name);
                weapon = new Arme();
                defensive = new Bouclier();
                personnage.equipDefensive(defensive);
                personnage.equipWeapon(weapon);
            }
            default -> {
            }
        }

        return personnage;
    }

    public void createBoard() {

        tableau = new ArrayList<>();

        int numberOfEntries = 0;

        numberOfEntries += insertEncounter(15, new Gobelin());
        numberOfEntries += insertEncounter(10, new Sorcier());
        numberOfEntries += insertEncounter(7, new Dragon());
        numberOfEntries += insertEncounter(5, new Philtre("Potion du divin"));
        numberOfEntries += insertEncounter(5, new Bouclier("Bouclier du divin"));
        numberOfEntries += insertEncounter(4, new GrandePotion());
        numberOfEntries += insertEncounter(7, new PotionMineure());

        numberOfEntries = 64 - numberOfEntries;

        // Rajouter les cases vides
        for (int i = 0; i < numberOfEntries; i++) {
            tableau.add(new Vide());
        }

        Collections.shuffle(tableau);
        tableau.set(0, new Vide());
    }

    private int insertEncounter(int number, Case name) {
        for (int i = 0; i < number; i++) {
            tableau.add(name);
        }
        return number;
    }

    private void checkForLose(Case tile) {
        if (personnage.getNiveauDeVie() < 1) {
            menu.clearScreen();
            menu.printLose();
            menu.printTileEvent(tile);
            String restartOrClose = menu.lose_menu(tile.toString());

            switch (restartOrClose) {
                case "1" -> {
                    choseCharacter();
                    menu.clearScreen();
                    menu.printDices();
                    jouer_un_tour(this.personnage);
                }
                case "2" -> {
                    menu.clearScreen();
                    System.exit(0);
                }
            }
        }
    }
}