package pe.edu.bikeswap.inventoryservice.post.domain.services;

import pe.edu.bikeswap.inventoryservice.post.domain.model.aggregates.Post;
import pe.edu.bikeswap.inventoryservice.post.domain.model.querys.GetPostById;

import java.util.List;
import java.util.Optional;

public interface PostQueryService {
    Optional<Post> handle(GetPostById postById);
    List<Post> getAllPosts();
}
