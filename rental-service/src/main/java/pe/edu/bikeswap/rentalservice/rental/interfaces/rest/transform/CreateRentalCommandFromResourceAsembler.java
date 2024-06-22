package pe.edu.bikeswap.rentalservice.rental.interfaces.rest.transform;

import pe.edu.bikeswap.rentalservice.rental.domain.model.commands.CreateRentalCommand;
import pe.edu.bikeswap.rentalservice.rental.interfaces.rest.resource.CreateRentalResource;

public class CreateRentalCommandFromResourceAsembler {
    public static CreateRentalCommand toCommandFromResource(CreateRentalResource resource){
        return new CreateRentalCommand(
                resource.rentStartDate(),
                resource.rentEndDate(),
                resource.rentPrice()
        );
    }
}
