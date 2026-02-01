package exceptions;


public class OverloadException extends Exception {
    public OverloadException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}