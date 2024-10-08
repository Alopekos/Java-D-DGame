
public class Game {
    private Personnage personnage;
    public Menu menu;

    public Game(Menu menu, Personnage personnage) {
        this.menu = menu;
        this.personnage = personnage;
    }

    public void setCharacter(Personnage personnage) {
        this.personnage = personnage;
    }

    public Personnage getCharacter() {
        return personnage;
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
                    if (checkClassCompatibility()) {
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
                    if (checkClassCompatibility()) {
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
                            case "1" -> throwDice(this.personnage);
                            case "2" -> {
                                menu.clearScreen();
                                System.exit(0);
                            }
                        }
                    }
                }
                case "2" -> {
                    menu.clearScreen();

                    if (checkClassCompatibility()) {
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

    public boolean checkClassCompatibility() {
        return (this.personnage.getClasse().equals("mage") || this.personnage.getClasse().equals("guerrier"));
    }

    public Personnage choseCharacter() {
        this.personnage.setClass("unknown");
        String classe = "";

        while (!checkClassCompatibility()) {
            menu.clearScreen();
            classe = menu.choseClassType(personnage);
        }

        String name = menu.choseName(personnage);

        this.personnage = new Personnage(classe, name);

        EquipementOffensif weapon = new EquipementOffensif("Lame de Doran", this.personnage);
        EquipementDefensif defensive = new EquipementDefensif("Bouclier Dentelé", this.personnage);

        this.personnage.equipWeapon(weapon);
        this.personnage.equipDefensive(defensive);

        return this.personnage;
    }
}