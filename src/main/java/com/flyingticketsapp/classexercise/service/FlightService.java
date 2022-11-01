package com.flyingticketsapp.classexercise.service;

import com.flyingticketsapp.classexercise.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;
}
