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
        /* POST Traveller Test */
        RequestSpecification requestSpecification2 = given().spec(requestSpecificationBaseURI).body(
                """
                        {
                        "id": 1,
                        "origin": "Seville",
                        "destination": "Madrid",
                        "departureDate": "2022-11-07",
                        "departureTime": "23:10:00",
                        "airline": "Fe22",
                        "price": 0.0,
                        "roundTrip": false
                        }"""
        ).when();
        ResponseSpecification responseSpecification2 = new ResponseSpecBuilder().expectStatusCode(200).build();
        // create traveller id = 3
        Response response2 = requestSpecification2.when().post("http://localhost:8080/flights")
                .then().spec(responseSpecification2).extract().response();
        System.out.println(response2.asString());

        /* GET Traveller Test */
        RequestSpecification requestSpecification = given().spec(requestSpecificationBaseURI).when();
        ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        // get Traveller with id = 1;
        Response response = requestSpecification.when().get("http://localhost:8080/flights/1").
                then().spec(responseSpecification).extract().response();
        System.out.println(response.asString());


        /* DELETE Traveller Test */
        RequestSpecification requestSpecification1 = given().spec(requestSpecificationBaseURI);
        // delete traveller ID = 1;
        ResponseSpecification responseSpecification1 = new ResponseSpecBuilder().expectStatusCode(200).build();
        Response response1 = requestSpecification1.when().delete("http://localhost:8080/flights/1").
                then().spec(responseSpecification1).extract().response();
        System.out.println(response1.asString());



    }
}
