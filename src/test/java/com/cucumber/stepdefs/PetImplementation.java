package com.cucumber.stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.Serializable;

public class PetImplementation implements Serializable {
    private Response putPets = null;
    private Response postPets = null;
    private Response deletePets = null;


    @Given("Go to the URL")
    public void before() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        //Url a la que accedemos
    }


    @When("The following get request that delete the pet")
    public Response getPets() {
        //Introducimos el código de la mascota que hemos creado en POSTMAN
        Response responseGetPets = given().log().all().get("/22061985");

        return responseGetPets;
    }

    @Then("the response is 200")
    public void validateResponse() {
        assertTrue("The response is not 200", getPets().statusCode() == 200);
    }




    @When("The following get request that delete the pets")
    public Response deletePets() {
        Response responseDeletePets = given().log().all().delete("/erojas") ;
        return responseDeletePets;

    }

    @Then("the response for delete pets is 200")
    public void validateResponseDeletePets() {
        assertTrue("The response is not 200", deletePets().statusCode() == 200);
    }




}
