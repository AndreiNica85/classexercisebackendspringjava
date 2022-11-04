package com.flyingticketsapp.classexercise.service;

import com.flyingticketsapp.classexercise.model.Flight;
import com.flyingticketsapp.classexercise.model.Analytics;
import com.flyingticketsapp.classexercise.model.Traveller;
import com.flyingticketsapp.classexercise.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    FlightsRepository flightsRepository;

    @Autowired
    Analytics analytics;



    public List<Flight> getFlights() {
        analytics.countAllPagesVisitsFlight++;
        analytics.countHomePageVisits++;
        return flightsRepository.findAll();
    }

    public Flight getFlightById(Integer id) {
        analytics.countAllPagesVisitsFlight++;
        Optional<Flight> searchedFlight = flightsRepository.findById(id);
        if (searchedFlight.isPresent()) {
            return searchedFlight.get();
        } else {
            throw new NoSuchElementException("Flight " + id + " not found");
        }
    }

    public List<Flight> getFlightsByOrigin(String origin) {
        analytics.countOriginSelected++;
        analytics.countAllPagesVisitsFlight++;
        System.out.println("Triggered and origin:" + origin + "passed.");
        return flightsRepository.findByOrigin(origin);
    }

    public Set<String> getUniqueFlightOrigins() {                 // Get a collection of unique origins for the flights
        analytics.countOriginSelected++;
        List<Flight> flightsBYOriginList = flightsRepository.findAll();
        analytics.countUnfinishedNotPaidFlights++;
        return flightsBYOriginList.stream().map(Flight::getOrigin).collect(Collectors.toSet());
    }

    public Set<String> getDestinationStringsByUniqueOrigin(String origin) {      // Get a collection of unique destinations for the origin
        analytics.countAllPagesVisitsFlight++;
        analytics.countOriginSelected++;
        List<Flight> flightsBYOriginList = flightsRepository.findByOrigin(origin);
        return flightsBYOriginList.stream().map(Flight::getDestination).collect(Collectors.toSet());
    }

    public List<Flight> getFlightsByDestination(String destination) {
        analytics.countAllPagesVisitsFlight++;
        analytics.countDestinationsSelected++;
        return flightsRepository.findByDestination(destination);
    }

    public List<Flight> getFlightsByOriginAndDestination(String origin, String destination) {
        analytics.countAllPagesVisitsFlight++;
        analytics.countOriginSelected++;
        analytics.countDestinationsSelected++;
        return flightsRepository.findByOriginAndDestination(origin, destination);
    }

    public List<Flight> getFlightsByDepartureDate(LocalDate departureDate) {
        analytics.countAllPagesVisitsFlight++;
        analytics.countOriginSelected++;
        analytics.countDestinationsSelected++;
        return flightsRepository.findByDepartureDate(departureDate);
    }

    public List<Flight> getFlightsByDates(LocalDate dateFrom, LocalDate dateTo)  {
        analytics.countAllPagesVisitsFlight++;
        if(dateFrom.isBefore(LocalDate.now())){
            dateFrom = LocalDate.now();
            dateTo = dateTo.plusDays(6);
        }
        return flightsRepository.getFlightsByDates(dateFrom, dateTo);
    }

    public void setTravellerForFlight(int id, Traveller traveller){
        analytics.countAllPagesVisitsFlight++;
        List<Traveller> listTravellers = flightsRepository.getReferenceById(id).getTravellers();
        listTravellers.add(traveller);
    }

    public void addFlight(Flight flight) {
        analytics.countAllPagesVisitsFlight++;
        flightsRepository.save(flight);
    }

    public Flight deleteFlightById(Integer id) {
        analytics.countAllPagesVisitsFlight++;
        return getFlightById(id);
    }
}
