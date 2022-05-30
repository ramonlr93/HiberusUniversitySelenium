package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CheckoutInformationPage;
import com.hiberus.university.selenium.pages.CheckoutOverviewPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckoutOverviewPageSteps {

    PagesFactory pf = PagesFactory.getInstance();
    CheckoutOverviewPage checkoutOverviewPage = pf.getCheckoutOverviewPage();

    @Then("the total price of the order is the sum of the amount of the items selected in the inventory")
    public void theTotalPriceIsTheSum() {
        String itemTotal = checkoutOverviewPage.getItemTotal().substring(13);
        Assert.assertEquals("The total price isnt the same", itemTotal , checkoutOverviewPage.getSumPrices().toString());
    }

    @When("the user clicks the finalice button")
    public void theUserClicksTheFinaliceButton() {
        checkoutOverviewPage.clickFnishButton();
    }

    @Then("validate the checkout is correct showing the {string}")
    public void validateOrder(String message) {
        Assert.assertEquals("The message isnt shown"
                , pf.getCheckoutCompletePage().getMessage()
                , message);
    }
}
