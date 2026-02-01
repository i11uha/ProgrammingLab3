package exceptions;


public class NoHarvestException extends Exception {
    public NoHarvestException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}