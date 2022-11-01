package com.flyingticketsapp.classexercise.service;

import com.flyingticketsapp.classexercise.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaneService {

    @Autowired
    PlaneRepository planeRepository;
}
