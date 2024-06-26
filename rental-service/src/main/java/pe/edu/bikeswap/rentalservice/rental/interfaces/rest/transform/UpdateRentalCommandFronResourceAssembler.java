package pe.edu.bikeswap.rentalservice.rental.interfaces.rest.transform;

import pe.edu.bikeswap.rentalservice.rental.domain.model.commands.UpdateRentalCommand;
import pe.edu.bikeswap.rentalservice.rental.interfaces.rest.resource.UpdateRentalResource;

public class UpdateRentalCommandFronResourceAssembler {
    public static UpdateRentalCommand toCommandFromResource(Long rentalId, UpdateRentalResource resource){
        return new UpdateRentalCommand(
                rentalId,
                resource.rentStartDate(),
                resource.rentEndDate(),
                resource.rentPrice()
        );
    }
}
