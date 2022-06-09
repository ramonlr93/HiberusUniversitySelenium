package com.opencart.automation.stepdefs;

import com.opencart.automation.pages.CheckoutPage;
import com.opencart.automation.pages.MyAccountPage;
import com.opencart.automation.pages.PagesFactory;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

@Slf4j
public class CheckoutPageSteps {
    private final PagesFactory pf = PagesFactory.getInstance();
    private final MyAccountPage myAccountPage;
    private final WebDriver driver = pf.getDriver();
    CheckoutPage checkoutPage = pf.getCheckoutPage();

    public CheckoutPageSteps() {
        myAccountPage = PagesFactory.getInstance().getMyAccountPage();
    }

    @And("the user go checkout")
    public void theUserGoToCheckout(){
        myAccountPage.clickOnCheckout();
    }

    @And("the user inside checkout")
    public void theUserIsInTheCheckout() {
     assertEquals("The is not inside checkout page", CheckoutPage.PAGE_URL, pf.getDriver().getCurrentUrl());
    }

    @And("the user enter {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserEnter(String firstName, String lastName, String company, String address, String city, String postCode) {
        checkoutPage.enterDataBillingDetailst(firstName,lastName, company,address,city,postCode);
    }

    @And("the user select {string} and {string}")
    public void theUserSelectAnd(String country, String region) {
        checkoutPage.countrySelection(country);
        checkoutPage.regionSelection(region);
    }

    @And("the user clicks the payment button, the shipping button and the shipping method button")
    public void theUserClicksThePaymentButtonTheShippingButtonTheShippingMethodButton() {
        checkoutPage.clickAddressContinueButton();
        checkoutPage.clickShippingContinueButton();
        checkoutPage.clickShippingMethodContinueButton();
    }

    @And("the user accepts the conditions")
    public void theUserAcceptsTheConditions() {
        checkoutPage.clickAcceptTermsAndConditions();
    }

    @And("the user clicks the payment method button")
    public void theUserClicksThePaymentMethodButton() {
        checkoutPage.clickPaymentMethodButton();
    }
}

