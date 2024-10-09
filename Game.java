import Cases.Case;
import Cases.Ennemi;
import Cases.Vide;
import CustomException.PersonnageHorsPlateauException;
import EquipementDefense.Bouclier;
import EquipementDefense.EquipementDefensif;
import EquipementDefense.Philtre;
import EquipementOffense.Arme;
import EquipementOffense.EquipementOffensif;
import EquipementOffense.Sort;
import Personnages.Guerrier;
import Personnages.Mage;
import Personnages.Personnage;
import Potions.Potion;
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
                    try {
                        if (tileNumber + dice_roll > 70) {
                            throw new PersonnageHorsPlateauException("Erreur: Vous êtes en dehors du plateau.");
                        }

                        tileNumber = dice_game(tileNumber, dice_roll);
                    } catch (PersonnageHorsPlateauException e) {
                        menu.clearScreen();
                        System.err.println(e.getMessage());
                    }
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
                weapon = new Sort("Eclair");
                defensive = new Philtre("Potion d'armure");
                personnage.equipWeapon(weapon);
                personnage.equipDefensive(defensive);
            }
            case "guerrier" -> {
                personnage = new Guerrier(name);
                weapon = new Arme("Epée de fou");
                defensive = new Bouclier("Bouclier de furieux");
                personnage.equipWeapon(weapon);
                personnage.equipDefensive(defensive);
            }
            default -> {
            }
        }

        return personnage;
    }

    public void createBoard() {
        Case vide = new Vide();
        Case philtre = new Philtre("Potion du divin");
        Case bouclier = new Bouclier("Bouclier du divin");
        Case potion = new Potion();

        tableau = new ArrayList<>();

        int numberOfEntries = 0;

        numberOfEntries += insertEnnemi(3, "Dragons");
        numberOfEntries += insertEnnemi(10, "Gobelin");
        numberOfEntries += insertEnnemi(7, "Sorcier");
        numberOfEntries += insertItem(3, philtre);
        numberOfEntries += insertItem(3, bouclier);
        numberOfEntries += insertItem(7, potion);

        numberOfEntries = 64 - numberOfEntries;

        // Rajouter les cases vides
        for (int i = 0; i < numberOfEntries; i++) {
            tableau.add(vide);
        }

        Collections.shuffle(tableau);
        tableau.set(0, vide);
    }

    private int insertEnnemi(int number, String name) {
        for (int i = 0; i < number; i++) {
            tableau.add(new Ennemi(name));
        }
        return number;
    }

    private int insertItem(int number, Case name) {
        for (int i = 0; i < number; i++) {
            tableau.add(name);
        }
        return number;
    }
}