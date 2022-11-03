package com.flyingticketsapp.classexercise.service;

import com.flyingticketsapp.classexercise.model.Flight;
import com.flyingticketsapp.classexercise.model.Traveller;
import com.flyingticketsapp.classexercise.repository.TravellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
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

    public Traveller addTraveller(Traveller traveller){
        return travellerRepository.save(traveller);
    }

    public Traveller getTravellerById(Integer id) {
        Optional<Traveller> searchedFlight = travellerRepository.findById(id);
        if (searchedFlight.isPresent()) {
            return searchedFlight.get();
        } else {
            throw new NoSuchElementException("Traveller " + id + " not found");
        }
    }
}
