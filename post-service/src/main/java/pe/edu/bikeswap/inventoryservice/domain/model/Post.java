package pe.edu.bikeswap.inventoryservice.domain.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Long id;

    private String description;

    private Double pricePerHour;

    private Boolean isActive;

    private Long bikeId;
}
