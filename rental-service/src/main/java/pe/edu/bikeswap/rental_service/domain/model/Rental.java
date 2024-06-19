package pe.edu.bikeswap.rental_service.domain.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rental {
    private Long id;

    private Long bicycleId;

    private Long cardId;

    private LocalDate rentStartDate;

    private LocalDate rentEndDate;

    private Double rentPrice;
}
