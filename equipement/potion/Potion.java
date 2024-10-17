package equipement.potion;

import cases.Interactable;
import personnages.Personnage;

public abstract class Potion implements Interactable {
    private int hpRestore;

    protected Potion(int hpRestore) {
        this.hpRestore = hpRestore;
    }

    public void setHpRestore(int restore) {
        this.hpRestore = restore;
    }

    public int getHpRestore() {
        return this.hpRestore;
    }

    @Override
    public int interact(Personnage personnage, int tileNumber) {
        if (personnage.getNiveauDeVie() + hpRestore > personnage.getMaxHp()) {
            personnage.setNiveauDeVie(personnage.getMaxHp());
        } else {
            personnage.setNiveauDeVie(personnage.getNiveauDeVie() + hpRestore);
        }
        return 0;

    }

    @Override
    public String toString() {
        return printArt() + "\n\tPotion redonnant " + this.hpRestore + "PDV";
    }
}