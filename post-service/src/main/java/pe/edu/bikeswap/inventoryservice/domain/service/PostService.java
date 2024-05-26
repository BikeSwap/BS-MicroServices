package pe.edu.bikeswap.inventoryservice.domain.service;

import pe.edu.bikeswap.inventoryservice.domain.model.Post;

import java.util.List;

public interface PostService {
    public abstract Post createPost(Post post);
    public abstract Post getPostById(Long post_id);
    public abstract Post updatePost(Post post);
    public abstract void deletePost(Long post_id);
    public abstract List<Post> getAllPosts();
    public abstract List<Post> getAllActivePosts();
    public abstract List<Post> getAllPostsByBikeId(Long bike_id);
    public abstract List<Post> getAllActivePostsByBikeId(Long bike_id);
}
