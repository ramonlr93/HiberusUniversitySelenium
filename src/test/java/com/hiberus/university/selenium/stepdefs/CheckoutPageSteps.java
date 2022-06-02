package com.hiberus.university.selenium.stepdefs;


import com.hiberus.university.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class CheckoutPageSteps {

    @When("click checkout button")
    public void clickCheckoutButton() {
        PagesFactory pf = PagesFactory.getInstance();
        CartPage cartPage = pf.getCartPage();
        cartPage.clickCheckout();
    }

    @And("And the user provides the firstName {string}")
    public void andTheUserProvidesTheFirstName(String firstName) {
        PagesFactory pf = PagesFactory.getInstance();
        CheckOutStepOnePage checkOutStepOnePage = pf.getCheckOutStepOnePage();
        checkOutStepOnePage.enterFirstName(firstName);
    }

    @And("the user provides the lastName {string}")
    public void theUserProvidesTheLastName(String lastName) {
        PagesFactory pf = PagesFactory.getInstance();
        CheckOutStepOnePage checkOutStepOnePage = pf.getCheckOutStepOnePage();
        checkOutStepOnePage.enterLastName(lastName);
    }

    @And("the user provides the postalCode {string}")
    public void theUserProvidesThePostalCode(String postalCode) {
        PagesFactory pf = PagesFactory.getInstance();
        CheckOutStepOnePage checkOutStepOnePage = pf.getCheckOutStepOnePage();
        checkOutStepOnePage.enterPostalCode(postalCode);
    }

    @And("click continue button")
    public void clickContinueButton() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckOutStepOnePage checkOutStepOnePage = pf.getCheckOutStepOnePage();
        checkOutStepOnePage.clickContinue();
    }

    @Then("the item total is equal to the sum of quantities")
    public void theItemTotalIsEqualToTheSumOfQuantities() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckOutStepTwoPage checkOutStepTwoPage = pf.getCheckOutStepTwoPage();
        Assert.assertEquals("PRUEBA FALLIDA - La suma total de los productos no son iguales",
                checkOutStepTwoPage.getItemsSum(), checkOutStepTwoPage.getItemTotal());
    }

    @When("click finish button")
    public void clickFinishButton() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckOutStepTwoPage checkOutStepTwoPage = pf.getCheckOutStepTwoPage();
        checkOutStepTwoPage.clickFinish();
    }

    @Then("the order has been completed successfully and the message has been displayed")
    public void theOrderHasBeenCompletedSuccessfullyAndTheMessageHasBeenDisplayed() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckOutCompletePage checkOutCompletePage = pf.getCheckOutCompletePage();
        Assert.assertTrue("PRUEBA FALLIDA - El pedido no ha finalizado correctamente",
                checkOutCompletePage.textCompleteIsPresent());
    }
}
