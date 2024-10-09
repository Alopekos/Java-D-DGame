package Cases;

public class Vide implements Case {

    public String caseDepart() {
        String msg = "Vous êtes actuellement sur la case départ";
        return msg;
    }

    @Override
    public String toString() {
        String msg = "Cette case est vide";
        return msg;
    }
}