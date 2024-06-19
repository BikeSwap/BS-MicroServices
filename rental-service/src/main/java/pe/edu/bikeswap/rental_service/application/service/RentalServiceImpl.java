package pe.edu.bikeswap.rental_service.application.service;

import org.springframework.stereotype.Service;
import pe.edu.bikeswap.rental_service.application.exception.ResourceNotFoundException;
import pe.edu.bikeswap.rental_service.application.mapper.RentalMapper;
import pe.edu.bikeswap.rental_service.domain.model.Rental;
import pe.edu.bikeswap.rental_service.domain.repository.RentalRepository;
import pe.edu.bikeswap.rental_service.domain.service.RentalService;
import pe.edu.bikeswap.rental_service.entity.RentalEntity;

import java.util.List;
@Service
public class RentalServiceImpl implements RentalService {
    //private static final String ENTITY = "Rent";
    private final RentalRepository rentalRepository;

    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public Rental create(Rental rental) {
        RentalEntity rentalEntity = RentalMapper.INSTANCE.rentalModelToEntity(rental);
        return RentalMapper.INSTANCE.rentalEntityToModel(rentalRepository.save(rentalEntity));
    }

    @Override
    public List<Rental> getAll() {
        List<RentalEntity> rentalEntities = rentalRepository.findAll();
        return RentalMapper.INSTANCE.rentalEntityListToModelList(rentalEntities);
    }

    @Override
    public Rental getById(Long rentalId) {
        existsRentalById(rentalId);
        RentalEntity rentalEntity = rentalRepository.findById(rentalId).orElse(null);
        return RentalMapper.INSTANCE.rentalEntityToModel(rentalEntity);
    }

    @Override
    public Rental update(Long rentalId, Rental rental) {
        existsRentalById(rentalId);
        rental.setId(rentalId);
        RentalEntity rentalEntity = RentalMapper.INSTANCE.rentalModelToEntity(rental);
        rentalRepository.save(rentalEntity);
        return rental;
    }

    @Override
    public void delete(Long rentalId) {
        existsRentalById(rentalId);
        rentalRepository.deleteById(rentalId);
    }
        private void existsRentalById(Long rentalId) {
            if (!rentalRepository.existsById(rentalId)) {throw new ResourceNotFoundException("No existe la bicicleta con el id: " + rentalId);}
        }

/*
    @Override
    public List<Rental> getByBicycleId(Long bicycleId) {
        return rentalRepository.findByBicycleId(bicycleId);
    }*/


}
