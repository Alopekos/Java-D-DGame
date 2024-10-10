package customException;

public class PersonnageHorsPlateauException extends Exception {
    public PersonnageHorsPlateauException() {
    }

    public PersonnageHorsPlateauException(String message) {
        super(message);
    }
}