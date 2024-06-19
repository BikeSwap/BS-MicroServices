package pe.edu.bikeswap.rental_service.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.edu.bikeswap.rental_service.domain.model.Rental;
import pe.edu.bikeswap.rental_service.entity.RentalEntity;

import java.util.List;
@Mapper
public interface RentalMapper {
    RentalMapper INSTANCE = Mappers.getMapper(RentalMapper.class);
    RentalEntity rentalModelToEntity(Rental rental);
    Rental rentalEntityToModel(RentalEntity rentalEntity);
    List<Rental> rentalEntityListToModelList(List<RentalEntity> rentalEntities);
}
