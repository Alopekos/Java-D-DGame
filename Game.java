import java.util.Scanner;

public class Game {
    private Personnage personnage;

    public void setCharacter(Personnage personnage) {
        this.personnage = personnage;
    }

    public Personnage getCharacter() {
        return personnage;
    }

    public void createMenu() {
        Menu menu_1 = new Menu();
        menu_1.choseMenu();
        Scanner scanner = new Scanner(System.in);
        String menu = scanner.next();
        switch (menu) {
            case "1" -> menu_1.startGame();
            default -> {
            }
        }
        scanner.close();
    }

}