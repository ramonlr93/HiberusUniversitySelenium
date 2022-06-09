package com.practicafinal.stepdefs;

import com.practicafinal.pages.PagesFactory;
import com.practicafinal.support.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import com.practicafinal.pages.RegistrerPage;

@Slf4j
public class RegisterPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    RegistrerPage rp = pf.getRegisterpage();

    @And("the user provides the data for the form")
    public void theUserProvidesTheDataForTheForm(DataTable data) {
        rp.fillFields(data);
    }

    @When("the user clicks the register button")
    public void theUserClicksTheRegisterButton() {
        rp.register();
    }

    @Then("the user is registered successfully")
    public void theUserIsRegisteredSuccessfully() {
        String URL = "http://opencart.abstracta.us/index.php?route=account/success";
        Assert.assertEquals("the url is not the same",URL, Hooks.driver.getCurrentUrl());
    }


    @And("the user provides the incorrect data for the form")
    public void theUserProvidesTheIncorrectDataForTheForm(DataTable data) {
        rp.fillFields(data);
    }
    @Then("the user cannot registered")
    public void theUserCannotRegistered() {
        Assert.assertTrue("the error message is not displayed",rp.wrongRegistration());
    }
}
