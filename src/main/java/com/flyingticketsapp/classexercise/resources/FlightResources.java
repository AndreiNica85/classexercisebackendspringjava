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

    //You must present a list of origins
    @GetMapping("/flights/cities/from/{origin}")
    public List<Flight> getFlightsByOrigin(@PathVariable String origin) {
        return flightService.getFlightsByOrigin(origin);
    }

    @GetMapping("/flights/cities/to/{destination}")
    public List<Flight> getFlightsByDestination(@PathVariable String destination) {
        return flightService.getFlightsByDestination(destination);
    }

    //API must be queried to obtain the possible destinations
    @GetMapping("/flights/cities/{origin}/{destination}")
    public List<Flight> getFlightsByConnection(@PathVariable String origin, @PathVariable String destination) {
        return flightService.getFlightsByOriginAndDestination(origin, destination);
    }

    //The search must return different possibilities throughout the same day for the selected date, the
    //3 days before and the 3 days after the selected date. If any of the days prior to the searched
    //date is less than the current day, you must add a day to the following days.
    @GetMapping("/flights/dates/{departureDate}")
    public List<Flight> getFlightByDates(@PathVariable("departureDate") String departureDate) {

        LocalDate from = LocalDate.parse(departureDate).minusDays(3);
        LocalDate to = LocalDate.parse(departureDate).plusDays(3);

        return flightService.getFlightsByDates(from, to);
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
