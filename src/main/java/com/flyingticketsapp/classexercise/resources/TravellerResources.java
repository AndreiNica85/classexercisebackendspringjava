package com.flyingticketsapp.classexercise.resources;

import com.flyingticketsapp.classexercise.model.Flight;
import com.flyingticketsapp.classexercise.model.Traveller;
import com.flyingticketsapp.classexercise.service.TravellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TravellerResources {

    @Autowired
    TravellerService travellerService;

    @GetMapping("/travellers")
    public List<Traveller> getAllTravellers(){
        return travellerService.getAllTravellers();
    }
    @PostMapping("/travellers")
    public Traveller addTraveller(@RequestBody Traveller traveller){
        return travellerService.addTraveller(traveller);
    }

    @GetMapping("/travellers/{id}")
    public Traveller getTraveller(@Valid @PathVariable Integer id) {
        return travellerService.getTravellerById(id);
    }

}
