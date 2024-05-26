package pe.edu.bikeswap.inventoryservice.application.service;

import org.springframework.stereotype.Service;
import pe.edu.bikeswap.inventoryservice.application.mapper.PostMapper;
import pe.edu.bikeswap.inventoryservice.domain.model.Post;
import pe.edu.bikeswap.inventoryservice.domain.repository.PostRepository;
import pe.edu.bikeswap.inventoryservice.domain.service.PostService;
import pe.edu.bikeswap.inventoryservice.entity.PostEntity;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Post post) {
        PostEntity postEntity = PostMapper.INSTANCE.postModelToEntity(post);
        return PostMapper.INSTANCE.postEntityToModel(postRepository.save(postEntity));
    }

    @Override
    public Post getPostById(Long post_id) {
        PostEntity postEntity = postRepository.findById(post_id).orElse(null);
        return PostMapper.INSTANCE.postEntityToModel(postEntity);
    }

    @Override
    public Post updatePost(Post post) {
        PostEntity postEntity = PostMapper.INSTANCE.postModelToEntity(post);
        return PostMapper.INSTANCE.postEntityToModel(postRepository.save(postEntity));
    }

    @Override
    public void deletePost(Long post_id) {
        postRepository.deleteById(post_id);
    }

    @Override
    public List<Post> getAllPosts() {
        List<PostEntity> postEntities = postRepository.findAll();
        return PostMapper.INSTANCE.postEntityListToModelList(postEntities);
    }

    @Override
    public List<Post> getAllActivePosts() {
        List<PostEntity> postEntities = postRepository.isActive(true);
        return PostMapper.INSTANCE.postEntityListToModelList(postEntities);
    }

    @Override
    public List<Post> getAllPostsByBikeId(Long bike_id) {
        List<PostEntity> postEntities = postRepository.findByBikeId(bike_id);
        return PostMapper.INSTANCE.postEntityListToModelList(postEntities);
    }

    @Override
    public List<Post> getAllActivePostsByBikeId(Long bike_id) {
        List<PostEntity> postEntities = postRepository.findByBikeIdAndActive(bike_id, true);
        return PostMapper.INSTANCE.postEntityListToModelList(postEntities);
    }
}
