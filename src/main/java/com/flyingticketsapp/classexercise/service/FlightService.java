package com.flyingticketsapp.classexercise.service;

import com.flyingticketsapp.classexercise.model.Flight;
import com.flyingticketsapp.classexercise.model.Plane;
import com.flyingticketsapp.classexercise.model.Traveller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class FlightService {

    private static List<Flight> flights;
    private static List<String> sevilleToBucharestScalesList;
    private static List<String> bucharestToSevilleScalesList;

    private static int flightsCount = 0;
    private static int planesCount = 0;
    private static int travellerCount = 0;

    static{
        Traveller traveller1 = new Traveller(++travellerCount,"Fernando","Andrei","Spain","N9423531K",32,true);
        Traveller traveller2 = new Traveller(++travellerCount,"Armand","Ioan","Italy","N9123531K",1,false);
        Traveller traveller3 = new Traveller(++travellerCount,"Ioana","Adriana","Russia","N9123531K",6,true);
        Plane plane1 = new Plane(++planesCount,"British Airlines",false,new ArrayList<>(List.of(traveller1)));
        Plane plane2 = new Plane(++planesCount,"Turkish Airlines",true,new ArrayList<>(List.of(traveller2,traveller3)));
        Plane plane3 = new Plane(++planesCount,"BlueAir",true,new ArrayList<>());
        Plane plane4 = new Plane(++planesCount,"British Airlines",true,new ArrayList<>());
        Plane plane5 = new Plane(++planesCount,"British Airlines",true,new ArrayList<>());
        Plane plane6 = new Plane(++planesCount,"WizzAir",true,new ArrayList<>());
        Plane plane7 = new Plane(++planesCount,"BlueAir",false,new ArrayList<>());
        Plane plane8 = new Plane(++planesCount,"WizzAir",true,new ArrayList<>());
        sevilleToBucharestScalesList = List.of("London","Madrid","Paris");
        bucharestToSevilleScalesList = List.of("London","Madrid","Paris");
        Flight flight1 = new Flight(++flightsCount,"Seville","Bucharest",sevilleToBucharestScalesList, LocalDateTime.of(2022,11,5,12,30), LocalTime.of(3,50),plane1,450.0);
        Flight flight2 = new Flight(++flightsCount,"Bucharest","Seville",bucharestToSevilleScalesList, LocalDateTime.of(2022,11,5,11,30), LocalTime.of(3,50),plane2,350.0);
        Flight flight3 = new Flight(++flightsCount,"London","Paris",null, LocalDateTime.of(2022,11,4,10,20), LocalTime.of(2,50),plane3,152.0);
        Flight flight4 = new Flight(++flightsCount,"Madrid","Bucharest",null, LocalDateTime.of(2022,11,6,16,30), LocalTime.of(3,10),plane4,154.0);
        Flight flight5 = new Flight(++flightsCount,"Paris","Seville",null, LocalDateTime.of(2022,11,6,14,25), LocalTime.of(2,44),plane5,250.0);
        Flight flight6 = new Flight(++flightsCount,"Barcelona","Birmingham",null,LocalDateTime.of(2022,11,7,11,55), LocalTime.of(2,20),plane6,120.0);
        Flight flight7 = new Flight(++flightsCount,"Seville","Bucharest",null, LocalDateTime.of(2022,11,5,12,32), LocalTime.of(3,50),plane7,450.0);
        Flight flight8 = new Flight(++flightsCount,"Bucharest","Seville",null, LocalDateTime.of(2022,11,1,12,35), LocalTime.of(3,50),plane8,350.0);
        flights = List.of(flight1,flight2,flight3,flight4,flight5,flight6,flight7,flight8);

    }

    public Set<String> queryFlightsByOrigin(String origin){     // List of flights that show only 1 destination for both round or one way trip
        Predicate<String> predicate = s -> s.equals(origin);
        return flights.stream().map(Flight::getDestination).filter(predicate).collect(Collectors.toSet());
    }

    public List<Flight> queryFlightsByOriginRoundTrip(String origin, String destination, boolean roundTrip, LocalDateTime chosenDate){     // If traveller chooses round trip
        Predicate<Flight> filterByDestinationAndScales;
        if(roundTrip){
            filterByDestinationAndScales = flight -> flight.getOrigin().equals(origin) && flight.getDestination().equals(destination) && flight.getScales() != null;
        }else{
            filterByDestinationAndScales = flight -> flight.getOrigin().equals(origin) && flight.getDestination().equals(destination) && flight.getScales() == null;
        }
        List<Flight> allFlightsWithChosenDestination = flights.stream().filter(filterByDestinationAndScales).toList();
        LocalDateTime less3Days = chosenDate.minusDays(4);
        LocalDateTime more3Days = chosenDate.plusDays(4);
        Predicate<Flight> filterBy3DaysMoreLess = flight -> flight.getDepartureDate().isAfter(less3Days) && flight.getDepartureDate().isBefore(more3Days) && flight.getDepartureDate().isAfter(LocalDateTime.now());
        return allFlightsWithChosenDestination.stream().filter(filterBy3DaysMoreLess).toList();
    }



}
