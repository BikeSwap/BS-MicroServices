package pe.edu.bikeswap.rental_service.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.bikeswap.rental_service.domain.model.rental;
import pe.edu.bikeswap.rental_service.entity.RentalEntity;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<RentalEntity, Long> {

    List<rental> findByBicycleId(Long bicycle_id);
}
