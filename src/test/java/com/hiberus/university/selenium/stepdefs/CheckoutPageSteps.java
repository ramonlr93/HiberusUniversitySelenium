package com.hiberus.university.selenium.stepdefs;


import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.CheckoutPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.List;

@Slf4j
public class CheckoutPageSteps {
    private PagesFactory pf = PagesFactory.getInstance();

    @And("the user click checkout button")
    public void clickCheckoutButton() {
        CartPage cartPage = pf.getCartPage();
        cartPage.clickCheckout();
    }

    @And("the user choose the billing details and click continue")
    public void theUserChooseTheBillingDetails(DataTable billingDetails) {
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        List<String> details = billingDetails.asList(String.class);
        try {
            checkoutPage.enterDatesPayment(details);

        }catch (Exception address){
            checkoutPage.newAdressRadioClick();
            checkoutPage.enterDatesPayment(details);
        }
        checkoutPage.continueAdressButtonClick("payment");
    }

    @And("the user choose the delibery details and click continue")
    public void theUserClicksTheContinuePaymentButton() {
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.selectedAddressFinalDelivery();
        checkoutPage.continueAdressButtonClick("shipping");
    }

    @And("the user choose the delibery method, add comments and click continue")
    public void theUserChooseTheDeliberyMethod() {
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.addCommentToOrder();
        checkoutPage.continueMethodButtonClick("shipping");
    }

    @And("the user choose the payment {string} method, checked checkbox and click continue")
    public void theUserChooseTheMethod(String method) {
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        RegisterPage registerPage = pf.getRegisterPage();

        checkoutPage.selectedPaymentMethod(method);
        registerPage.checkedCheckbox();
        checkoutPage.continueMethodButtonClick("payment");
    }

    @When("the user clicks the confirm order")
    public void theUserClicksTheConfirmOrder() {
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.confirmOrderButtonClick();
    }

    @Then("the order has been completed successfully and the message has been displayed")
    public void theOrderHasBeenCompletedSuccessfullyAndTheMessageHasBeenDisplayed() {
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        Assert.assertTrue("PRUEBA FALLIDA - El pedido no ha finalizado correctamente",
                checkoutPage.textSucessfullyIsPresent());
    }
}
