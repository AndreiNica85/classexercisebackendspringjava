package com.flyingticketsapp.classexercise.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.convert.DurationFormat;
import org.springframework.boot.convert.DurationStyle;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 1, message = "Must contain at least 1 letter")
    @NotBlank
    private String origin;

    @NotNull
    @NotBlank
    private String destination;


    private LocalDate departureDate;
    private LocalTime departureTime;

    @NotNull
    @NotBlank
    private String airline;
    private boolean isRoundTrip;

    @Positive
    private double price;

    @OneToMany
    private List<Traveller> travellers;

}
