package com.flyingticketsapp.classexercise.service;
import com.flyingticketsapp.classexercise.model.Analytics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AnalyticsService {

    @Autowired
    Analytics analytics;


    public Map<String,Long> getAllInformation(){
        Map<String,Long> map = new HashMap<>();
        map.put("countUnfinishedNotPaidFlights", analytics.countUnfinishedNotPaidFlights);
        map.put("countHomePageVisits", analytics.countHomePageVisits);
        map.put("countOriginSelected", analytics.countOriginSelected);
        map.put("countDestinationsSelected", analytics.countDestinationsSelected);
        map.put("countPaidFlights", analytics.countPaidFlights);
        map.put("countAllPagesVisitsTraveller", analytics.countAllPagesVisitsTraveller + analytics.countAllPagesVisitsFlight);
        return map;
    }
}
