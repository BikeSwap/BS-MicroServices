package pe.edu.bikeswap.inventoryservice.application.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
