package com.flyingticketsapp.classexercise.service;

import com.flyingticketsapp.classexercise.model.Traveller;
import com.flyingticketsapp.classexercise.repository.TravellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookFlightsService {

    @Autowired
    TravellerRepository travellerRepository;

    protected static Long countPaidFlights = 0L;
    protected static Long countAllPagesVisitsTraveller = 0L;

    public List<Traveller> getAllTravellers(){
        countAllPagesVisitsTraveller++;
        return travellerRepository.findAll();
    }

    public double getPriceByAge(double price){
        travellerRepository.deleteAll();
        return 1;
    }

    public Traveller addTraveller(Traveller traveller){
        countAllPagesVisitsTraveller++;
        countPaidFlights++;
        return travellerRepository.save(traveller);
    }

    public Traveller getTravellerById(Integer id) {
        countAllPagesVisitsTraveller++;
        Optional<Traveller> searchedFlight = travellerRepository.findById(id);
        if (searchedFlight.isPresent()) {
            return searchedFlight.get();
        } else {
            throw new NoSuchElementException("Traveller " + id + " not found");
        }
    }
}
