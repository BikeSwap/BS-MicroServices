package pe.edu.bikeswap.inventoryservice.post.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Setter
@AllArgsConstructor
@With
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
/*
    @OneToOne
    @JoinColumn(name="property_id", nullable = false)
    private Bike bikeId;*/

    @NotNull
    private String title;

    private String description;

    @NotNull
    private Double price;


    public Post(String title, String description, Double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }
}
