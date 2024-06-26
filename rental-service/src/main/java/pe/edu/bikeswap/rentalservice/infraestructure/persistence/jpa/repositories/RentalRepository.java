package pe.edu.bikeswap.rentalservice.infraestructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.bikeswap.rentalservice.rental.domain.model.aggregates.Rental;

import java.util.Optional;

@Repository
public interface RentalRepository extends JpaRepository <Rental,Long>{
    Optional<Rental> findById(Long rentalId);
    void deleteById(Long rentalId);
}
