package com.flyingticketsapp.classexercise.resources;

import com.flyingticketsapp.classexercise.model.Traveller;
import com.flyingticketsapp.classexercise.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TravellerResources {

    @Autowired
    TravellerService travellerService;

    @GetMapping("/travellers")
    public List<Traveller> getAllTravellers(){
        return travellerService.getAllTravellers();
    }

}
