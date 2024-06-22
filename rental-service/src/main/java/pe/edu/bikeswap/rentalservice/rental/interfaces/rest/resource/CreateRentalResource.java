package pe.edu.bikeswap.rentalservice.rental.interfaces.rest.resource;

import java.time.LocalDate;

public record CreateRentalResource(LocalDate rentStartDate, LocalDate rentEndDate, double rentPrice) {
}
