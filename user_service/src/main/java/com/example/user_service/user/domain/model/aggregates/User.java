package com.example.user_service.user.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Getter
    private String name;

    @NotNull
    @Getter
    private String lastName;

    @NotNull
    @Getter
    private String firstName;

    @NotNull
    @Getter
    private String email;

    @NotNull
    @Getter
    private String password;

    public User(String name, String lastName, String firstName, String email, String password) {
        this.name=name;
        this.lastName=lastName;
        this.firstName=firstName;
        this.email=email;
        this.password=password;
    }
}
