package ennemis;

public class Sorcier extends Ennemi {

    public Sorcier() {
        super("Sorcier", 2, 9);
    }

    @Override
    public String printArt() {
        String msg = """
                                    ____
                                  .'* *.'
                               __/_*_*(_
                              / _______ \\
                             _\\_)/___\\(_/_
                            / _((\\o o/))_ \\
                            \\ \\())(-)(()/ /
                             ' \\(((()))/ '
                            / ' \\)).))/ ' \\
                           / _ \\ - | - /_  \\
                          (   ( .;''';. .'  )
                          _\\"__ /    )\\ __"/_
                            \\/  \\   ' /  \\/
                             .'  '...' ' )
                              / /  |  \\ \\
                             / .   .   . \\
                            /   .     .   \\
                           /   /   |   \\   \\
                         .'   /    b    '.  '.
                     _.-'    /     Bb     '-. '-._
                 _.-'       |      BBb       '-.  '-.
                (____________\\____.dBBBb.________)____)
                                """;
        return msg;
    }

    @Override
    public String toString() {
        String msg = "Sorcier";
        return msg;
    }
}