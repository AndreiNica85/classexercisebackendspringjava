package com.flyingticketsapp.classexercise.repository;

import com.flyingticketsapp.classexercise.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane,Integer> {

}
