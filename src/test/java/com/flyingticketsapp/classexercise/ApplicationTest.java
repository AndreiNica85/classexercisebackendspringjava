package com.flyingticketsapp.classexercise;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@SpringBootTest
public class ApplicationTest {

    private static final RequestSpecification requestSpecificationBaseURI = new RequestSpecBuilder().setContentType(ContentType.JSON)
            .setBaseUri("http://localhost:8080/flights")
            .build();

    private static final RequestSpecification requestSpecificationBaseURITravellers = new RequestSpecBuilder().setContentType(ContentType.JSON)
            .setBaseUri("http://localhost:8080/travellers")
            .build();

    @Test//Fill database First
    @BeforeAll
    static void runAPITestsFirstToFillDatabase(){

        /* POST Flight Test 1 - 200 - Success */
        RequestSpecification requestSpecification1 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                        "origin": "Seville",
                        "destination": "Paris",
                        "departureDate": "2022-11-20",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 222.0,
                        "roundTrip": false,
                        "travellers": []
                        }"""
        ).when();
        ResponseSpecification responseSpecification1 = new ResponseSpecBuilder().expectStatusCode(200).build();
        // create Flight id = 1
        Response response1 = requestSpecification1.when().post("http://localhost:8080/flights")
                .then().spec(responseSpecification1).extract().response();
        System.out.println(response1.asString());

        /* POST Flight Test 2 - 200 - Success */
        RequestSpecification requestSpecification2 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                                    
                        "origin": "Seville",
                        "destination": "Madrid",
                        "departureDate": "2022-11-26",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 154.0,
                        "roundTrip": true,
                        "travellers": []
                        }"""
        ).when();
        ResponseSpecification responseSpecification2 = new ResponseSpecBuilder().expectStatusCode(200).build();
        // create Flight id = 2
        Response response2 = requestSpecification2.when().post("http://localhost:8080/flights")
                .then().spec(responseSpecification2).extract().response();
        System.out.println(response2.asString());

        /* POST Flight Test 3 - 200 - Success */
        RequestSpecification requestSpecification3 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                                      
                        "origin": "Seville",
                        "destination": "Munich",
                        "departureDate": "2022-11-23",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 421.0,
                        "roundTrip": false,
                        "travellers": []
                        }"""
        ).when();
        ResponseSpecification responseSpecification3 = new ResponseSpecBuilder().expectStatusCode(200).build();
        // create Flight id = 3
        Response response3 = requestSpecification3.when().post("http://localhost:8080/flights")
                .then().spec(responseSpecification3).extract().response();
        System.out.println(response3.asString());

        /* POST Flight Test 4 - 200 - Success */
        RequestSpecification requestSpecification4 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                                      
                        "origin": "Madrid",
                        "destination": "Paris",
                        "departureDate": "2022-11-18",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 125.0,
                        "roundTrip": false,
                        "travellers": []
                        }"""
        ).when();
        ResponseSpecification responseSpecification4 = new ResponseSpecBuilder().expectStatusCode(200).build();
        // create Flight id = 4
        Response response4 = requestSpecification4.when().post("http://localhost:8080/flights")
                .then().spec(responseSpecification4).extract().response();
        System.out.println(response4.asString());

        /* POST Flight Test 5 - 200 - Success */
        RequestSpecification requestSpecification5 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                                       
                        "origin": "Bucharest",
                        "destination": "Seville",
                        "departureDate": "2022-11-27",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 312.0,
                        "roundTrip": true,
                        "travellers": []
                        }"""
        ).when();
        ResponseSpecification responseSpecification5 = new ResponseSpecBuilder().expectStatusCode(200).build();
        // create Flight id = 4
        Response response5 = requestSpecification5.when().post("http://localhost:8080/flights")
                .then().spec(responseSpecification5).extract().response();
        System.out.println(response5.asString());

        /* POST Flight Test 6 - 200 - Success */
        RequestSpecification requestSpecification6 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                                      
                        "origin": "Seville",
                        "destination": "Cadiz",
                        "departureDate": "2022-11-21",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 123.0,
                        "roundTrip": false,
                        "travellers": []
                        }"""
        ).when();
        ResponseSpecification responseSpecification6 = new ResponseSpecBuilder().expectStatusCode(200).build();
        // create Flight id = 6
        Response response6 = requestSpecification6.when().post("http://localhost:8080/flights")
                .then().spec(responseSpecification6).extract().response();
        System.out.println(response6.asString());

        /* POST Flight Test 7 - 200 - Success */
        RequestSpecification requestSpecification7 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                                           
                        "origin": "Seville",
                        "destination": "Barcelona",
                        "departureDate": "2022-11-24",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 322.0,
                        "roundTrip": false,
                        "travellers": []
                        }"""
        ).when();
        ResponseSpecification responseSpecification7 = new ResponseSpecBuilder().expectStatusCode(200).build();
        // create Flight id = 7
        Response response7 = requestSpecification7.when().post("http://localhost:8080/flights")
                .then().spec(responseSpecification7).extract().response();
        System.out.println(response7.asString());

        /* POST Flight Test 8 */
        RequestSpecification requestSpecification8 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                                        
                        "origin": "Bucharest",
                        "destination": "Seville",
                        "departureDate": "2022-11-25",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 312.0,
                        "roundTrip": true,
                        "travellers": []
                        }"""
        ).when();
        ResponseSpecification responseSpecification8 = new ResponseSpecBuilder().expectStatusCode(200).build();
        // create Flight id = 8
        Response response8 = requestSpecification8.when().post("http://localhost:8080/flights")
                .then().spec(responseSpecification8).extract().response();
        System.out.println(response8.asString());

        /* POST Flight Test 9 */
        RequestSpecification requestSpecification13 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                        "origin": "Paris",
                        "destination": "Madrid",
                        "departureDate": "2022-11-24",
                        "departureTime": "08:10:00",
                        "airline": "Fe22",
                        "price": 212.0,
                        "roundTrip": true,
                        "travellers": []
                        }"""
        ).when();
        ResponseSpecification responseSpecification13 = new ResponseSpecBuilder().expectStatusCode(200).build();
        // create Flight id = 9
        Response response13 = requestSpecification13.when().post("http://localhost:8080/flights")
                .then().spec(responseSpecification13).extract().response();
        System.out.println(response13.asString());

        /* DELETE Flight Test 1 - Expected no value present -  500 to pass because not handled server exception - Success */
        RequestSpecification requestSpecification9 = given().spec(requestSpecificationBaseURI);
        // delete Flight ID = 1;
        ResponseSpecification responseSpecification9 = new ResponseSpecBuilder().expectStatusCode(500).build();
        Response response9 = requestSpecification9.when().delete("http://localhost:8080/flights/55").
                then().spec(responseSpecification9).extract().response();
        System.out.println(response9.asString());

        /* DELETE Flight Test 2 - Expected to delete - Value was present 200 - Success */
        RequestSpecification requestSpecification10 = given().spec(requestSpecificationBaseURI);
        // delete Flight ID = 7;
        ResponseSpecification responseSpecification10 = new ResponseSpecBuilder().expectStatusCode(200).build();
        Response response10 = requestSpecification10.when().delete("http://localhost:8080/flights/7").
                then().spec(responseSpecification10).extract().response();
        System.out.println(response10.asString());

        /* GET Flight Test 1 - 200 - Success */
        RequestSpecification requestSpecification = given().spec(requestSpecificationBaseURI).when();
        ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        // get Flight with id = 1;
        Response response = requestSpecification.when().get("http://localhost:8080/flights/1").
                then().spec(responseSpecification).extract().response();
        System.out.println(response.asString());

        /* GET Flight Test 2 - Expected no value present -  500 to pass because not handled server exception - Success */
        RequestSpecification requestSpecification11 = given().spec(requestSpecificationBaseURI).when();
        ResponseSpecification responseSpecification11 = new ResponseSpecBuilder().expectStatusCode(500).expectContentType(ContentType.JSON).build();
        // get Flight with id = 1;
        Response response11 = requestSpecification11.when().get("http://localhost:8080/flights/111").
                then().spec(responseSpecification11).extract().response();
        System.out.println(response11.asString());



        /* POST Traveller Test 1 - 200 - Success */
        RequestSpecification requestSpecification31 = given().spec(requestSpecificationBaseURITravellers).body(
                """
                        {
                        "forename": "Andrei",
                        "surname": "Rodrigo",
                        "age": "1",
                        "userNameAdministrationPage": "admin",
                        "passwordAdministrationPage": "admin",
                        "nationality": "Romania",
                        "email": "peter@gma.com",
                        "NIE": "F4562311J",
                        "bookedFlights": []
                        }"""
        ).when();
        ResponseSpecification responseSpecification31 = new ResponseSpecBuilder().expectStatusCode(200).build();
        // create traveller id = 1
        Response response31  = requestSpecification31.when().post("http://localhost:8080/travellers")
                .then().spec(responseSpecification31).extract().response();
        System.out.println(response31.asString());


        /* POST Traveller Test 2 - 200 - Success */
        RequestSpecification requestSpecification32 = given().spec(requestSpecificationBaseURITravellers).body(
                """
                         {
                        "forename": "Peter",
                        "surname": "Vasile",
                        "age": "7",
                        "userNameAdministrationPage": "admin",
                        "passwordAdministrationPage": "admin",
                        "nationality": "Spanish",
                        "email": "der@gma.com",
                        "NIE": "F4512311J",
                        "bookedFlights": []
                        }"""
        ).when();
        ResponseSpecification responseSpecification32 = new ResponseSpecBuilder().expectStatusCode(200).build();
        // create traveller id = 2
        Response response32 = requestSpecification32.when().post("http://localhost:8080/travellers")
                .then().spec(responseSpecification32).extract().response();
        System.out.println(response32.asString());

        /* POST Traveller Test 3 - 200 - Success */
        RequestSpecification requestSpecification33 = given().spec(requestSpecificationBaseURITravellers).body(
                """
                         {
                        "forename": "Rodrigo",
                        "surname": "Luan",
                        "age": "12",
                        "userNameAdministrationPage": "admin",
                        "passwordAdministrationPage": "admin",
                        "nationality": "Spanish",
                        "email": "fero@gma.com",
                        "NIE": "F4561211J",
                        "bookedFlights": []
                        }"""
        ).when();
        ResponseSpecification responseSpecification33 = new ResponseSpecBuilder().expectStatusCode(200).build();
        // create Traveller id = 3
        Response response33 = requestSpecification33.when().post("http://localhost:8080/travellers")
                .then().spec(responseSpecification33).extract().response();
        System.out.println(response33.asString());

        /* POST Traveller Test 4 */
        RequestSpecification requestSpecification23 = given().spec(requestSpecificationBaseURITravellers).body(
                """
                        {
                        "forename": "Ioan",
                        "surname": "Gheorghe",
                        "age": "15",
                        "userNameAdministrationPage": "admin",
                        "passwordAdministrationPage": "admin",
                        "nationality": "Romania",
                        "email": "fero@gma.com",
                        "NIE": "F4512211J",
                        "bookedFlights": []
                        }"""
        ).when();
        ResponseSpecification responseSpecification23 = new ResponseSpecBuilder().expectStatusCode(200).build();
        // create traveller id = 4
        Response response23 = requestSpecification23.when().post("http://localhost:8080/travellers")
                .then().spec(responseSpecification23).extract().response();
        System.out.println(response23.asString());


        /* GET Traveller Test */
        RequestSpecification requestSpecification24 = given().spec(requestSpecificationBaseURITravellers).when();
        ResponseSpecification responseSpecification24 = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        // get Traveller with id = 1;
        Response response24 = requestSpecification24.when().get("http://localhost:8080/travellers/1").
                then().spec(responseSpecification24).extract().response();
        System.out.println(response24.asString());


        /* DELETE Traveller Test */
        RequestSpecification requestSpecification25 = given().spec(requestSpecificationBaseURITravellers);
        // delete traveller ID = 1;
        ResponseSpecification responseSpecification25 = new ResponseSpecBuilder().expectStatusCode(405).build();
        Response response25 = requestSpecification25.when().delete("http://localhost:8080/travellers/3").
                then().spec(responseSpecification25).extract().response();
        System.out.println(response25.asString());

    }


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

    @Test
    public void testOriginVsDestinationName() {
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .when().get("http://localhost:8080/flights/1")
                .then().assertThat().body("origin", not(equalTo("destination"))).extract().response();
        System.out.println(response.asString());
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

    @AfterAll
    static void flightsAppTest() {

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000");

        // Click first Page Search Flight Button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/button[1]/a")).click();

        // Select Origin
        WebElement elementOrigin = driver.findElement(By.id("origin"));
        try {
            Thread.sleep(5000);
            elementOrigin.click();
            driver.findElement(By.xpath("//*[@id=\"origin\"]/option[3]")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Select Destination
        WebElement elementDestination = driver.findElement(By.id("dest"));
        elementDestination.click();
        try {
            driver.findElement(By.xpath("//*[@id=\"dest\"]/option[5]")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Select Date
        WebElement elementDate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/table/tr[3]/td[2]/input"));
        try {
            elementDate.clear();
            elementDate.sendKeys("20/11/2022");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //Book Flight
        try {
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/table/tr[4]/td/input")).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/a")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            WebElement firstNameEl = driver.findElement(By.id("fname"));
            firstNameEl.sendKeys("Andrei");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        try {
            WebElement lastNameEl = driver.findElement(By.id("lname"));
            lastNameEl.sendKeys("Rodrigo");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys("peter@gma.com");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            WebElement nie = driver.findElement(By.id("nie"));
            nie.sendKeys("F4562311J");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            WebElement nation = driver.findElement(By.id("nation"));
            nation.sendKeys("Spanish");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            WebElement age = driver.findElement(By.id("age"));
            age.sendKeys("1");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            WebElement book = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/div[3]/button"));
            book.click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


       // Payment


        try {
            WebElement name = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/input[1]"));
            name.sendKeys("AndreiPeterRodrigo");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            WebElement cardNo = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/input[2]"));
            cardNo.sendKeys("123412345164361");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            WebElement cardDate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/input[3]"));
            cardDate.sendKeys("2022/04/11");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            WebElement CVC = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/input[4]"));
            CVC.sendKeys("123");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        try {
            WebElement pay = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/a"));
            pay.click();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            WebElement login = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/a[4]"));
            login.click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            WebElement username = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/input[1]"));
            username.sendKeys("admin");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/input[2]"));
            password.sendKeys("admin");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            WebElement analytics = driver.findElement(By.xpath("//*[@id=\"root\"]/div/form/button"));
            analytics.click();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        try {
            WebElement analytics = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/a/img"));
            analytics.click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            driver.close();
        }
    }
}
