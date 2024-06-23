package pe.edu.bikeswap.inventoryservice.post.application.internal.queryServices;

import org.springframework.stereotype.Service;
import pe.edu.bikeswap.inventoryservice.infraestructure.persistence.jpa.repositories.PostRepository;
import pe.edu.bikeswap.inventoryservice.post.domain.model.aggregates.Post;
import pe.edu.bikeswap.inventoryservice.post.domain.model.querys.GetPostById;
import pe.edu.bikeswap.inventoryservice.post.domain.services.PostQueryService;

import java.util.List;
import java.util.Optional;

@Service
public class PostQueryServiceImpl implements PostQueryService {
    private final PostRepository postRepository;

    public PostQueryServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Optional<Post> handle(GetPostById postById) {
        return postRepository.findById(postById.postId());
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
