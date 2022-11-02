package com.flyingticketsapp.classexercise.repository;

import com.flyingticketsapp.classexercise.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findByOrigin( String origin);

    List<Flight> findByDestination(String destination);

    List<Flight> findByOriginAndDestination(String origin, String destination);

    List<Flight> findByDepartureDate(LocalDate departureDate);

    @Query("SELECT f FROM Flight f WHERE f.departureDate BETWEEN :#{#dateFrom} AND :#{#dateTo}")
    List<Flight> getFlightsByDates(LocalDate dateFrom, LocalDate dateTo);


}
