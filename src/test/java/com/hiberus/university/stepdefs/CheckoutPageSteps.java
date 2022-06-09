package com.hiberus.university.stepdefs;

import com.hiberus.university.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class CheckoutPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    CheckoutPage checkoutPage = pf.getCheckoutPage();

    @And("the user clicks the billing continue button")
    public void clickBillingContinueButton() {
        checkoutPage.clickBillingContinue();
    }

    @And("the user clicks the delivery details continue button")
    public void clickDeliveryDetailsContinueButton() {
        checkoutPage.clickDDetailsContinue();
    }

    @And("the user clicks the delivery method continue button")
    public void clickDeliveryMethodContinueButton() {
        checkoutPage.clickDMethodContinue();
    }

    @And("the user clicks Agree terms")
    public void clickAgreeTerms() {
        checkoutPage.clickAgree();
    }

    @And("the user clicks the payment continue button")
    public void clickPaymentContinueButton() {
        checkoutPage.clickPaymentContinue();
    }

    @When("the user clicks the confirm order button")
    public void clickConfirmOrderContinueButton() {
        checkoutPage.clickConfirmOrder();
    }

    @Then("the user should be shown a success order message")
    public void successOrderMessageDisplayed() {
        log.info("The user should be shown an invalid message");
        Assert.assertTrue("Order Failed", checkoutPage.hasCheckoutOrderSuccess());
    }
}


