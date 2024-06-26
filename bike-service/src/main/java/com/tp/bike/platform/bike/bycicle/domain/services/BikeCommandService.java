package com.tp.bike.platform.bike.bycicle.domain.services;


import com.tp.bike.platform.bike.bycicle.domain.model.commands.CreateBikeCommand;

public interface BikeCommandService {
    Long handle(CreateBikeCommand createBikeCommand);
}
