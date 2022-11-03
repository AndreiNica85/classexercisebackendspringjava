package com.flyingticketsapp.classexercise.service;

import com.flyingticketsapp.classexercise.repository.TravellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravellerService {

    @Autowired
    TravellerRepository travellerRepository;
}
