package com.hiberus.university.opencart.stepdefs;

import com.hiberus.university.opencart.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Slf4j
public class CheckoutPageSteps {

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.navigateTo(CheckoutPage.PAGE_URL);
    }

    @And("the user enter the first name payment {string} on checkout page")
    public void theUserEnterTheFirstNamePaymentCheckout(String first_name_payment) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the first name payment on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.enterFirstNamePaymentCheckout(first_name_payment);
    }

    @And("the user enter the last name payment {string} on checkout page")
    public void theUserEnterTheLastNamePaymentCheckout(String last_name_payment) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the last name payment on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.enterLastNamePaymentCheckout(last_name_payment);
    }

    @And("the user enter the company payment {string} on checkout page")
    public void theUserEnterTheCompanyPaymentCheckout(String company_payment) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the company payment on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.enterCompanyPaymentCheckout(company_payment);
    }

    @And("the user enter the address1 payment {string} on checkout page")
    public void theUserEnterTheAddress1PaymentCheckout(String address1_payment) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the address1 payment on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.enterAddress1PaymentCheckout(address1_payment);
    }

    @And("the user enter the address2 payment {string} on checkout page")
    public void theUserEnterTheAddress2PaymentCheckout(String address2_payment) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the address2 payment on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.enterAddress2PaymentCheckout(address2_payment);
    }

    @And("the user enter the city payment {string} on checkout page")
    public void theUserEnterTheCityPaymentCheckout(String city_payment) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the city payment on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.enterCityPaymentCheckout(city_payment);
    }

    @And("the user enter the post code payment {string} on checkout page")
    public void theUserEnterThePostCodePaymentCheckout(String post_code_payment) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the post code payment on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.enterPostCodePaymentCheckout(post_code_payment);
    }

    @And("the user selects a country payment {string} on checkout page")
    public void theUserSelectsACountryPaymentCheckout(String country_payment) {
        log.info("the user selects a country payment " + country_payment + " on checkout page");
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.selectCountryPaymentByName(country_payment);
    }

    @And("the user selects a zone payment {string} on checkout page")
    public void theUserSelectsAZonePaymentCheckout(String zone_payment) {
        log.info("the user selects a zone payment " + zone_payment + " on checkout page");
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.selectZonePaymentByName(zone_payment);
    }

    @And("the user enter the first name shipping {string} on checkout page")
    public void theUserEnterTheFirstNameShippingCheckout(String first_name_shipping) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the first name shipping on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.enterFirstNameShippingCheckout(first_name_shipping);
    }

    @And("the user enter the last name shipping {string} on checkout page")
    public void theUserEnterTheLastNameShippingCheckout(String last_name_shipping) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the last name shipping on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.enterLastNameShippingCheckout(last_name_shipping);
    }

    @And("the user enter the company shipping {string} on checkout page")
    public void theUserEnterTheCompanyShippingCheckout(String company_shipping) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the company shipping on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.enterCompanyShippingCheckout(company_shipping);
    }

    @And("the user enter the address1 shipping {string} on checkout page")
    public void theUserEnterTheAddress1ShippingCheckout(String address1_shipping) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the address1 shipping on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.enterAddress1ShippingCheckout(address1_shipping);
    }

    @And("the user enter the address2 shipping {string} on checkout page")
    public void theUserEnterTheAddress2ShippingCheckout(String address2_shipping) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the address2 shipping on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.enterAddress2ShippingCheckout(address2_shipping);
    }

    @And("the user enter the city shipping {string} on checkout page")
    public void theUserEnterTheCityShippingCheckout(String city_shipping) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the city shipping on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.enterCityShippingCheckout(city_shipping);
    }

    @And("the user enter the post code shipping {string} on checkout page")
    public void theUserEnterThePostCodeShippingCheckout(String post_code_shipping) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user enter the post code shipping on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.enterPostCodeShippingCheckout(post_code_shipping);
    }

    @And("the user selects a country shipping {string} on checkout page")
    public void theUserSelectsACountryShippingCheckout(String country_shipping) {
        log.info("the user selects a country shipping " + country_shipping + " on checkout page");
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.selectCountryShippingByName(country_shipping);
    }

    @And("the user selects a zone shipping {string} on checkout page")
    public void theUserSelectsAZoneShippingCheckout(String zone_shipping) {
        log.info("the user selects a zone shipping " + zone_shipping + " on checkout page");
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.selectZoneShippingByName(zone_shipping);
    }

    @And("the user clicks the payment address continue button on checkout page")
    public void theUserClicksThePaymentContinueButtonCheckout() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the payment address continue button on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickPaymentAddressContinue();
    }

    @And("the user clicks the shipping address continue button on checkout page")
    public void theUserClicksTheShippingAddressContinueButtonCheckout() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the shipping address continue button on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickShippingAddressContinue();
    }

    @And("the user clicks the payment shipping method continue button on checkout page")
    public void theUserClicksTheShippingMethodContinueButtonCheckout() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the payment shipping method continue button on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickShippingMethodContinue();
    }

    @And("the user checks the terms and conditions button on checkout page")
    public void theUserChecksTheTermsAndConditionsButtonCheckout() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user checks the terms and conditions button on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.checkTermsAndConditions();
    }

    @And("the user clicks the payment method continue button on checkout page")
    public void theUserClicksThePaymentMethodContinueButtonCheckout() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the payment method continue button on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickPaymentMethodContinue();
    }

    @And("the user clicks the new payment address button on checkout page")
    public void theUserClicksTheNewPaymentAddressButtonCheckout() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the new payment address button on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickNewPaymentAddressButtonCheckout();
    }

    @And("the user clicks the new shipping address button on checkout page")
    public void theUserClicksTheNewShippingAddressButtonCheckoutCheckout() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the new shipping address button on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickNewShippingAddressButtonCheckout();
    }

    @When("the user clicks the confirm order button on checkout page")
    public void theUserClicksTheConfirmOrderButtonCheckout() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the confirm order method button on checkout page");
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickConfirmOrder();
    }

    @Then("the user clicks the continue button on checkout success page")
    public void theUserClicksTheContinueButtonCheckoutSuccess() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user clicks the continue button on checkout success page");
        CheckoutSuccessPage checkoutSuccessPage = pf.getCheckoutSuccessPage();
        checkoutSuccessPage.clickContinue();
    }
}
