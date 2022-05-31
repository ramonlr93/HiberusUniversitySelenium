package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CheckOutStepOnePage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Slf4j
public class CheckOutStepOnePageSteps {
    private PagesFactory pf = PagesFactory.getInstance();
    private CheckOutStepOnePage checkOutStepOnePage = pf.getCheckOutStepOnePage();

    @And("the user provides the first name {string}")
    public void theUserProvidesTheFirstName(String firstName) {
        checkOutStepOnePage.enterFirstName(firstName);
    }

    @And("the user provides the last name {string}")
    public void theUserProvidesTheLastName(String lastName) {
        checkOutStepOnePage.enterLastName(lastName);
    }

    @And("the user provides the zip {string}")
    public void theUserProvidesTheZip(String zip) {
        checkOutStepOnePage.enterPostalCode(zip);
    }

    @When("the user clicks on the continue button")
    public void theUserClicksOnTheContinueButton() {
        checkOutStepOnePage.clickContinue();
    }
}
