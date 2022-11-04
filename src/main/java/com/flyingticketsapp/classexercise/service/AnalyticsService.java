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
        map.put("countUnfinishedNotPaidFlights", Analytics.countUnfinishedNotPaidFlights);
        map.put("countHomePageVisits", Analytics.countHomePageVisits);
        map.put("countOriginSelected", Analytics.countOriginSelected);
        map.put("countDestinationsSelected", Analytics.countDestinationsSelected);
        map.put("countPaidFlights", Analytics.countPaidFlights);
        map.put("countAllPagesVisitsTraveller", Analytics.countAllPagesVisitsTraveller + Analytics.countAllPagesVisitsFlight);
        return map;
    }
}
