package pe.edu.bikeswap.bike_service.application.service;

import org.springframework.stereotype.Service;
import pe.edu.bikeswap.bike_service.application.exception.ResourceNotFoundException;
import pe.edu.bikeswap.bike_service.application.mapper.BikeMapper;
import pe.edu.bikeswap.bike_service.domain.model.Bike;
import pe.edu.bikeswap.bike_service.domain.repository.BikeRepository;
import pe.edu.bikeswap.bike_service.domain.service.BikeService;
import pe.edu.bikeswap.bike_service.entity.BikeEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {
    private final BikeRepository bikeRepository;

    public BikeServiceImpl(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Override
    public Bike createBike(Bike bike) {
        BikeEntity bikeEntity = BikeMapper.INSTANCE.bicycleModelToEntity(bike);
        return BikeMapper.INSTANCE.bicycleEntityToModel(bikeRepository.save(bikeEntity));
    }

    @Override
    public Bike getBikeById(Long bicycle_id) {
        existsBicycleByBicycleId(bicycle_id);
        BikeEntity bikeEntity = bikeRepository.findById(bicycle_id).orElse(null);
        return BikeMapper.INSTANCE.bicycleEntityToModel(bikeEntity);
    }

    @Override
    public Bike updateBike(Long bicycleId, Bike bike) {
        existsBicycleByBicycleId(bicycleId);
        bike.setId(bicycleId);
        BikeEntity bikeEntity = BikeMapper.INSTANCE.bicycleModelToEntity(bike);
        bikeRepository.save(bikeEntity);
        return bike;
    }

    @Override
    public void deleteBike(Long bicycle_id) {
        existsBicycleByBicycleId(bicycle_id);
        bikeRepository.deleteById(bicycle_id);
    }

    @Override
    public List<Bike> getAllBikes() {
        List<BikeEntity> bicycleEntities = bikeRepository.findAll();
        return BikeMapper.INSTANCE.bicycleEntityListToModelList(bicycleEntities);
    }

    @Override
    public List<Bike> getAllAvailableBikes(LocalDate start_date, LocalDate end_date) {
        List<BikeEntity> bicycleEntities = bikeRepository.findAll();
        List<Bike> availableBicycles = new ArrayList<>();
        for (BikeEntity bikeEntity : bicycleEntities) {
            Bike bike = BikeMapper.INSTANCE.bicycleEntityToModel(bikeEntity);
            availableBicycles.add(bike);
        }
        return availableBicycles;
    }

    private void existsBicycleByBicycleId(Long bicycleId) {
        if (!bikeRepository.existsById(bicycleId)) {
            throw new ResourceNotFoundException("No existe la bicicleta con el id: " + bicycleId);
        }
    }
}
