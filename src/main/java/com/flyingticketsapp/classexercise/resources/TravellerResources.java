package com.flyingticketsapp.classexercise.resources;

import com.flyingticketsapp.classexercise.model.Traveller;
import com.flyingticketsapp.classexercise.service.TravellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public Traveller addTraveller(@Valid @RequestBody Traveller traveller){
        return travellerService.addTraveller(traveller);
    }

    @GetMapping("/travellers/{id}")
    public Traveller getTraveller(@PathVariable Integer id) {
        return travellerService.getTravellerById(id);
    }

    @PutMapping("/travellers/{id}")
    public void createUserPassword(@PathVariable int id, String userName, String password){
        Traveller userAdmin = travellerService.getTravellerById(id);
        userAdmin.setUserNameAdministrationPage(userName);
        userAdmin.setPasswordAdministrationPage(password);
    }

    @GetMapping("/travellers/{id}/{userName}")
    public boolean validateUserPassword(@PathVariable int id, @PathVariable String userName, String password){
        Traveller userAdmin = travellerService.getTravellerById(id);
        return userAdmin.getUserNameAdministrationPage().equals(userName) && userAdmin.getPasswordAdministrationPage().equals(password);
    }



}
