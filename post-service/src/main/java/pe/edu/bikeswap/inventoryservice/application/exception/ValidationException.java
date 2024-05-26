package pe.edu.bikeswap.inventoryservice.application.exception;

public class ValidationException extends RuntimeException {
    public ValidationException() {
        super();
    }

    public ValidationException(String message) {
        super(message);
    }
}
