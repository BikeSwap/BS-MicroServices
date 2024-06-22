package pe.edu.bikeswap.rentalservice.rental.domain.model.commands;

import java.time.LocalDate;

public record CreateRentalCommand (LocalDate rentStartDate,
                                   LocalDate rentEndDate,
                                   double rentPrice){
}
