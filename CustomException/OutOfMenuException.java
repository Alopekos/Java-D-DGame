package CustomException;

public class OutOfMenuException extends Exception {
    public OutOfMenuException() {
    }

    public OutOfMenuException(String message) {
        super(message);
    }
}