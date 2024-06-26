package com.tp.bike.platform.bike.bycicle.interfaces.rest.transform;


import com.tp.bike.platform.bike.bycicle.domain.model.aggregates.Bike;
import com.tp.bike.platform.bike.bycicle.interfaces.rest.resource.BikeResource;

public class BikeResourceFromEntityAssembler {
    public static BikeResource toResourceFromEntity(Bike bike){
        return new BikeResource(
                bike.getId(),
                bike.getName(),
                bike.getDescription(),
                bike.getPrice(),
                bike.getModel(),
                bike.getImage());
    }
}