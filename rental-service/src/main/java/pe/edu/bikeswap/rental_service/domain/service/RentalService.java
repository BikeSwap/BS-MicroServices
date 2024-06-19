package pe.edu.bikeswap.rental_service.domain.service;

import pe.edu.bikeswap.rental_service.domain.model.Rental;

import java.util.List;

public interface RentalService {
    Rental create(Rental rental);
    List<Rental> getAll();
    Rental getById(Long rentalId);
    Rental update(Long rentalId, Rental rental);
    void delete(Long rentalId);
    //List<Rental> getByBicycleId(Long bicycleId);
}
