package exceptions;


public class InvalidTradeException extends Exception {
    public InvalidTradeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}