package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class CheckoutPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    LoginPage loginPage = pf.getLoginPage();
    InventoryPage inventoryPage = pf.getInventoryPage();
    CartPage cartPage = pf.getCartPage();
    CheckOutStepOnePage checkOutStepOnePage = pf.getCheckOutStepOnePage();
    CheckOutStepTwoPage checkOutStepTwoPage = pf.getCheckOutStepTwoPage();

    @And("the user clicks the checkout button")
    public void clickCheckoutCart() {
        cartPage.clickCheckout();
    }

    @And("the user fills the checkout information {string} ,{string} and {string}")
    public void fillCheckoutInformation(String firstName, String lastname, String postalCode) {
        checkOutStepOnePage.fillInformation(firstName, lastname, postalCode);
    }

    @When("the user clicks the continue button")
    public void clickContinueButton() {
        checkOutStepOnePage.clickContinue();
    }

    @Then("the user see the item total price that is equal to the sum of each item")
    public void itemTotalPrice() {
        Assert.assertEquals("LA SUMA DE LOS PRECIOS DE LOS PRODUCTOS NO ES LA MISMA", checkOutStepTwoPage.cartItemPrice(), checkOutStepTwoPage.itemTotalByNumber());
    }

    @When("the user clicks the finish button")
    public void clickFinishButton() {
        checkOutStepTwoPage.clickFinish();
    }

    @Then("the user see the checkout message")
    public void checkoutMessage() {
        Assert.assertEquals("EL MENSAJE FINAL DEL PEDIDO REALIZADO NO ES EL CORRECTO ",
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!", checkOutStepTwoPage.getFinishMessage());
    }

}