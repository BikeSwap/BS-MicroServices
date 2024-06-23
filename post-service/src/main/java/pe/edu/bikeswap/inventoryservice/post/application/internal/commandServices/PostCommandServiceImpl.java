package pe.edu.bikeswap.inventoryservice.post.application.internal.commandServices;

import org.springframework.stereotype.Service;
import pe.edu.bikeswap.inventoryservice.infraestructure.persistence.jpa.repositories.PostRepository;
import pe.edu.bikeswap.inventoryservice.post.domain.model.aggregates.Post;
import pe.edu.bikeswap.inventoryservice.post.domain.model.commands.CreatePostCommand;
import pe.edu.bikeswap.inventoryservice.post.domain.model.commands.UpdatePostCommand;
import pe.edu.bikeswap.inventoryservice.post.domain.services.PostCommandService;

@Service
public class PostCommandServiceImpl implements PostCommandService {
    private final PostRepository postRepository;

    public PostCommandServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Long handle(CreatePostCommand createPostCommand) {
        var post = new Post(
                createPostCommand.title(),
                createPostCommand.description(),
                createPostCommand.price());
        postRepository.save(post);
        return post.getId();
    }

    @Override
    public void delete(Long rentalId) {
        postRepository.deleteById(rentalId);
    }

    @Override
    public void update(UpdatePostCommand updatePostCommand) {
        var optionalPost = postRepository.findById(updatePostCommand.postId());
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            post.setTitle(updatePostCommand.title());
            post.setDescription(updatePostCommand.description());
            post.setPrice(updatePostCommand.price());

            postRepository.save(post);
        }else {
            throw new IllegalArgumentException("PostId not found" + updatePostCommand.postId());
        }
    }
}
