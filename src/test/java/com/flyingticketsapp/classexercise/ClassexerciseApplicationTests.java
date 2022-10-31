package com.flyingticketsapp.classexercise;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ClassexerciseApplicationTests {
    @Test
    void contextLoads() {

    }

    public boolean bookASeat(String seat, List<String> seats) {
        return seats.remove(seat);
    }

    @Test
    public void checkFlightDate() {
        LocalDate flightDate = LocalDate.now().plusDays(5);
        LocalDate currentDate = LocalDate.now();

        Assert.isTrue(flightDate.compareTo(currentDate) >= 0, "flightDate should not be in past date");
    }
}
