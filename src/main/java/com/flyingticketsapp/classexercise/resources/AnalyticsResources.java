package com.flyingticketsapp.classexercise.resources;

import com.flyingticketsapp.classexercise.model.Analytics;
import com.flyingticketsapp.classexercise.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class AnalyticsResources {
    @Autowired
    AnalyticsService analyticsService;

    @GetMapping("/administration")
    public Map<String, Long> getAnalytics(){ return analyticsService.getAllInformation(); }

}
