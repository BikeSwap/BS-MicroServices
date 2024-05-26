package pe.edu.bikeswap.inventoryservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.bikeswap.inventoryservice.entity.PostEntity;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> isActive(boolean isActive);

    List<PostEntity> findByBikeId(Long bikeId);

    default List<PostEntity> findByBikeIdAndActive(Long bikeId, Boolean isActive) {
        return null;
    }
}
