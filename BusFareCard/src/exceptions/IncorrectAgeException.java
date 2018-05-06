package exceptions;

public class IncorrectAgeException extends Exception {

    public IncorrectAgeException() {

    }

    public IncorrectAgeException(String msg) {
        super(msg);
    }
}
