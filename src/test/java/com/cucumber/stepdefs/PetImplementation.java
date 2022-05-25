package com.cucumber.stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.Serializable;

public class PetImplementation implements Serializable {
    private Response putPets = null;
    private Response postPets = null;
    private Response deletePets = null;


    @Before
    public void before() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        //Url a la que accedemos
    }


    @Given("the following get request that brings us the pets")
    public Response getPets() {
    //Introducimos el código de la mascota
        Response responseGetPets = given().log().all().get("/2206");

        return responseGetPets;
    }

    @And("the response is 200")
    public void validateResponse() {
        assertTrue("The response is not 200", getPets().statusCode() == 200);
    }




}