package com.tp.bike.platform.bike.bycicle.interfaces.rest.transform;


import com.tp.bike.platform.bike.bycicle.domain.model.commands.CreateBikeCommand;
import com.tp.bike.platform.bike.bycicle.interfaces.rest.resource.CreateBikeResource;

public class CreateBikeCommandFromResourceAssembler {
    public  static CreateBikeCommand toCommandFromResource(CreateBikeResource resource){
        return new CreateBikeCommand(
                resource.name(),
                resource.description(),
                resource.price(),
                resource.model(),
                resource.image());
    }
}
