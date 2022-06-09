package com.hiberusuniversity.openCart.stepdefs;

import com.hiberusuniversity.openCart.pages.CartPage;
import com.hiberusuniversity.openCart.pages.CheckoutPage;
import com.hiberusuniversity.openCart.pages.HomePage;
import com.hiberusuniversity.openCart.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class CheckoutSteps {
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    CartPage cartPage = pf.getCartPage();
    CheckoutPage checkoutPage = pf.getCheckoutPage();
    WebDriverWait wait = new WebDriverWait(pf.getDriver(), 10);
    float precio = 0;

    @And("the user adds one product to the cart {string} and the user click the cart section")
    public void theUserAddsProductToTheCart(String product) {
        homePage.addProducts(product);
        homePage.clickCartSection();
    }

    @And("the user click the checkout button")
    public void theUserClickTheCheckoutButton() {
        precio = cartPage.totalCart();
        System.out.println(""+precio);
        cartPage.clickCheckoutButton();
    }


    @And("the user enter his email {string} and password {string} and logs in")
    public void theUserEnterHisEmailAndPasswordAndLogsIn(String email, String password) {
        checkoutPage.loginCheckout(email,password);
    }

    @And("the user uses a already created billing address")
    public void theUserUsesAAlreadyCreatedAddress() {
        checkoutPage.clickButtonBillingAddress();
    }

    @And("the user uses a already created delivery address")
    public void theUserUsesAAlreadyCreatedDeliveryAddress() {
        checkoutPage.clickButtonDeliveryAddress();
    }

    @And("the user select the delivery method")
    public void theUserSelectTheDeliveryMethod() {
        checkoutPage.clickButtonShipping();
    }

    @And("the user select the payment method")
    public void theUserSelectThePaymentMethod() {
        checkoutPage.clickButtonPayment();
    }

    @When("the user confirms the order")
    public void theUserConfirmsTheOrder() {
        checkoutPage.clickButtonConfirm();
    }

    @Then("The user get redirected to a page with a message that his order was successful {string}")
    public void theUserGetRedirectedToAPageWithAMessageThatHisOrderWasSuccessful(String url) {
        wait.until(ExpectedConditions.elementToBeClickable(pf.getDriver().findElement(By.xpath("//a[contains(text(),'Continue')]"))));
        Assert.assertEquals("The order was not correct",url,pf.getDriver().getCurrentUrl());
    }

    @And("the user uses selects to create a new billing address")
    public void theUserUsesSelectsToCreateANewBillingAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.getInputRadioPayment())).click();
    }

    @And("the user introduces his info {string} {string} {string} {string} {string} {string} for the new billing address")
    public void theUserIntroducesHisInfoForTheNewBillingAddress(String name, String lastname, String address, String city, String country, String zone) {
        checkoutPage.createBillingDetails(name,lastname,address,city,country,zone);
    }

    @And("the user uses selects to create a new delivery address")
    public void theUserUsesSelectsToCreateANewDeliveryAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutPage.getInputRadioAddress())).click();
    }

    @And("the user introduces his info {string} {string} {string} {string} {string} {string} {string} for the new delivery address")
    public void theUserIntroducesHisInfoForTheNewDeliveryAddress(String name, String lastname, String address, String city,String postcode, String country, String zone) {
        checkoutPage.createDeliveyDetails(name,lastname,address,city,postcode,country,zone);

    }


    @And("the user select to use a guest checkout")
    public void theUserSelectToUseAGuestCheckout() {
        checkoutPage.checkGuestCheckout();
    }

    @And("the user introduces his info {string} {string} {string} {string} {string} {string} {string} {string} for the new billing address")
    public void theUserIntroducesHisInfoForTheNewBillingAddress(String name, String lastname,String email,String telephone,String address, String city, String country, String zone) {
        checkoutPage.createBillingDetailsGuest(name,lastname,email,telephone,address,city,country,zone);
    }
}
