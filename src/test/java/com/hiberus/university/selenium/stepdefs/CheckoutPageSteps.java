package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CheckoutCompletedPage;
import com.hiberus.university.selenium.pages.CheckoutPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;


@Slf4j
public class CheckoutPageSteps {

    @And("the user goes to checkout page")
    public void theUserGoesToCheckoutPage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is in the checkout page");
        InventoryPage inventoryPage = pf.getInventoryPage();
        inventoryPage.clickOnCheckoutButton();
    }


    @And("the user adds the details correctly {string} {string} {string} {string} {string} {string} {string}")
    public void theUserAddsTheDetailsCorrectly(String name, String lastname, String address, String city, String postcode, String country, String state) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user fills all the info");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.waitForPageLoad();
        checkoutPage.newAddressClick();
        checkoutPage.enterFirstName(name);
        checkoutPage.enterLastName(lastname);
        checkoutPage.enterAddress(address);
        checkoutPage.enterCity(city);
        checkoutPage.enterPostcode(postcode);
        checkoutPage.selectCountry(country);
        checkoutPage.selectState(state);
    }

    @When("the user confirms all the information")
    public void theUserConfirmsAllTheInformation() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user confirms all the info");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickContinue();
        checkoutPage.clickContinue2();
        checkoutPage.clickContinue3();
        checkoutPage.clickTermsConditions();
        checkoutPage.clickContinue4();

        checkoutPage.clickConfirmOrder();
    }

    @Then("it shows a message that the order was placed")
    public void itShowsAMessageThatTheOrderWasPlaced() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("A message showing the order was placed succesfully");
        CheckoutCompletedPage checkoutCompletedPage = pf.getCheckoutCompletedPage();
        Assert.assertTrue("FAILED, THE ORDER WAS NOT PLACED CORRECTLY", checkoutCompletedPage.confirmationOrderMessage());
    }
}
