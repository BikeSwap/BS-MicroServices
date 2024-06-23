package pe.edu.bikeswap.inventoryservice.post.interfaces.rest.transform;

import pe.edu.bikeswap.inventoryservice.post.domain.model.aggregates.Post;
import pe.edu.bikeswap.inventoryservice.post.interfaces.rest.resource.PostResource;

public class PostResourceFromEntityAssembler {
    public static PostResource toResourceFromEntity(Post post) {
        return new PostResource(
                post.getId(),
                post.getTitle(),
                post.getDescription(),
                post.getPrice()
        );
    }
}
