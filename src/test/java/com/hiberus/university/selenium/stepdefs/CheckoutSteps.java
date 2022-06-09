package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.BasePage;
import com.hiberus.university.selenium.pages.CheckoutPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class CheckoutSteps {
    PagesFactory pf = PagesFactory.getInstance();
    BasePage basePage = pf.getBasePage();
    CheckoutPage checkoutPage = pf.getCheckoutPage();

    @And("the user clicks the checkout button")
    public void clickCheckoutButton() {
        basePage.clickCheckout();
    }
    @And("the user checks as guest")
    public void checkGuest() {
        checkoutPage.clickGuest();
    }

    @And("the user clicks the continue to account button")
    public void clicksContinueAccountButton() {
        checkoutPage.clickContinueCostumer();
    }

    @And("the user provides the firstName {string}, the lastName {string}, the email {string} and the telephone {string} details")
    public void accountPersonDetails(String firstName, String lastName, String email, String telephone) {
        log.info("The user provides the Personal Details");
        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterEmail(email);
        checkoutPage.enterTelephone(telephone);
    }
    @And("the user provides the address {string}, the city {string}, the post code {string}, the country {string} and the region {string}")
    public void accountBillingDetails(String address, String city, String postCode, String country, String region) {
        checkoutPage.enterAddress(address);
        checkoutPage.enterCity(city);
        checkoutPage.enterPostCode(postCode);
        checkoutPage.clickCountry(country);
        checkoutPage.clickRegion(region);
    }

    @And("the user click the button to continue to delivery details")
    public void clickContinueDeliveryDetails() {
        checkoutPage.clickContinueAddress();
    }

    @And("the user click the button to continue to payment methods if delivery method appear")
    public void clickContinueShippingMethod() {
        checkoutPage.clickContinueShippingMethod();
    }

    @And("the user clicks on the check of the Term conditions")
    public void clicksCheckTermConditions() {
        checkoutPage.clickTermConditions();
    }

    @And("the user clicks on the continue in payment method")
    public void clickContinuePaymentMethod() {
        checkoutPage.clickContinuePaymentMethod();
    }

    @When("the user clicks on the confirm checkout button")
    public void clicksConfirmCheckoutButton() {
        checkoutPage.clickConfirmOrder();
    }

    @Then("the user sees a message that the order has been placed")
    public void validateOrderConfirmed() {
        Assert.assertTrue(checkoutPage.orderConfirmMessage());
    }

    @When("the user clicks on the continue in payment method section")
    public void clickContinuePaymentMethodError() {
        checkoutPage.clickContinuePaymentMethod();
    }
    @Then("a warning message appear on the top of the section")
    public void warningMessageAppear() {
        log.info("The user should be shown an warning message of the Term Conditions");
        Assert.assertTrue(checkoutPage.hasTermConditionsError());
    }

    @When("the user click the button to continue to delivery details section")
    public void clickButtonContinueDeliveryDetails() {
        checkoutPage.clickContinueAddress();
    }

    @Then("a message appear on the field of the details that is invalid")
    public void invalidFieldMessage() {
        log.info(checkoutPage.errorMessageDisplay());
        Assert.assertTrue(checkoutPage.errorMessageDisplay()!=null);
    }
}
