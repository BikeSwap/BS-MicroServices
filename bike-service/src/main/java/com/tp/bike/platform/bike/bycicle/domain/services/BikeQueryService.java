package com.tp.bike.platform.bike.bycicle.domain.services;


import com.tp.bike.platform.bike.bycicle.domain.model.aggregates.Bike;
import com.tp.bike.platform.bike.bycicle.domain.model.querys.GetBikeById;

import java.util.List;
import java.util.Optional;
public interface BikeQueryService {
    Optional<Bike> handle(GetBikeById bikeById);
    List<Bike> getAllBikes();
}
