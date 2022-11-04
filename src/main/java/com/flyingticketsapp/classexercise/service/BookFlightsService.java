package com.flyingticketsapp.classexercise.service;

import com.flyingticketsapp.classexercise.model.Flight;
import com.flyingticketsapp.classexercise.model.Traveller;
import com.flyingticketsapp.classexercise.repository.BookFlightsRepository;
import com.flyingticketsapp.classexercise.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookFlightsService {

    @Autowired
    BookFlightsRepository bookFlightsRepository;

    protected static Long countPaidFlights = 0L;
    protected static Long countAllPagesVisitsTraveller = 0L;

    public List<Traveller> getAllTravellers(){
        countAllPagesVisitsTraveller++;
        return bookFlightsRepository.findAll();
    }

    public double getPriceByAge(double price){
        bookFlightsRepository.deleteAll();
        return 1;
    }

    public Traveller addTraveller(Traveller traveller){
        countAllPagesVisitsTraveller++;
        countPaidFlights++;
        return bookFlightsRepository.save(traveller);
    }

    public Traveller getTravellerById(Integer id) {
        countAllPagesVisitsTraveller++;
        Optional<Traveller> searchedFlight = bookFlightsRepository.findById(id);
        if (searchedFlight.isPresent()) {
            return searchedFlight.get();
        } else {
            throw new NoSuchElementException("Traveller " + id + " not found");
        }
    }
}
