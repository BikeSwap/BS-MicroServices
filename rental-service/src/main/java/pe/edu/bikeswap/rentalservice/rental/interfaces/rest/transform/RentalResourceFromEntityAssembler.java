package pe.edu.bikeswap.rentalservice.rental.interfaces.rest.transform;

import pe.edu.bikeswap.rentalservice.rental.domain.model.aggregates.Rental;
import pe.edu.bikeswap.rentalservice.rental.interfaces.rest.resource.RentalResource;

public class RentalResourceFromEntityAssembler {

    public static RentalResource toResourceFromEntity(Rental rental) {
        return new RentalResource(
                rental.getId(),
                rental.getRentStartDate(),
                rental.getRentEndDate(),
                rental.getRentPrice()
        );
    }
}
