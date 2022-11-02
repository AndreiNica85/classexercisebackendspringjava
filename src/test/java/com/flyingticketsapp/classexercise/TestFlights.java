package com.flyingticketsapp.classexercise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
public class TestFlights {

    @ParameterizedTest
    @ValueSource(doubles = {10.5, 9, 0, 1, 11})
    public void lugaggeLessThanTen(double maxLugagge){
        Assert.isTrue(maxLugagge <= 10, "Testing lugagge");
        System.out.println(LocalTime.now());
        System.out.println(LocalDate.now());
    }


}
