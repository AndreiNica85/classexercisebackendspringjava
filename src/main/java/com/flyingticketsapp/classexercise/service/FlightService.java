package com.flyingticketsapp.classexercise.service;

import com.flyingticketsapp.classexercise.model.Flight;
import com.flyingticketsapp.classexercise.model.Traveller;
import com.flyingticketsapp.classexercise.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    @Qualifier("flightsRepository")
    FlightsRepository flightsRepository;

    protected static Long countUnfinishedNotPaidFlights = 0L;
    protected static Long countHomePageVisits = 0L;
    protected static Long countAllPagesVisitsFlight = 0L;
    protected static Long countOriginSelected = 0L;
    protected static Long countDestinationsSelected = 0L;

    public List<Flight> getFlights() {
        countAllPagesVisitsFlight++;
        countHomePageVisits++;
        return flightsRepository.findAll();
    }

    public Flight getFlightById(Integer id) {
        countAllPagesVisitsFlight++;
        Optional<Flight> searchedFlight = flightsRepository.findById(id);
        if (searchedFlight.isPresent()) {
            return searchedFlight.get();
        } else {
            throw new NoSuchElementException("Flight " + id + " not found");
        }
    }

    public List<Flight> getFlightsByOrigin(String origin) {
        countOriginSelected++;
        countAllPagesVisitsFlight++;
        System.out.println("Triggered and origin:" + origin + "passed.");
        return flightsRepository.findByOrigin(origin);
    }

    public Set<String> getUniqueFlightOrigins() {                 // Get a collection of unique origins for the flights
        countOriginSelected++;
        List<Flight> flightsBYOriginList = flightsRepository.findAll();
        countUnfinishedNotPaidFlights++;
        return flightsBYOriginList.stream().map(Flight::getOrigin).collect(Collectors.toSet());
    }

    public Set<String> getDestinationStringsByUniqueOrigin(String origin) {      // Get a collection of unique destinations for the origin
        countAllPagesVisitsFlight++;
        countOriginSelected++;
        List<Flight> flightsBYOriginList = flightsRepository.findByOrigin(origin);
        return flightsBYOriginList.stream().map(Flight::getDestination).collect(Collectors.toSet());
    }

    public List<Flight> getFlightsByDestination(String destination) {
         countAllPagesVisitsFlight++;
         countDestinationsSelected++;
        return flightsRepository.findByDestination(destination);
    }

    public List<Flight> getFlightsByOriginAndDestination(String origin, String destination) {
        countAllPagesVisitsFlight++;
        countOriginSelected++;
        countDestinationsSelected++;
        return flightsRepository.findByOriginAndDestination(origin, destination);
    }

    public List<Flight> getFlightsByDepartureDate(LocalDate departureDate) {
        countAllPagesVisitsFlight++;
        countOriginSelected++;
        countDestinationsSelected++;
        return flightsRepository.findByDepartureDate(departureDate);
    }

    public List<Flight> getFlightsByDates(LocalDate dateFrom, LocalDate dateTo)  {
        countAllPagesVisitsFlight++;
        if(dateFrom.isBefore(LocalDate.now())){
            dateFrom = LocalDate.now();
            dateTo = dateTo.plusDays(6);
        }
        return flightsRepository.getFlightsByDates(dateFrom, dateTo);
    }

    public void setTravellerForFlight(int id, Traveller traveller){
        countAllPagesVisitsFlight++;
        List<Traveller> listTravellers = flightsRepository.getReferenceById(id).getTravellers();
        listTravellers.add(traveller);
    }

    public void addFlight(Flight flight) {
        countAllPagesVisitsFlight++;
        flightsRepository.save(flight);
    }

    public Flight deleteFlightById(Integer id) {
        countAllPagesVisitsFlight++;
        return getFlightById(id);
    }


//departureTime;
//airline;
}
