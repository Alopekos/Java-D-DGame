package equipement.potion;

public class GrandePotion extends Potion {
    public GrandePotion() {
        super(5);
    }

    @Override
    public String printArt() {
        return """
                               _____
                              `.___,'
                               (___)
                               <   >
                                ) (
                               /`-.\\
                              /     \\
                             / _    _\\
                            :,' `-.' `:
                            |         |
                            :         ;
                             \\       /
                              `.___.'
                """;
    }
}