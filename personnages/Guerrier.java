package personnages;

public class Guerrier extends Personnage {
    public Guerrier(String name) {
        super(name,
                "guerrier",
                ((int) ((Math.random() * 5) + 5)),
                ((int) ((Math.random() * 5) + 5)));
    }

}