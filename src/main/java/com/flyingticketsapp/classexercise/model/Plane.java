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
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String airline;
    private boolean luggage;
    private List<Traveller> sits;
    private Flight flight;
}







