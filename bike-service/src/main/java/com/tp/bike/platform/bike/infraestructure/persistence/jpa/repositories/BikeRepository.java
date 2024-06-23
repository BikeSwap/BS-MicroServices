package com.tp.bike.platform.bike.infraestructure.persistence.jpa.repositories;

import com.tp.bike.platform.bike.bycicle.domain.model.aggregates.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BikeRepository extends JpaRepository<Bike,Long> {
    Optional<Bike> findById(Long id);
}
