package com.flyingticketsapp.classexercise.resources;

import com.flyingticketsapp.classexercise.model.Flight;
import com.flyingticketsapp.classexercise.model.Traveller;
import com.flyingticketsapp.classexercise.service.BookFlightsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookFlightsResources {

    @Autowired
    @Qualifier("bookFlightsService")
    BookFlightsService bookFlightsService;

    public BookFlightsResources(BookFlightsService bookFlightsService){
        this.bookFlightsService = bookFlightsService;
    }

    @GetMapping("/travellers")
    public List<Traveller> getAllTravellers(){
        return bookFlightsService.getAllTravellers();
    }

    @PostMapping("/travellers")
    public Traveller addTraveller(@Valid @RequestBody Traveller traveller){
        return bookFlightsService.addTraveller(traveller);
    }

    @GetMapping("/travellers/{id}")
    public Traveller getTraveller(@PathVariable Integer id) {
        return bookFlightsService.getTravellerById(id);
    }

    @PutMapping("/travellers/{id}")
    public void createUserPassword(@PathVariable int id, String userName, String password){
        Traveller userAdmin = bookFlightsService.getTravellerById(id);
        userAdmin.setUserNameAdministrationPage(userName);
        userAdmin.setPasswordAdministrationPage(password);
    }

    @GetMapping("/travellers/{id}/{userName}")
    public boolean validateUserPassword(@PathVariable int id, @PathVariable String userName, String password){
        Traveller userAdmin = bookFlightsService.getTravellerById(id);
        return userAdmin.getUserNameAdministrationPage().equals(userName) && userAdmin.getPasswordAdministrationPage().equals(password);
    }



}
