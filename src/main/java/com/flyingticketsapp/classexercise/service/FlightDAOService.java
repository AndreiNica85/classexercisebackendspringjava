package com.flyingticketsapp.classexercise.service;

import com.flyingticketsapp.classexercise.model.Flight;
import com.flyingticketsapp.classexercise.model.Plane;
import com.flyingticketsapp.classexercise.model.Traveller;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class FlightDAOService {

    private static List<Flight> flights = new ArrayList<>();
    private static List<String> sevilleToBucharestScalesList = new ArrayList<>();
    private static List<String> bucharestToSevilleScalesList = new ArrayList<>();

    private static int flightsCount = 0;
    private static int planesCount = 0;
    private static int travellerCount = 0;

    static{
        Traveller traveller1 = new Traveller(++travellerCount,"Fernando","Andrei","Spain","N9423531K",32,true,true);
        Traveller traveller2 = new Traveller(++travellerCount,"Armand","Ioan","Italy","N9123531K",1,false,false);
        Traveller traveller3 = new Traveller(++travellerCount,"Ioana","Adriana","Russia","N9123531K",6,true,false);
        Plane plane1 = new Plane(++planesCount,"British Airlines",false,new ArrayList<>(List.of(traveller1)),120);
        Plane plane2 = new Plane(++planesCount,"Turkish Airlines",true,new ArrayList<>(List.of(traveller2,traveller3)),100);
        Plane plane3 = new Plane(++planesCount,"BlueAir",true,new ArrayList<>(),100);
        Plane plane4 = new Plane(++planesCount,"British Airlines",true,new ArrayList<>(),120);
        Plane plane5 = new Plane(++planesCount,"British Airlines",true,new ArrayList<>(),120);
        Plane plane6 = new Plane(++planesCount,"WizzAir",true,new ArrayList<>(),100);
        Plane plane7 = new Plane(++planesCount,"BlueAir",false,new ArrayList<>(),100);
        Plane plane8 = new Plane(++planesCount,"WizzAir",true,new ArrayList<>(),100);
        sevilleToBucharestScalesList = List.of("London","Madrid","Paris");
        bucharestToSevilleScalesList = List.of("London","Madrid","Paris");
        Flight flight1 = new Flight(++flightsCount,"Seville","Bucharest",sevilleToBucharestScalesList, LocalDate.of(2022,11,5), LocalTime.of(3,50),plane1,450.0);
        Flight flight2 = new Flight(++flightsCount,"Bucharest","Seville",bucharestToSevilleScalesList, LocalDate.now(), LocalTime.of(3,50),plane2,350.0);
        Flight flight3 = new Flight(++flightsCount,"London","Paris",null, LocalDate.of(2022,11,4), LocalTime.of(2,50),plane3,152.0);
        Flight flight4 = new Flight(++flightsCount,"Madrid","Bucharest",null, LocalDate.of(2022,11,6), LocalTime.of(3,10),plane4,154.0);
        Flight flight5 = new Flight(++flightsCount,"Paris","Seville",null, LocalDate.of(2022,11,6), LocalTime.of(2,44),plane5,250.0);
        Flight flight6 = new Flight(++flightsCount,"Barcelona","Birmingham",null, LocalDate.of(2022,11,7), LocalTime.of(2,20),plane6,120.0);
        Flight flight7 = new Flight(++flightsCount,"Seville","Bucharest",null, LocalDate.of(2022,11,5), LocalTime.of(3,50),plane7,450.0);
        Flight flight8 = new Flight(++flightsCount,"Bucharest","Seville",null, LocalDate.now(), LocalTime.of(3,50),plane8,350.0);

    }

    
}
