package com.tp.bike.platform.bike.bycicle.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Getter
    private String name;

    @NotNull
    @Getter
    private String description;

    @NotNull
    @Getter
    private double price;

    @NotNull
    @Getter
    private String model;

    @NotNull
    @Getter
    private String image;

    public Bike(String name, String description, Double price, String model, String image) {
        this.name=name;
        this.description=description;
        this.price=price;
        this.model=model;
        this.image=image;
    }
}
