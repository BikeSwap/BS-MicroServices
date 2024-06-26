package pe.edu.bikeswap.rentalservice.rental.domain.services;

import pe.edu.bikeswap.rentalservice.rental.domain.model.commands.CreateRentalCommand;
import pe.edu.bikeswap.rentalservice.rental.domain.model.commands.UpdateRentalCommand;

public interface RentalCommandService {
    Long handle(CreateRentalCommand createRentalCommand);
    void delete(Long rentalId);
    void update(UpdateRentalCommand updateRentalCommand);
}
