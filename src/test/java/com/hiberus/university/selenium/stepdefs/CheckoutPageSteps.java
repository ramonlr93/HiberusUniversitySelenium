package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CheckoutPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class CheckoutPageSteps {

    @And("the user clicks checkout link")
    public void theUserClicksCheckoutLink() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickOnChekoutLink();
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
    }

    @And("the user provides the first name {string} and the last name {string} and the address {string} and the city {string} and the country {string} and the region {string}")
    public void theUserProvidesTheFirstNameAndTheLastNameAndTheAddressAndTheCityAndTheCountryAndTheRegion(String firstName, String lastName, String address, String city, String country, String region) {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.fillBillingDetails(firstName, lastName, address, city, country, region);

    }

    @And("the user selects guest user")
    public void theUserSelectsGuestUser() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.selectGuestUser();
    }

    @And("the user clicks step one continue button")
    public void theUserClicksStepOneContinueButton() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickStepOneContinueButton();
    }
}
