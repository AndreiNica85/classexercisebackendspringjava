package com.flyingticketsapp.classexercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestUnit {

    @ParameterizedTest()
    @ValueSource(ints = {98, 100,101,200})
    void maxNumberSits(int planeSits) {
        int maxNumberOfSits = 100;  // Maximum sits per plane is 100;
        Assert.isTrue(planeSits < maxNumberOfSits, "Maximum number of sits in a plane is 100" );
    }

    @ParameterizedTest
    @ValueSource(doubles = {10.5, 9, 0, 1, 11})
    public void lugaggeLessThanTen(double maxLugagge){
        Assert.isTrue(maxLugagge <= 10, "Testing lugagge");
    }

    public boolean bookASeat(String seat, List<String> seats) {
        return seats.remove(seat);
    }
    @ParameterizedTest
    @ValueSource(strings = {"15B","16B","17B","18B"})
    public void testIfSeatIsAvailableForBooking(String seatAvailable) {

        List<String> seats = new ArrayList<>();
        seats.add("15B");
        seats.add("16B");
        seats.add("17B");
        seats.add("18B");
        Assert.isTrue(bookASeat(seatAvailable, seats), "Seat should be available for booking");
    }

    @ParameterizedTest
    @ValueSource(strings = {"000","001","002","003","004","005","006","007","008"})
    public void testIfSeatIsNotAvailableForBooking(String seatNotAvailable) {

        List<String> seats = new ArrayList<>();
        seats.add("15B");
        seats.add("16B");
        seats.add("17B");
        seats.add("18B");
        Assert.isTrue(!bookASeat(seatNotAvailable, seats), "Seat shouldnot be available for booking");
    }

    @Test
    public void checkFlightDate() {
        LocalDate flightDate = LocalDate.now().plusDays(5);
        LocalDate currentDate = LocalDate.now();
        Assert.isTrue(flightDate.compareTo(currentDate) >= 0, "flightDate should not be in past date");
    }

    
}
