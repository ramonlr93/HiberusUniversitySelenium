package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CheckoutInformationPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.nio.channels.ClosedChannelException;

public class CheckoutInformationPageSteps {

    PagesFactory pf = PagesFactory.getInstance();
    CheckoutInformationPage checkoutInformationPage = pf.getCheckoutInformationPage();

    @And("the user fills the field name {string}")
    public void fillInputFirstName(String name) {
        checkoutInformationPage.enterFirstName(name);
    }

    @And("the user fills the field lastname {string}")
    public void fillInputLastName(String lastname) {
        checkoutInformationPage.enterLastName(lastname);
    }

    @And("the user fills the field zipcode {string}")
    public void fillInputZipCode(String zipcode) {
        checkoutInformationPage.postalCodeInput(zipcode);
    }

    @Then("the user clicks the continue button")
    public void theUserClicksTheContinueButton() {
        checkoutInformationPage.clickContinue();
    }

    @And("the user is in the checkout overview page")
    public void theUserIsInTheCheckoutOverviewPage() {
        Assert.assertEquals("The user isnt in the correct url"
                , pf.getCheckoutOverviewPage().PAGE_URL, pf.getDriver().getCurrentUrl());
    }
}
