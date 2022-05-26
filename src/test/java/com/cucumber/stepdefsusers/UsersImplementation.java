package com.cucumber.stepdefsusers;

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

public class UsersImplementation implements Serializable {
    private Response putUsers = null;
    private Response postUsers = null;
    private Response deleteUsers = null;


    @Before
    public void before() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/user";
        //Url a la que accedemos
    }


    @Given("the following get request that brings us the users")
    public Response getUsers() {
        Response responseGetUsers = given().log().all().get("/erojas") ;
        return responseGetUsers;

    }

    @And("the response is 200")
    public void validateResponse() {
        assertTrue("The response is not 200", getUsers().statusCode() == 200);
    }




}