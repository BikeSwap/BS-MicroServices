package pe.edu.bikeswap.rental_service.domain.service;

import pe.edu.bikeswap.rental_service.domain.model.rental;

import java.util.List;

public interface RentalService {
    rental create(rental rental);
    List<rental> getAll();
    rental getById(Long rentalId);
    void delete(Long rentalId);
    List<rental> getByBicycleId(Long bicycleId);
}
