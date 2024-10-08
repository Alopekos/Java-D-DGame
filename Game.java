import Personnages.*;
import EquipementDefense.Bouclier;
import EquipementDefense.EquipementDefensif;
import EquipementDefense.Philtre;
import EquipementOffense.Arme;
import EquipementOffense.EquipementOffensif;
import EquipementOffense.Sort;

public class Game {
    private Personnage personnage;
    private EquipementOffensif weapon;
    private EquipementDefensif defensive;
    public Menu menu;

    public Game(Menu menu) {
        this.menu = menu;
    }

    public void createMenu() {

        String menu_choice = menu.choseMenu();

        switch (menu_choice) {

            case "1" -> this.startGame();
            case "2" -> {
            }
            default -> {
                menu.clearScreen();
                createMenu();
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
                        throwDice(this.personnage);
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

    public boolean throwDice(Personnage personnage) {
        int tileNumber = 1;
        menu.showPlayerTile(tileNumber);
        while (true) {
            String showPersonnage = menu.dice_menu();
            int dice_roll = (int) ((Math.random() * 5) + 1);

            switch (showPersonnage) {
                case "1" -> {
                    menu.clearScreen();
                    if (tileNumber + dice_roll < 64) {
                        tileNumber += dice_roll;

                        menu.showDiceThrow();
                        menu.showPlayerTile(tileNumber);
                    } else if (tileNumber + dice_roll >= 64) {
                        tileNumber += dice_roll;
                        String restartOrClose = menu.win_menu();

                        switch (restartOrClose) {
                            case "1" -> {
                                menu.clearScreen();
                                menu.printDices();
                                throwDice(this.personnage);
                            }
                            case "2" -> {
                                menu.clearScreen();
                                System.exit(0);
                            }
                        }
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

    public boolean checkClassCompatibility(String classe) {
        return (classe.equals("mage") || classe.equals("guerrier"));
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

}