package pe.edu.bikeswap.rental_service.application.exception;


public class ResourceNotFoundException extends  RuntimeException{
    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
