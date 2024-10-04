import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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