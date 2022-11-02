package com.flyingticketsapp.classexercise.resource;

import com.flyingticketsapp.classexercise.model.Flight;
import com.flyingticketsapp.classexercise.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Set;

@RestController
public class FlightResource {

    @Autowired
    private FlightService flightService;

    public FlightResource(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/Seville")
    public Set<String> getAllFlights(){
        return this.flightService.queryFlightsByOrigin("Seville");
    }
}
