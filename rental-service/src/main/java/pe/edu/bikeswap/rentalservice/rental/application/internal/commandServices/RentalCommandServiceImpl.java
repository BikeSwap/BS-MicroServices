package pe.edu.bikeswap.rentalservice.rental.application.internal.commandServices;

import org.springframework.stereotype.Service;
import pe.edu.bikeswap.rentalservice.infraestructure.persistence.jpa.repositories.RentalRepository;
import pe.edu.bikeswap.rentalservice.rental.domain.model.aggregates.Rental;
import pe.edu.bikeswap.rentalservice.rental.domain.model.commands.CreateRentalCommand;
import pe.edu.bikeswap.rentalservice.rental.domain.model.commands.UpdateRentalCommand;
import pe.edu.bikeswap.rentalservice.rental.domain.services.RentalCommandService;

@Service
public class RentalCommandServiceImpl implements RentalCommandService {
    private final RentalRepository rentalRepository;

    public RentalCommandServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public Long handle(CreateRentalCommand createRentalCommand) {
        var rental = new Rental(
                createRentalCommand.rentStartDate(),
                createRentalCommand.rentEndDate(),
                createRentalCommand.rentPrice());
        rentalRepository.save(rental);
        return rental.getId();
    }

    @Override
    public void delete(Long rentalId) {
        rentalRepository.deleteById(rentalId);
    }

    @Override
    public void update(UpdateRentalCommand updateRentalCommand) {
        var optionalRental = rentalRepository.findById(updateRentalCommand.rentalId());
        if(optionalRental.isPresent()){
            Rental rental = optionalRental.get();
            rental.setRentStartDate(updateRentalCommand.rentStartDate());
            rental.setRentEndDate(updateRentalCommand.rentEndDate());
            rental.setRentPrice(updateRentalCommand.rentPrice());

            rentalRepository.save(rental);
        }else {
            throw new IllegalArgumentException("RentalId not found" + updateRentalCommand.rentalId());
        }
    }
}
