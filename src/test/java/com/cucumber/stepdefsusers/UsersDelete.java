package com.cucumber.stepdefsusers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.Serializable;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class UsersDelete implements Serializable {
    private Response putUsers = null;
    private Response postUsers = null;
    private Response deleteUsers = null;


    @Given("Go to the URL to delete the user")
    public void before() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/user";
        //Url a la que accedemos
    }


    @When("The following get request that delete the user")
    public Response deleteUsers() {
        Response responseDeleteUsers = given().log().all().delete("/erojas") ;
        return responseDeleteUsers;

    }

    @Then("the response for delete users is 200")
    public void validateResponse() {
        assertTrue("The response is not 200", deleteUsers().statusCode() == 200);
    }






}