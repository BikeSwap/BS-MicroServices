package pe.edu.bikeswap.rentalservice.rental.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "rents")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="rent_start_date", nullable = false)
    private LocalDate rentStartDate;

    @Column(name="rent_end_date", nullable = false)
    private LocalDate rentEndDate;

    @Column(name="rent_price", nullable = false)
    private double rentPrice;

    public Rental(LocalDate rentStartDate, LocalDate rentEndDate, double rentPrice) {
        this.rentStartDate = rentStartDate;
        this.rentEndDate = rentEndDate;
        this.rentPrice = rentPrice;
    }





    /*
      @ManyToOne
    @JoinColumn(name = "bike_id", nullable = false)
    private Bike bike;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    */

}
