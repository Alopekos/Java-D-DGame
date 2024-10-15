package equipement.potion;

public class PotionMineure extends Potion {

    public PotionMineure() {
        super(2);
    }

    @Override
    public String printArt() {
        return """

                \t          (-)
                \t        .-'-'-.
                \t        |-...-|
                \t        |;:.._|
                \t        `-...-'
                                """;

    }
}