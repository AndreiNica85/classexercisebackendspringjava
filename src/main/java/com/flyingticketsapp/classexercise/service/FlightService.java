package com.flyingticketsapp.classexercise.service;

import com.flyingticketsapp.classexercise.model.Flight;
import com.flyingticketsapp.classexercise.model.Traveller;
import com.flyingticketsapp.classexercise.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Integer id) {

        Optional<Flight> searchedFlight = flightRepository.findById(id);

        if (searchedFlight.isPresent()) {
            return searchedFlight.get();
        } else {
            throw new NoSuchElementException("Flight " + id + " not found");
        }
    }

    public List<Flight> getFlightsByOrigin(String origin) {
        System.out.println("Triggered and origin:" + origin + "passed.");
        return flightRepository.findByOrigin(origin);
    }


    public Set<String> getUniqueFlightOrigins() {                 // Get a collection of unique origins for the flights
        List<Flight> flightsBYOriginList = flightRepository.findAll();
        return flightsBYOriginList.stream().map(Flight::getOrigin).collect(Collectors.toSet());
    }

    public Set<String> getDestinationStringsByUniqueOrigin(String origin) {      // Get a collection of unique destinations for the origin
        List<Flight> flightsBYOriginList = flightRepository.findByOrigin(origin);
        return flightsBYOriginList.stream().map(Flight::getDestination).collect(Collectors.toSet());
    }

    public List<Flight> getFlightsByDestination(String destination) {
        return flightRepository.findByDestination(destination);
    }

    public List<Flight> getFlightsByOriginAndDestination(String origin, String destination) {
        return flightRepository.findByOriginAndDestination(origin, destination);
    }

    public List<Flight> getFlightsByDepartureDate(LocalDate departureDate) {
        return flightRepository.findByDepartureDate(departureDate);
    }

    public List<Flight> getFlightsByDates(LocalDate dateFrom, LocalDate dateTo)  {
        if(dateFrom.isBefore(LocalDate.now())){
            dateFrom = LocalDate.now();
            dateTo = dateTo.plusDays(6);
        }
        return flightRepository.getFlightsByDates(dateFrom, dateTo);
    }

    public void setTravellerForFlight(int flightId, Traveller traveller){
        flightRepository.getReferenceById(flightId).setTraveller(traveller);
    }

    public void addFlight(Flight flight) {
        flightRepository.save(flight);
    }



    public Flight deleteFlightById(Integer id) {
        return getFlightById(id);
    }


//departureTime;
//airline;
}
