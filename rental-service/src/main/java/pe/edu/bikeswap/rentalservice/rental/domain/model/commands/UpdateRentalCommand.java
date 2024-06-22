package pe.edu.bikeswap.rentalservice.rental.domain.model.commands;

import java.time.LocalDate;

public record UpdateRentalCommand(Long rentalId, LocalDate rentStartDate, LocalDate rentEndDate, double rentPrice) {
}
