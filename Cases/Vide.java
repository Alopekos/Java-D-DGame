package Cases;

import Personnages.Personnage;

public class Vide implements Case {

    public String caseDepart() {
        String msg = "Vous êtes actuellement sur la case départ";
        return msg;
    }

    @Override
    public void interact(Personnage personnage) {
    }

    @Override
    public String toString() {
        String msg = "Case: vide";
        return msg;
    }
}