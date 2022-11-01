package com.flyingticketsapp.classexercise.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Traveller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String forename;
    private String surname;
    private int age;
    private String nationality;
    private String email;
    private String pseudoPassword;
    @OneToMany
    private List<Flight> bookedFlights;
}
