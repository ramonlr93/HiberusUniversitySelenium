package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class CheckoutSteps {
    @Given("the user is logged, added an item and in the checkout page")
    public void theUserIsLoggedAddedAnItemAndInTheChekoutPage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Going to checkout page");
        LoginPage loginPage = pf.getLoginPage();
        UserPage userPage = pf.getUserPage();
        MobileDevicesPage mobileDevicesPage=pf.getMobileDevicesPage();
        MainInventoryPage mainInventoryPage = pf.getMainInventoryPage();
        loginPage.navigateTo(LoginPage.PAGE_URL);
        loginPage.fillEmail("ojmeneses@hiberus.com");
        loginPage.fillPassword("encryptedPass");
        loginPage.clickOnLogin();
        userPage.clickOnHomePage();
        mainInventoryPage.clickOnPhonesAndPDAS();
        mobileDevicesPage.clickOnHTC();
        mobileDevicesPage.goToCart();
    }
    @And("the user fills Billing Details by default")
    public void theUserFillsBillingDetailsByDefault() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage=pf.getCheckoutPage();
        checkoutPage.fillBillingDetails();
    }
    @And("the user leaves the existing billing details address for delivery")
    public void theUserLeavesTheExistingBillingDetailsAddressForDelivery() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage=pf.getCheckoutPage();
        checkoutPage.fillDeliveryDetails();
    }
    @And("the user fills {string} into the text area")
    public void theUserFillsIntoTheTextArea(String comments) {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage=pf.getCheckoutPage();
        checkoutPage.fillDeliveryComments(comments);
    }
    @And("the user clicks on continue button")
    public void theUserClicksOnContinueButton() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage=pf.getCheckoutPage();
        checkoutPage.clickDelMthd();
    }

    @And("the user leaves Bank transfer payment method by default and clicks on agreement checkbox")
    public void theUserLeavesBankTransferPaymentMethodByDefaultAndClicksOnAgreementCheckbox() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage=pf.getCheckoutPage();
        checkoutPage.checkAgrmnt();
    }
    @And("clicks on continue button")
    public void clicksOnContinueButton() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage=pf.getCheckoutPage();
        checkoutPage.payMthdClick();
    }
    @And("clicks on Confirm Order")
    public void clicksOnConfirmOrder() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage=pf.getCheckoutPage();
        checkoutPage.confirmOrder();
    }
    @Then("order confirmed is displayed on the {string}")
    public void orderConfirmedIsDisplayedOnThe(String url) {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage=pf.getCheckoutPage();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals("Order confirmed", url, checkoutPage.orderConfirmed());
    }
}