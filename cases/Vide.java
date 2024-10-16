package cases;

import personnages.Personnage;

public class Vide implements Case {
    @Override
    public String printArt() {
        return """
                 /|     -_-                                             _-  |\\
                / |_-_- _                                         -_- _-   -| \\
                  |                            _-  _--                      |
                  |                            ,                            |
                  |      .-'````````'.        '(`        .-'```````'-.      |
                  |    .` |           `.      `)'      .` |           `.    |
                  |   /   |   ()        \\      U      /   |    ()       \\   |
                  |  |    |    ;         | o   T   o |    |    ;         |  |
                  |  |    |     ;        |  .  |  .  |    |    ;         |  |
                  |  |    |     ;        |   . | .   |    |    ;         |  |
                  |  |    |     ;        |    .|.    |    |    ;         |  |
                  |  |    |____;_________|     |     |    |____;_________|  |
                  |  |   /  __ ;   -     |     !     |   /     `'() _ -  |  |
                  |  |  / __  ()        -|        -  |  /  __--      -   |  |
                  |  | /        __-- _   |   _- _ -  | /        __--_    |  |
                  |__|/__________________|___________|/__________________|__|
                 /                                             _ -           \\
                /   -_- _ -             _- _---                       -_-  -_ \\
                                """;
    }

    @Override
    public int interact(Personnage personnage, int tileNumber) {
        // This tile does not interact with player
        return 0;
    }

    @Override
    public String toString() {
        return printArt();
    }
}