package com.flyingticketsapp.classexercise.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AnalyticsService {

    @Autowired
    @Qualifier("bookFlightsService")
    BookFlightsService bookFlightsService;

    @Autowired
    @Qualifier("flightService")
    FlightService flightService;

    public Map<String,Long> getAllInformation(){
        Map<String,Long> map = new HashMap<>();
        map.put("countUnfinishedNotPaidFlights", FlightService.countUnfinishedNotPaidFlights);
        map.put("countHomePageVisits", FlightService.countHomePageVisits);
        map.put("countOriginSelected", FlightService.countOriginSelected);
        map.put("countDestinationsSelected", FlightService.countDestinationsSelected);
        map.put("countPaidFlights", BookFlightsService.countPaidFlights);
        map.put("countAllPagesVisitsTraveller",BookFlightsService.countAllPagesVisitsTraveller + FlightService.countAllPagesVisitsFlight);
        return map;
    }



}
