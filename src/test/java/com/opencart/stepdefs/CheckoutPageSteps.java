package com.opencart.stepdefs;

import com.opencart.pages.CheckoutPage;
import com.opencart.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class CheckoutPageSteps {

    private final CheckoutPage checkoutPage;

    public CheckoutPageSteps() {
        checkoutPage = PagesFactory.getInstance().getCheckoutPage();
    }

    @And("the user clicks continue to billing details")
    public void theUserClicksContinueToBillingDetails() {
        checkoutPage.clickBillingDetaillsButton();
    }

    @And("the user clicks continue to delivery details")
    public void theUserClicksContinueToDeliveryDetails() {
        checkoutPage.clickDeliveryDetailsButton();
    }

    @And("the user clicks continue to delivery method")
    public void theUserClicksContinueToDeliveryMethod() {
        checkoutPage.clickDeliveryMethodButton();
    }

    @And("the user clicks continue to payment")
    public void theUserClicksContinueToPayment() {
        checkoutPage.clickPaymentMethodButton();
    }

    @And("the user selects {string}")
    public void theUserSelects(String opt) {
        checkoutPage.selectPaymentOption(opt);
    }

    @And("the user accepts terms and conditions")
    public void theUserAcceptsTermsAndConditions() {
        checkoutPage.clickAcceptTerms();
    }

    @And("the user clicks continue to confirm")
    public void theUserClicksContinueToConfirm() {
        checkoutPage.clickPaymentMethodButton();
    }

    @When("the user clicks confirm order")
    public void theUserClicksConfirmOrder() {
        checkoutPage.clickConfirmOrderButton();
    }

    @Then("the user sees the {string} window")
    public void theUserSeesTheWindow(String msg) {
        Assert.assertEquals("Some errror happened", msg, checkoutPage.getOrderStatus());
    }


}
