package equipement.potion;

public class PotionMineure extends Potion {

    public PotionMineure() {
        super(2);
    }

    @Override
    public String printArt() {
        String msg = """

                \t          (-)
                \t        .-'-'-.
                \t        |-...-|
                \t        |;:.._|
                \t        `-...-'
                                """;
        return msg;
    }
}