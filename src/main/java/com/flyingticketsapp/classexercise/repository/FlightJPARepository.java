package com.flyingticketsapp.classexercise.repository;

import com.flyingticketsapp.classexercise.model.Flight;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public class FlightJPARepository {

    private EntityManager entityManager;

    public void insert(Flight flight){
        entityManager.merge(flight);
    }
}
