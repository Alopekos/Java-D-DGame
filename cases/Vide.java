package cases;

import personnages.Personnage;

public class Vide implements Case {
    @Override
    public String printArt() {
        String msg = """
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
        return msg;
    }

    @Override
    public void interact(Personnage personnage) {
    }

    @Override
    public String toString() {
        String msg = printArt();
        return msg;
    }
}