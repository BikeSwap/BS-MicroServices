package pe.edu.bikeswap.rentalservice.rental.application.internal.queryServices;

import org.springframework.stereotype.Service;
import pe.edu.bikeswap.rentalservice.infraestructure.persistence.jpa.repositories.RentalRepository;
import pe.edu.bikeswap.rentalservice.rental.domain.model.aggregates.Rental;
import pe.edu.bikeswap.rentalservice.rental.domain.model.querys.GetRentalById;
import pe.edu.bikeswap.rentalservice.rental.domain.services.RentalQueryService;

import java.util.List;
import java.util.Optional;

@Service
public class RentalQueryServiceImpl implements RentalQueryService {
    public final RentalRepository rentalRepository;

    public RentalQueryServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public Optional<Rental> handle(GetRentalById rentalById) {
        return rentalRepository.findById(rentalById.rentalId());
    }

    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }
}
