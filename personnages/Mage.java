package personnages;

public class Mage extends Personnage {

    public Mage(String name) {
        super(name,
         "mage",
          ((int) ((Math.random() * 3) + 3)), 
          ((int) ((Math.random() * 7) + 8)));
    }
}