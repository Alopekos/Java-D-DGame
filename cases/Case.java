package cases;

import personnages.Personnage;

public interface Case {

    int interact(Personnage personnage, int tileNumber);

    String printArt();
}