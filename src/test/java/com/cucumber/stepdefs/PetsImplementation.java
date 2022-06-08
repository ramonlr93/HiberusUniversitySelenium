package com.cucumber.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.Assert.*;


public class PetsImplementation implements Serializable {

    private Response putUsers = null;
    private Response postPet = null;
    private Response deletePet = null;

    @Before
    public void before(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";  //URL base de la petición
    }

    // Get Pet *************************************************************************
    @Given("the following get request that brings us the pet")
    public  Response getPet(){
        //Devuelve el GetPet
        //.log().all() es opcional. Es solo para obtener trazas por el log.
        //En .param pasamos el parÃ¡metro 2 para 'page' (igual que lo tenemos en postman)
        //En .get pasamos lo que va despuÃ©s de la baseUri (despuÃ©s del /api/)

        Response responseGetPet = given().log().all().get("/123456");
        return responseGetPet;
    }

    @And("the response is 200")
    public void validateResponseGet(){
        assertTrue("The response is not 200",getPet().statusCode()==200);
    }

    @Then("the body response contains the {string} of the pet")
    public void validatePetId(String valueId){
        System.out.println(getPet().body());
        JsonPath jsonPathPets = new JsonPath(getPet().body().asString());
        String jsonPets=jsonPathPets.getString("id");
        assertEquals("The value of the name field is not the expected",valueId,jsonPets);
    }

    // Post Pet *************************************************************************
    @Given ("the following post request that add pets")
    public void postPet(){
        File fileBodyRequest = new File("src/main/resources/bodyRequest.json");
        postPet = given().contentType(ContentType.JSON).body(fileBodyRequest).post();
    }

    @And ("the response is 200 for the post")
    public void validateResponsePost(){
        System.out.println("Status code: " + postPet.statusCode());
        assertTrue("The response is not 200",postPet.statusCode()==200);
    }

    @Then ("the body response contains the {string} of the pet created")
    public void validateResponsePostBodyValueName(String valueName) {
        JsonPath jsonPathUsers = new JsonPath(postPet.body().asString());
        String jsonUsers=jsonPathUsers.getString("name");
        assertEquals("The value of the name field is not what is expected",valueName,jsonUsers);
    }

    // Delete Pet *************************************************************************
    @And ("the following delete request that delete pets")
    public void deletePet() {
        JsonPath jsonPathPets = new JsonPath(postPet.body().asString());
        String jsonIdCreate = jsonPathPets.getString("id");
        System.out.println("jsonIdCreate : " + jsonIdCreate);
        deletePet = given().accept(ContentType.JSON).delete(jsonIdCreate);

    }

    @And ("the response is 204 for the delete")
    public void validateResponseDelete(){
        assertTrue("The response is not 200",deletePet.statusCode()==200);
    }

    @Then ("the body response is empty")
    public void validateResponseDeleteBodyEmpty() {
        JsonPath jsonDeletePet = new JsonPath(deletePet.body().asString());
        String jsonPets=jsonDeletePet.getString("id");
        assertNull("The pet hasn't been deleted", jsonPets);
    }

    // Pets by Status *************************************************************
    @And ("the following get request that get pets by {string}")
    public Response getPetByStatus(String status){
        Response responseGetPetStatus = given().log().all().get("/findByStatus?status="+status);
        System.out.println("responseGetPetStatus: "+responseGetPetStatus);
        return responseGetPetStatus;
    }

    @And ("the response is 200 for the get by status")
    public void validateResponseGetByStatus(){
        assertTrue("The response is not 200",getPetByStatus("available").statusCode()==200);
    }


}