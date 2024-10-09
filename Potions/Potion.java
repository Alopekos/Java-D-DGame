package Potions;

import Cases.Case;

public class Potion implements Case {
    private int hpRestore;

    public Potion() {

    }

    public void setHpRestore(int restore) {
        this.hpRestore = restore;
    }

    public int getHpRestore() {
        return this.hpRestore;
    }

    @Override
    public String toString() {
        String msg = "Cette case contient une potion redonnant " + this.hpRestore;
        return msg;
    }
}