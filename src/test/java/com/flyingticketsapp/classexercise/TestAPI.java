package com.flyingticketsapp.classexercise;

import com.flyingticketsapp.classexercise.model.Flight;
import com.flyingticketsapp.classexercise.model.Traveller;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.Json;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@SpringBootTest
public class TestAPI {

    private static final RequestSpecification requestSpecificationBaseURI = new RequestSpecBuilder().setContentType(ContentType.JSON)
            .setBaseUri("http://localhost:8080/flights")
            .build();

    private static final RequestSpecification requestSpecificationBaseURITravellers = new RequestSpecBuilder().setContentType(ContentType.JSON)
            .setBaseUri("http://localhost:8080/travellers")
            .build();

    @BeforeMethod
    public static void main(String[] args) {

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

        /**  Travellers  */

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
                        "email": "romanaia@gma.com",
                        "NIE": "F4562311J",
                        "bookedFlights": []
                        }"""
        ).when();
        ResponseSpecification responseSpecification31 = new ResponseSpecBuilder().expectStatusCode(200).build();
        /**     */
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
        // create Flight id = 1
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

    @Test
    void flightsAppTest() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000");

        // Click first Page Search Flight Button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/button[1]/a")).click();

        // Select Origin
        WebElement elementOrigin = driver.findElement(By.id("origin"));
        try {
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
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            driver.close();
        }

    }
}
