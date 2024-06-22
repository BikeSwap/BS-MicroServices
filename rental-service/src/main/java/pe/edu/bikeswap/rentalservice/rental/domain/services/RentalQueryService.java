package pe.edu.bikeswap.rentalservice.rental.domain.services;

import pe.edu.bikeswap.rentalservice.rental.domain.model.aggregates.Rental;
import pe.edu.bikeswap.rentalservice.rental.domain.model.querys.GetRentalById;

import java.util.List;
import java.util.Optional;

public interface RentalQueryService {
    Optional<Rental> handle(GetRentalById rentalById);
    List<Rental> getAllRentals();
}
