package cases;

import personnages.Personnage;

public interface Interactable {

    int interact(Personnage personnage, int tileNumber);

    String printArt();
}