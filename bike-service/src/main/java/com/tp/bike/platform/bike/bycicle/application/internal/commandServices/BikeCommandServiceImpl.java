package com.tp.bike.platform.bike.bycicle.application.internal.commandServices;

import com.tp.bike.platform.bike.bycicle.domain.model.aggregates.Bike;
import com.tp.bike.platform.bike.bycicle.domain.model.commands.CreateBikeCommand;
import com.tp.bike.platform.bike.bycicle.domain.services.BikeCommandService;
import com.tp.bike.platform.bike.infraestructure.persistence.jpa.repositories.BikeRepository;
import org.springframework.stereotype.Service;

@Service
public class BikeCommandServiceImpl implements BikeCommandService {

    private final BikeRepository bikeRepository;
    public  BikeCommandServiceImpl(BikeRepository bikeRepository){
        this.bikeRepository=bikeRepository;
    }
    @Override
    public  Long handle(CreateBikeCommand createBikeCommand){
        var bike= new Bike(createBikeCommand.name(),
                createBikeCommand.description(),
                createBikeCommand.price(),
                createBikeCommand.model(),
                createBikeCommand.image());
        bikeRepository.save(bike);
        return bike.getId();
    }

}