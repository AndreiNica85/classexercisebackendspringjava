package com.flyingticketsapp.classexercise.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    @Autowired
    @Qualifier("bookService")
    BookService bookService;

    @Autowired
    @Qualifier("flightService")
    FlightService flightService;

    public Integer getAllPaidFlights(){
        return BookService.countPaidFlights;
    }

}
