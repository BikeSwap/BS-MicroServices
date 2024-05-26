package pe.edu.bikeswap.inventoryservice.application.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.bikeswap.inventoryservice.domain.model.Post;
import pe.edu.bikeswap.inventoryservice.domain.service.PostService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // URL: http://localhost:8080/api/v1/posts
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity<List<Post>>(postService.getAllPosts(), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/posts/{postId}
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable(name = "postId") Long postId) {
        return new ResponseEntity<Post>(postService.getPostById(postId), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/posts
    // Method: POST
    @Transactional
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return new ResponseEntity<Post>(postService.createPost(post), HttpStatus.CREATED);
    }

    // URL: http://localhost:8080/api/v1/posts/{postId}
    // Method: PUT
    @Transactional
    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable(name = "postId") Long postId, @RequestBody Post post) {
        return new ResponseEntity<Post>(postService.updatePost(post), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/posts/{postId}
    // Method: DELETE
    @Transactional
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable(name = "postId") Long postId) {
        postService.deletePost(postId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // URL: http://localhost:8080/api/v1/posts/active
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/active")
    public ResponseEntity<List<Post>> getAllActivePosts() {
        return new ResponseEntity<List<Post>>(postService.getAllActivePosts(), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/posts/bikes/{bikeId}
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/bikes/{bikeId}")
    public ResponseEntity<List<Post>> getAllPostsByBikeId(@PathVariable(name = "bikeId") Long bikeId) {
        return new ResponseEntity<List<Post>>(postService.getAllPostsByBikeId(bikeId), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/posts/bikes/{bikeId}/active
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/bikes/{bikeId}/active")
    public ResponseEntity<List<Post>> getAllActivePostsByBikeId(@PathVariable(name = "bikeId") Long bikeId) {
        return new ResponseEntity<List<Post>>(postService.getAllActivePostsByBikeId(bikeId), HttpStatus.OK);
    }
}
