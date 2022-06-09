package com.practicafinal.stepdefs;

import com.practicafinal.pages.CheckoutPage;
import com.practicafinal.pages.PagesFactory;
import com.practicafinal.support.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import com.practicafinal.pages.HomePage;

@Slf4j
public class CheckoutPageSteps {

    PagesFactory pf = PagesFactory.getInstance();
    HomePage hp = pf.getHomepage();
    CheckoutPage chp = pf.getCheckoutpage();

    @And("the user clicks on checkout button")
    public void theUserClicksOnCheckoutButton() {
        hp.goToCheckout();
    }

    @And("the user clicks the login button to checkout")
    public void theUserClicksTheLoginButtonToCheckout() {
        chp.loginToCheckout();
    }

    @And("the user selects add new data")
    public void theUserSelectsAddNewData() {
        chp.selectNewData();
    }

    @And("the user fills the form")
    public void theUserFillsTheForm(DataTable data) {
        chp.fillForm1(data);
    }

    @And("the user fills the form again")
    public void theUserFillsTheFormAgain(DataTable data) {
        chp.fillFormAgain(data);
    }

    @When("the user clicks continue on the methods and confirm the order")
    public void theUserClicksContinueOnTheMethodsAndConfirmTheOrder() {
        chp.finishOrder();
    }


    @When("the user clicks on the continue buttons")
    public void theUserClicksOnTheContinueButtons()  {
        chp.madeOrderWithSaveData();
    }

    @Then("the order is completed correctly and redirect to {string}")
    public void theOrderIsCompletedCorrectlyAndRedirectTo(String url) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals("the url is not hte same",url, Hooks.driver.getCurrentUrl());
    }

    @And("the user select made the checkout as guest")
    public void theUserSelectMadeTheCheckoutAsGuest() {
        chp.selectMadeAsGuest();
    }

    @And("the user fills the form as guest")
    public void theUserFillsTheFormAsGuest(DataTable data) throws InterruptedException {
        chp.fillFormAsGuest(data);
    }

    @When("the user finish the checkout as guest")
    public void theUserFinishTheCheckoutAsGuest() {
        chp.finishOrderAsGuest();
    }
}
