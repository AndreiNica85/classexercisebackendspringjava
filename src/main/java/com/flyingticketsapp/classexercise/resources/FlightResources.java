package com.flyingticketsapp.classexercise.resources;

import com.flyingticketsapp.classexercise.model.Flight;
import com.flyingticketsapp.classexercise.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class FlightResources {
    @Autowired
    FlightService flightService;


    @GetMapping("/flights")
    public List<Flight> getFlights() {
        return flightService.getFlights();
    }

    @GetMapping("/flights/{id}")
    public Flight getFlight(@PathVariable Integer id) {
        return flightService.getFlightById(id);
    }

    @GetMapping("/flights/cities/from/{origin}")
    public List<Flight> getFlightsByOrigin(@PathVariable String origin) {
        return flightService.getFlightsByOrigin(origin);
    }

    @GetMapping("/flights/cities/to/{destination}")
    public List<Flight> getFlightsByDestination(@PathVariable String destination) {
        return flightService.getFlightsByDestination(destination);
    }

    @GetMapping("/flights/cities/{origin}/{destination}")
    public List<Flight> getFlightsByConnection(@PathVariable String origin, @PathVariable String destination) {
        return flightService.getFlightsByOriginAndDestination(origin, destination);
    }

    @GetMapping("/flights/dates/{departureDate}")
    public List<Flight> getFlightByDates(@PathVariable("departureDate") String departureDate) {

        LocalDate from = LocalDate.parse(departureDate);
        return flightService.getFlightsByDepartureDate(from);
    }

    @GetMapping("/flights/dates/{dateFrom}/{dateTo}")
    public List<Flight> getFlightByDates(@PathVariable("dateFrom") String dateFrom, @PathVariable("dateTo") String dateTo) {

        LocalDate from = LocalDate.parse(dateFrom);
        LocalDate to = LocalDate.parse(dateTo);

        return flightService.getFlightsByDates(from, to);
    }

    @PostMapping("/flights")
    public void addFlight(@RequestBody Flight flight) {
        flightService.addFlight(flight);
    }

    @DeleteMapping("/flights/{id}")
    public void deleteFlight(@PathVariable Integer id) {
        flightService.deleteFlightById(id);
    }
}
