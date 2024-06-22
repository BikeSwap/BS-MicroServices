package pe.edu.bikeswap.rentalservice.rental.interfaces.rest.resource;

import java.time.LocalDate;

public record UpdateRentalResource(LocalDate rentStartDate, LocalDate rentEndDate, double rentPrice) {
}
