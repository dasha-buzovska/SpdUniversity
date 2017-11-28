package pizzeria;

public class WrongInputException extends NumberFormatException {
    public String getMessage() {
        return "Wrong sign was typed!";
    }
}
