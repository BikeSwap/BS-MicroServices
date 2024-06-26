package pe.edu.bikeswap.inventoryservice.post.domain.services;

import pe.edu.bikeswap.inventoryservice.post.domain.model.commands.CreatePostCommand;
import pe.edu.bikeswap.inventoryservice.post.domain.model.commands.UpdatePostCommand;

public interface PostCommandService {
    Long handle(CreatePostCommand createPostCommand);
    void delete(Long rentalId);
    void update(UpdatePostCommand updatePostCommand);
}
