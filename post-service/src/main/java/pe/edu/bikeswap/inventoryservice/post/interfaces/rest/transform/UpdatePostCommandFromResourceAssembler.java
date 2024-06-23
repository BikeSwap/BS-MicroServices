package pe.edu.bikeswap.inventoryservice.post.interfaces.rest.transform;

import pe.edu.bikeswap.inventoryservice.post.domain.model.commands.UpdatePostCommand;
import pe.edu.bikeswap.inventoryservice.post.interfaces.rest.resource.UpdatePostResource;

public class UpdatePostCommandFromResourceAssembler {
    public static UpdatePostCommand toCommandFromResource(Long postId, UpdatePostResource resource){
        return new UpdatePostCommand(
                postId,
                resource.title(),
                resource.description(),
                resource.price()
        );
    }
}
