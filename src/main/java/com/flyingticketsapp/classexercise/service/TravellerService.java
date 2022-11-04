package com.flyingticketsapp.classexercise.service;

import com.flyingticketsapp.classexercise.model.Analytics;
import com.flyingticketsapp.classexercise.model.Traveller;
import com.flyingticketsapp.classexercise.repository.TravellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TravellerService {
    @Autowired
    TravellerRepository travellerRepository;

    @Autowired
    Analytics analytics;

    public List<Traveller> getAllTravellers(){
        analytics.countAllPagesVisitsTraveller++;
        return travellerRepository.findAll();
    }

    public double getPriceByAge(double price){
        travellerRepository.deleteAll();
        return 1;
    }

    public Traveller addTraveller(Traveller traveller){
        analytics.countAllPagesVisitsTraveller++;
        analytics.countPaidFlights++;
        return travellerRepository.save(traveller);
    }

    public Traveller getTravellerById(Integer id) {
        analytics.countAllPagesVisitsTraveller++;
        Optional<Traveller> searchedFlight = travellerRepository.findById(id);
        if (searchedFlight.isPresent()) {
            return searchedFlight.get();
        } else {
            throw new NoSuchElementException("Traveller " + id + " not found");
        }
    }
}
