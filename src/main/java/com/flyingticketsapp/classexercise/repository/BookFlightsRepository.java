package com.flyingticketsapp.classexercise.repository;

import com.flyingticketsapp.classexercise.model.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookFlightsRepository extends JpaRepository<Traveller, Integer> {


}
