package equipement.potion;

import cases.Case;
import personnages.Personnage;

public abstract class Potion implements Case {
    private int hpRestore;

    public Potion(int hpRestore) {
        this.hpRestore = hpRestore;
    }

    public void setHpRestore(int restore) {
        this.hpRestore = restore;
    }

    public int getHpRestore() {
        return this.hpRestore;
    }

    @Override
    public void interact(Personnage personnage) {
        if (personnage.getNiveauDeVie() + hpRestore > personnage.getMaxHp()) {
            personnage.setNiveauDeVie(personnage.getMaxHp());
        } else {
            personnage.setNiveauDeVie(personnage.getNiveauDeVie() + hpRestore);
        }
    }

    @Override
    public String toString() {
        String msg = printArt() + "\n\tPotion redonnant " + this.hpRestore + "PDV";
        return msg;
    }
}