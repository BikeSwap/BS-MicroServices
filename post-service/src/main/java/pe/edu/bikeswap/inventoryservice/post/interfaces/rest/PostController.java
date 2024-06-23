package pe.edu.bikeswap.inventoryservice.post.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.bikeswap.inventoryservice.infraestructure.persistence.jpa.repositories.PostRepository;
import pe.edu.bikeswap.inventoryservice.post.domain.model.aggregates.Post;
import pe.edu.bikeswap.inventoryservice.post.domain.model.querys.GetPostById;
import pe.edu.bikeswap.inventoryservice.post.domain.services.PostCommandService;
import pe.edu.bikeswap.inventoryservice.post.domain.services.PostQueryService;
import pe.edu.bikeswap.inventoryservice.post.interfaces.rest.resource.CreatePostResource;
import pe.edu.bikeswap.inventoryservice.post.interfaces.rest.resource.PostResource;
import pe.edu.bikeswap.inventoryservice.post.interfaces.rest.resource.UpdatePostResource;
import pe.edu.bikeswap.inventoryservice.post.interfaces.rest.transform.CreatePostCommandFromResourceAsembler;
import pe.edu.bikeswap.inventoryservice.post.interfaces.rest.transform.PostResourceFromEntityAssembler;
import pe.edu.bikeswap.inventoryservice.post.interfaces.rest.transform.UpdatePostCommandFromResourceAssembler;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/rentals", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Tag(name = "Posts", description = "Posts")
public class PostController {
    private final PostRepository postRepository;
    private final PostCommandService postCommandService;
    private final PostQueryService postQueryService;

    public PostController(PostRepository postRepository, PostCommandService postCommandService, PostQueryService postQueryService) {
        this.postRepository = postRepository;
        this.postCommandService = postCommandService;
        this.postQueryService = postQueryService;
    }
    @PostMapping
    public ResponseEntity<PostResource> createRental(@RequestBody CreatePostResource createRentalResource){
        var createPostCommand = CreatePostCommandFromResourceAsembler.toCommandFromResource(createRentalResource);
        var postId = postCommandService.handle(createPostCommand);
        if (postId == 0L) return ResponseEntity.badRequest().build();
        var getpostByIdQuery = new GetPostById(postId);
        var post = postQueryService.handle(getpostByIdQuery);
        if (post.isEmpty()) return ResponseEntity.notFound().build();
        var postResource = PostResourceFromEntityAssembler.toResourceFromEntity(post.get());
        return new ResponseEntity<>(postResource, HttpStatus.CREATED);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<PostResource> getRentalById(@PathVariable Long postId){
        var getPostByIdQuery = new GetPostById(postId);
        var post = postQueryService.handle(getPostByIdQuery);

        if(post.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var postResource = PostResourceFromEntityAssembler.toResourceFromEntity(post.get());
        return ResponseEntity.ok(postResource);
    }
    @GetMapping
    public List<Post> getAll() {
        return postQueryService.getAllPosts();
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostResource> updateRental(@PathVariable Long postId, @RequestBody UpdatePostResource updatePostResource){
        var updateRentalCommand = UpdatePostCommandFromResourceAssembler.toCommandFromResource(postId, updatePostResource);
        postCommandService.update(updateRentalCommand);

        var getPostByIdQuery = new GetPostById(postId);
        var updatePost = postQueryService.handle(getPostByIdQuery);

        if(updatePost.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var postResource = PostResourceFromEntityAssembler.toResourceFromEntity(updatePost.get());
        return ResponseEntity.ok(postResource);
    }
    @DeleteMapping("/{postId}")
    public ResponseEntity<PostResource> deletePost(@PathVariable Long postId){
        var post = postRepository.findById(postId);
        if(post.isPresent()){
            postRepository.deleteById(postId);
            postRepository.flush();
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
