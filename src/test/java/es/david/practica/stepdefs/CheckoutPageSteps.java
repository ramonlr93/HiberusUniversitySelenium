package es.david.practica.stepdefs;

import es.david.practica.pages.CheckoutPage;
import es.david.practica.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckoutPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    CheckoutPage cp = pf.getCheckoutPage();

    @Then("the user is in the checkout")
    public void theUserIsInTheCheckout() {
        Assert.assertEquals("Isn't the checkout page", cp.PAGE_URL, pf.getDriver().getCurrentUrl());
    }

    @When("the user select new adress opcion")
    public void selectAddress() {
        cp.selectNewAddress();
    }

    @And("the user provides a firstname {string}")
    public void enterName(String name) {
        cp.enterFirstName(name);
    }

    @And("the user provides a lastname {string}")
    public void theUserProvidesALastname(String lastname) {
        cp.enterLastname(lastname);
    }

    @And("the user provides a company {string}")
    public void theUserProvidesACompany(String company) {
        cp.enterCompany(company);
    }

    @And("the user provides an address_1 {string}")
    public void theUserProvidesAnAddress_1(String address) {
        cp.enterAddress1(address);
    }

    @And("the user provides an address_2 {string}")
    public void theUserProvidesAnAddress_2(String address) {
        cp.enterAddress2(address);
    }

    @And("the user provides a city {string}")
    public void theUserProvidesACity(String city) {
        cp.enterCity(city);
    }

    @And("the user provices a postalcode {string}")
    public void theUserProvicesAPostalcode(String postalcode) {
        cp.enterPostCode(postalcode);
    }

    @And("the user select a country {string}")
    public void theUserSelectACountry(String country) {
        cp.selectCountry(country);
    }

    @And("the user select a state {string}")
    public void theUserSelectAState(String state) {
        cp.selectRegion(state);
    }

    @And("the user selects the conditions")
    public void theUserSelectsTheConditions() {
        cp.acceptTermsAndConditions();
    }

    @And("the user clicks the confirm button")
    public void theUserClicksTheConfirmButton() {
        cp.confirmButton();
    }

    @And("the user clicks the payment button")
    public void theUserClicksThePaymentButton() {
        cp.clickPaymentButton();
    }

    @And("the user clicks the shipping button")
    public void theUserClicksTheShippingButton() {
        cp.clickShippingButton();
    }

    @And("the user clicks the shipping method button")
    public void theUserClicksTheShippingMethodButton() {
        cp.clickShippingMethodButton();
    }

    @And("the user clicks the payment method button")
    public void theUserClicksThePaymentMethodButton() {
        cp.clickPaymentMethodButton();
    }

}
