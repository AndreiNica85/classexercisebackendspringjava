package com.flyingticketsapp.classexercise.resources;

import com.flyingticketsapp.classexercise.model.Traveller;
import com.flyingticketsapp.classexercise.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookResources {

    @Autowired
    @Qualifier("bookService")
    BookService bookService;

    public BookResources(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/travellers")
    public List<Traveller> getAllTravellers(){
        return bookService.getAllTravellers();
    }
    @PostMapping("/travellers")
    public Traveller addTraveller(@Valid @RequestBody Traveller traveller){
        return bookService.addTraveller(traveller);
    }

    @GetMapping("/travellers/{id}")
    public Traveller getTraveller(@PathVariable Integer id) {
        return bookService.getTravellerById(id);
    }

}
