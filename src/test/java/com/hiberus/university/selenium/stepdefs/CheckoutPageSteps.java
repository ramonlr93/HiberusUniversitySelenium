package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.assertEquals;

@Slf4j
public class CheckoutPageSteps {
    @And("the user clicked the checkout button")
    public void theUserClickedTheCheckoutButton(){
        PagesFactory pf = PagesFactory.getInstance();
        CartPage cartPage = pf.getCartPage();
        cartPage.clickCheckout();
    }

    @When("the user clicks in the continue button and goes to the checkout page")
    public void theUserClicksInTheContinueButtonAndGoesToTheCheckoutPage() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckOutStepOnePage checkOutStepOnePage = pf.getCheckOutStepOnePage();
        checkOutStepOnePage.clickContinue();
    }

    @Then("it shows the total price to pay")
    public void itShowsTheTotalPriceToPay() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckOutStepTwoPage checkOutStepTwoPage = pf.getCheckOutStepTwoPage();
        checkOutStepTwoPage.getItemTotal();
    }

    @And("the user clicks the finish checkout button")
    public void theUserClicksTheFinishCheckoutButton() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckOutStepTwoPage checkOutStepTwoPage = pf.getCheckOutStepTwoPage();
        checkOutStepTwoPage.clickFinish();
    }

    @Then("it shows the message {string}")
    public void itShowsTheMessage(String message) {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutCompleted checkoutCompleted = pf.getCheckoutCompleted();
        assertEquals("FAILED, THE ORDER WAS NOT PLACED CORRECTLY", message, checkoutCompleted.getCompleteMessage());
    }

    @And("the user added the details correctly {string} {string} {string}")
    public void theUserAddedTheDetailsCorrectly(String name, String surname, String postcode) {
        PagesFactory pf = PagesFactory.getInstance();
        CheckOutStepOnePage checkOutStepOnePage = pf.getCheckOutStepOnePage();
        checkOutStepOnePage.fillInformation(name, surname, postcode);
    }
}
