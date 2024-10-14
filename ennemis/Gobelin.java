package ennemis;

public class Gobelin extends Ennemi {

    public Gobelin() {
        super("Gobelin", 1, 6);
    }

    @Override
    public String printArt() {
        String msg = """
                \t               ,      ,
                \t              /(.-""-.)\\
                \t          |\\  \\/      \\/  /|
                \t          | \\ / =.  .= \\ / |
                \t          \\( \\   o\\/o   / )/
                \t           \\_, '-/  \\-' ,_/
                \t             /   \\__/   \\
                \t             \\ \\__/\\__/ /
                \t           ___\\ \\|--|/ /___
                \t         /`    \\      /    `\\
                \t        /       '----'       \\
                                  """;
        return msg;
    }

    @Override
    public String toString() {
        String msg = "Gobelin";
        return msg;
    }
}