package com.flyingticketsapp.classexercise.service;

import com.flyingticketsapp.classexercise.model.Flight;
import com.flyingticketsapp.classexercise.model.Traveller;
import com.flyingticketsapp.classexercise.repository.TravellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class TravellerService {

    @Autowired
    TravellerRepository travellerRepository;

    public List<Traveller> getAllTravellers(){
        return travellerRepository.findAll();
    }

    public double getPriceByAge(double price){
        travellerRepository.deleteAll();
        return 1;
    }
}
