package Cases;

public class Ennemi implements Case {
    private int atk;
    private int hp;
    private String name;

    public Ennemi(String name) {
        this.name = name;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtk() {
        return this.atk;
    }

    public int getHp() {
        return this.hp;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String msg = "Cette case contient un " + this.name;
        return msg;
    }
}