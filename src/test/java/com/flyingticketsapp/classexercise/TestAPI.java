package com.flyingticketsapp.classexercise;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class TestAPI {

    private static final RequestSpecification requestSpecificationBaseURI = new RequestSpecBuilder().setContentType(ContentType.JSON)
            .setBaseUri("http://localhost:8080/flights")
            .build(); //

    public static void main(String[] args) {
        /* POST Flight Test 1 */
        RequestSpecification requestSpecification1 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                        "id": 1,
                        "origin": "Seville",
                        "destination": "Paris",
                        "departureDate": "2022-11-05",
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

        /* POST Flight Test 2 */
        RequestSpecification requestSpecification2 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                        "id": 2,
                        "origin": "Seville",
                        "destination": "Madrid",
                        "departureDate": "2022-11-07",
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

        /* POST Flight Test 3 */
        RequestSpecification requestSpecification3 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                        "id": 3,
                        "origin": "Seville",
                        "destination": "Munich",
                        "departureDate": "2022-11-05",
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

        /* POST Flight Test 4 */
        RequestSpecification requestSpecification4 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                        "id": 4,
                        "origin": "Madrid",
                        "destination": "Paris",
                        "departureDate": "2022-11-04",
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

        /* POST Flight Test 5 */
        RequestSpecification requestSpecification5 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                        "id": 5,
                        "origin": "Bucharest",
                        "destination": "Seville",
                        "departureDate": "2022-11-09",
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

        /* POST Flight Test 6 */
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

        /* POST Flight Test 7 */
        RequestSpecification requestSpecification7 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                        "id": 7,
                        "origin": "Seville",
                        "destination": "Barcelona",
                        "departureDate": "2022-11-04",
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
                        "departureDate": "2022-11-07",
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

        /* GET Flight Test */
        RequestSpecification requestSpecification = given().spec(requestSpecificationBaseURI).when();
        ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        // get Flight with id = 1;
        Response response = requestSpecification.when().get("http://localhost:8080/flights/1").
                then().spec(responseSpecification).extract().response();
        System.out.println(response.asString());


//        /* DELETE Flight Test */
//        RequestSpecification requestSpecification6 = given().spec(requestSpecificationBaseURI);
//        // delete Flight ID = 1;
//        ResponseSpecification responseSpecification6 = new ResponseSpecBuilder().expectStatusCode(200).build();
//        Response response6 = requestSpecification6.when().delete("http://localhost:8080/flights/3").
//                then().spec(responseSpecification6).extract().response();
//        System.out.println(response6.asString());



    }
}
