package com.flyingticketsapp.classexercise;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class TestAPI {

    private static final RequestSpecification requestSpecificationBaseURI = new RequestSpecBuilder().setContentType(ContentType.JSON)
            .setBaseUri("http://localhost:8080/flights")
            .build();

    public static void main(String[] args) {
        /* POST Flight Test 1 - 200 - Success */
        RequestSpecification requestSpecification1 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                        "id": 1,
                        "origin": "Seville",
                        "destination": "Paris",
                        "departureDate": "2022-11-20",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 222.0,
                        "roundTrip": false
                        }"""
        ).when();
        ResponseSpecification responseSpecification1 = new ResponseSpecBuilder().expectStatusCode(200).build();
        // create traveller id = 1
        Response response1 = requestSpecification1.when().post("http://localhost:8080/flights")
                .then().spec(responseSpecification1).extract().response();
        System.out.println(response1.asString());

        /* POST Flight Test 2 - 200 - Success */
        RequestSpecification requestSpecification2 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                        "id": 2,
                        "origin": "Seville",
                        "destination": "Madrid",
                        "departureDate": "2022-11-26",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 154.0,
                        "roundTrip": true
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
                        "id": 3,
                        "origin": "Seville",
                        "destination": "Munich",
                        "departureDate": "2022-11-23",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 421.0,
                        "roundTrip": false
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
                        "id": 4,
                        "origin": "Madrid",
                        "destination": "Paris",
                        "departureDate": "2022-11-18",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 125.0,
                        "roundTrip": false
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
                        "id": 5,
                        "origin": "Bucharest",
                        "destination": "Seville",
                        "departureDate": "2022-11-27",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 312.0,
                        "roundTrip": true
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
                        "id": 6,
                        "origin": "Seville",
                        "destination": "Cadiz",
                        "departureDate": "2022-11-01",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 123.0,
                        "roundTrip": false
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
                        "id": 7,
                        "origin": "Seville",
                        "destination": "Barcelona",
                        "departureDate": "2022-11-24",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 322.0,
                        "roundTrip": false
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
                        "id": 8,
                        "origin": "Bucharest",
                        "destination": "Seville",
                        "departureDate": "2022-11-25",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 312.0,
                        "roundTrip": true
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
                        "id": 9,
                        "origin": "Paris",
                        "destination": "Madrid",
                        "departureDate": "2022-11-24",
                        "departureTime": "05:10:00",
                        "airline": "Fe22",
                        "price": 212.0,
                        "roundTrip": true
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
        RequestSpecification requestSpecification10= given().spec(requestSpecificationBaseURI);
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

    }
}
