
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Personnage personnage = new Personnage();
        Game game = new Game(menu, personnage);
        game.createMenu();
    }
}