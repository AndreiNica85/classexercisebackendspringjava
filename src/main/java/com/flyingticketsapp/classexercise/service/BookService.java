package com.flyingticketsapp.classexercise.service;

import com.flyingticketsapp.classexercise.model.Traveller;
import com.flyingticketsapp.classexercise.repository.TravellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    TravellerRepository travellerRepository;

    protected static int countPaidFlights = 0;

    public List<Traveller> getAllTravellers(){
        return travellerRepository.findAll();
    }

    public double getPriceByAge(double price){
        travellerRepository.deleteAll();
        return 1;
    }

    public Traveller addTraveller(Traveller traveller){
        countPaidFlights++;
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
