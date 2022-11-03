package com.flyingticketsapp.classexercise.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
    private String origin;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private String airline;
    private boolean isRoundTrip;
    private double price;
    @OneToMany
    private List<Traveller> travellers;

}
