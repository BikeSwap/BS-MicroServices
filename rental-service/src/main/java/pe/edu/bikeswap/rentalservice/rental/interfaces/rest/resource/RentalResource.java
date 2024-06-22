package pe.edu.bikeswap.rentalservice.rental.interfaces.rest.resource;

import java.time.LocalDate;

public record RentalResource(Long rentalId, LocalDate rentStartDate, LocalDate rentEndDate, double rentPrice) {
}
