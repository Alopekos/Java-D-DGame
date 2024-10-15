package ennemis;

public class Gobelin extends Ennemi {

    public Gobelin() {
        super("Gobelin", 1, 6);
    }

    @Override
    public String printArt() {
        return """
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
    }

    @Override
    public String toString() {
        return "Gobelin";
    }
}