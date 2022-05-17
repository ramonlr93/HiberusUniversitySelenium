package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class CheckoutSteps {
    @And("the user clicks the cart button")
    public void theUserClicksTheCartButton() {
        InventoryPage inventoryPage = PagesFactory.getInstance().getInventoryPage();
        inventoryPage.goCart();
    }
    Double totalPrice;
    @And("the user does the checkout of the products")
    public void theUserDoesTheCheckoutOfTheProducts() {
        CartPage cartPage = PagesFactory.getInstance().getCartPage();
        totalPrice = cartPage.getTotalPrice();
        cartPage.goCheckout();
    }

    @And("the user fills the checkout form with the values {string}, {string}, {string}")
    public void theUserFillsTheCheckoutFormWithTheValues(String firstName, String lastName, String postalCode) {
        CheckoutOnePage checkoutOnePage = PagesFactory.getInstance().getCheckoutOnePage();
        checkoutOnePage.fillInputs(firstName, lastName, postalCode);
    }

    @When("the user continues to the second step")
    public void theUserContinuesToTheSecondStep() {
        CheckoutOnePage checkoutOnePage =  PagesFactory.getInstance().getCheckoutOnePage();
        checkoutOnePage.continueCheckout();
    }
    @Then("the total price of the order is the correct")
    public void theTotalPriceOfTheOrderIsTheCorrect() {
        CheckoutTwoPage checkoutTwoPage = PagesFactory.getInstance().getCheckoutTwoPage();
        assertEquals("PRUEBA FALLIDA: el precio esta mal calculado", totalPrice, checkoutTwoPage.getItemsTotalPriceByPage());
    }

    @When("the user ends the checkout")
    public void theUserEndsTheCheckout() {
        CheckoutTwoPage checkoutTwoPage = PagesFactory.getInstance().getCheckoutTwoPage();
        checkoutTwoPage.finishCheckout();
    }
    @Then("the page redirect to the confirmation order page and sees the text {string}")
    public void thePageRedirectToTheConfirmationOrderPageAndSeesTheText(String confirmationOrderMessage) {
        CheckoutComplete checkoutComplete = PagesFactory.getInstance().getCheckoutComplete();
        assertEquals(
                "PRUEBA FALLIDA: No se ha finalizado correctamente la compra",
                confirmationOrderMessage,
                checkoutComplete.getCompletedOrderText()
        );
    }
}
