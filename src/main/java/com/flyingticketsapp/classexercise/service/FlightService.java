package com.flyingticketsapp.classexercise.service;

import com.flyingticketsapp.classexercise.model.Flight;
import com.flyingticketsapp.classexercise.model.Traveller;
import com.flyingticketsapp.classexercise.repository.BookFlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    BookFlightsRepository bookFlightsRepository;

    protected static Long countUnfinishedNotPaidFlights = 0L;
    protected static Long countHomePageVisits = 0L;
    protected static Long countAllPagesVisitsFlight = 0L;
    protected static Long countOriginSelected = 0L;
    protected static Long countDestinationsSelected = 0L;

    public List<Flight> getFlights() {
        countAllPagesVisitsFlight++;
        countHomePageVisits++;
        return bookFlightsRepository.findAll();
    }

    public Flight getFlightById(Integer id) {
        countAllPagesVisitsFlight++;
        Optional<Flight> searchedFlight = bookFlightsRepository.findById(id);
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
        return bookFlightsRepository.findByOrigin(origin);
    }

    public Set<String> getUniqueFlightOrigins() {                 // Get a collection of unique origins for the flights
        countOriginSelected++;
        List<Flight> flightsBYOriginList = bookFlightsRepository.findAll();
        countUnfinishedNotPaidFlights++;
        return flightsBYOriginList.stream().map(Flight::getOrigin).collect(Collectors.toSet());
    }

    public Set<String> getDestinationStringsByUniqueOrigin(String origin) {      // Get a collection of unique destinations for the origin
        countAllPagesVisitsFlight++;
        countOriginSelected++;
        List<Flight> flightsBYOriginList = bookFlightsRepository.findByOrigin(origin);
        return flightsBYOriginList.stream().map(Flight::getDestination).collect(Collectors.toSet());
    }

    public List<Flight> getFlightsByDestination(String destination) {
         countAllPagesVisitsFlight++;
         countDestinationsSelected++;
        return bookFlightsRepository.findByDestination(destination);
    }

    public List<Flight> getFlightsByOriginAndDestination(String origin, String destination) {
        countAllPagesVisitsFlight++;
        countOriginSelected++;
        countDestinationsSelected++;
        return bookFlightsRepository.findByOriginAndDestination(origin, destination);
    }

    public List<Flight> getFlightsByDepartureDate(LocalDate departureDate) {
        countAllPagesVisitsFlight++;
        countOriginSelected++;
        countDestinationsSelected++;
        return bookFlightsRepository.findByDepartureDate(departureDate);
    }

    public List<Flight> getFlightsByDates(LocalDate dateFrom, LocalDate dateTo)  {
        countAllPagesVisitsFlight++;
        if(dateFrom.isBefore(LocalDate.now())){
            dateFrom = LocalDate.now();
            dateTo = dateTo.plusDays(6);
        }
        return bookFlightsRepository.getFlightsByDates(dateFrom, dateTo);
    }

    public void setTravellerForFlight(int flightId, Traveller traveller){
        countAllPagesVisitsFlight++;
        List<Traveller> listTravellers = bookFlightsRepository.getReferenceById(flightId).getTravellers();
        listTravellers.add(traveller);
    }

    public void addFlight(Flight flight) {
        countAllPagesVisitsFlight++;
        bookFlightsRepository.save(flight);
    }

    public Flight deleteFlightById(Integer id) {
        countAllPagesVisitsFlight++;
        return getFlightById(id);
    }


//departureTime;
//airline;
}
