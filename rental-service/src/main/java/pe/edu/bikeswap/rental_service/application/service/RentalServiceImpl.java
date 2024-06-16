package pe.edu.bikeswap.rental_service.application.service;

import pe.edu.bikeswap.rental_service.domain.model.rental;
import pe.edu.bikeswap.rental_service.domain.repository.RentalRepository;
import pe.edu.bikeswap.rental_service.domain.service.RentalService;

import java.util.List;

public class RentalServiceImpl implements RentalService {
    private static final String ENTITY = "Rent";
    private final RentalRepository rentalRepository;

    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public rental create(rental rental) {
        return rentalRepository.save(rental);
    }

    @Override
    public List<rental> getAll() {
        return rentalRepository.findAll();
    }

    @Override
    public rental getById(Long rentId) {
        return rentalRepository.findById(rentId).orElse(null);
    }

    @Override
    public void delete(Long rentId) {
        rentalRepository.deleteById(rentId);
    }

    @Override
    public List<rental> getByBicycleId(Long bicycleId) {
        return rentalRepository.findByBicycleId(bicycleId);
    }
}
