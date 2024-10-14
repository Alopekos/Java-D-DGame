package equipement.potion;

public class GrandePotion extends Potion {
    public GrandePotion() {
        super(5);
    }

    @Override
    public String printArt() {
        String msg = """
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
        return msg;
    }
}