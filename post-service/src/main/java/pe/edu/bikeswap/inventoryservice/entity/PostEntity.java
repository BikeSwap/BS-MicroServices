package pe.edu.bikeswap.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="bike_posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="price_per_hour", nullable = false)
    private Double pricePerHour;

    @Column(name="is_active", nullable = false)
    private Boolean isActive;

    @Column(name="bikes_id", nullable = false)
    private Long bikeId;
}
