package pe.edu.bikeswap.inventoryservice.post.interfaces.rest.transform;

import pe.edu.bikeswap.inventoryservice.post.domain.model.commands.CreatePostCommand;
import pe.edu.bikeswap.inventoryservice.post.interfaces.rest.resource.CreatePostResource;

public class CreatePostCommandFromResourceAsembler {
    public static CreatePostCommand toCommandFromResource(CreatePostResource resource){
        return new CreatePostCommand(
                resource.title(),
                resource.description(),
                resource.price()
        );
    }
}
