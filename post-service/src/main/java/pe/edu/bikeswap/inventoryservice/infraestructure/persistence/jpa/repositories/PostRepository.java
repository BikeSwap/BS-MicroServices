package pe.edu.bikeswap.inventoryservice.infraestructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.bikeswap.inventoryservice.post.domain.model.aggregates.Post;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    Optional<Post> findById(Long postId);
    void deleteById(Long postId);
}
