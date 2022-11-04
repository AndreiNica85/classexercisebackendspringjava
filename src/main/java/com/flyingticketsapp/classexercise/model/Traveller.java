package com.flyingticketsapp.classexercise.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Traveller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn
    private Integer id;

    @NotNull
    @NotBlank
    private String forename;

    @NotNull
    @NotBlank
    private String surname;

    @NotNull
    private Integer age;

    private String userNameAdministrationPage;

    private String passwordAdministrationPage;

    @NotBlank
    private String nationality;

    @NotBlank
    private String email;

    @Size(min = 9,max = 9, message = "NIE has to be 9 characters long")
    private String NIE;
    @OneToMany
    private List<Flight> bookedFlights;
}
