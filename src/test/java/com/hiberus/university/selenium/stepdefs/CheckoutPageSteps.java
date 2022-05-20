package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.CheckOutStepOnePage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckoutPageSteps {
    @And("the user clicked the checkout button")
    public void theUserClickedTheCheckoutButton(){
        PagesFactory pf = PagesFactory.getInstance();
        CartPage cartPage = pf.getCartPage();
        cartPage.clickCheckout();
    }

    @And("the user added the details correctly")
    public void theUserAddedTheDetailsCorrectly() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckOutStepOnePage checkOutStepOnePage = pf.getCheckOutStepOnePage();
        checkOutStepOnePage.fillInformation();
    }

    @When("the user clicks in the continue button and goes to the checkout page")
    public void theUserClicksInTheContinueButtonAndGoesToTheCheckoutPage() {
    }

    @Then("it shows the total price to pay")
    public void itShowsTheTotalPriceToPay() {
    }

    @When("the user clicks the finish checkout button")
    public void theUserClicksTheFinishCheckoutButton() {
    }

    @Then("it shows the message {string}")
    public void itShowsTheMessage(String arg0) {
    }
}
