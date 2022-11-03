package com.flyingticketsapp.classexercise.resources;

import com.flyingticketsapp.classexercise.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AnalyticsResources {

    @Autowired
    AnalyticsService analyticsService;

    @GetMapping("/administrator")
    public Integer getPaidFlights(){
        return analyticsService.getAllPaidFlights();
    }
}
