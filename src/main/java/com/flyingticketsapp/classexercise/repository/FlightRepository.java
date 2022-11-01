package com.flyingticketsapp.classexercise.repository;

import com.flyingticketsapp.classexercise.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
