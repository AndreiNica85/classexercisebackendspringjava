package com.flyingticketsapp.classexercise.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class Analytics {

    public static Long countUnfinishedNotPaidFlights = 0L;
    public static Long countHomePageVisits = 0L;
    public static Long countAllPagesVisitsFlight = 0L;
    public static Long countOriginSelected = 0L;
    public static Long countDestinationsSelected = 0L;
    public static Long countPaidFlights = 0L;
    public static Long countAllPagesVisitsTraveller = 0L;
}
