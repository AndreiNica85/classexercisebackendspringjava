package com.flyingticketsapp.classexercise;

import com.flyingticketsapp.classexercise.model.Flight;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.Matchers.*;

@SpringBootTest
public class TestUnit {

    private static Flight fLight = new Flight();


    @Test  /* Pass */
    public void testIfAnyFlightsQueriedBeforeChosenDate() {
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .when().get("http://localhost:8080/flights/dates/2022-11-03")
                .then().assertThat().body("departureDate", everyItem(not(lessThan(((LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))))))).extract().response();
        System.out.println(response.asString());
    }

    @Test  /* Pass */              // Remember to put limit on departureTime field
    public void checkDepartureTimeStillValidOneHourBeforeDeparture() {
        LocalTime localTime = LocalTime.now().minusHours(1);
        String oneHourBeforeDepartureTime = localTime.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .when().get("http://localhost:8080/flights/dates/2022-11-03")
                .then().assertThat().body("departureTime", everyItem(greaterThan((oneHourBeforeDepartureTime)))).extract().response();
        System.out.println(response.asString());
    }



//    @Test  /*  */
//    public void testIfAnyFlightsQueriedBeforeChosenTime() {
//        Response response = RestAssured.given().contentType(ContentType.JSON)
//                .when().get("http://localhost:8080/flights")
//                .then().assertThat().body("departureDate", everyItem(not(lessThan(((LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm")))))))).extract().response();
//        System.out.println(response.asString());
//    }

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
