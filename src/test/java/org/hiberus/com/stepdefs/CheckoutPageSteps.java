package org.hiberus.com.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.hiberus.com.pages.CheckoutPage;
import org.hiberus.com.pages.OrderPlacedPage;
import org.hiberus.com.pages.PagesFactory;
import org.junit.Assert;

@Slf4j
public class CheckoutPageSteps  {

    @And ("the user clicks the new address radio button")
    public void theUserClicksNewAddressRadioButton(){
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickNewAddressRadioButton();
    }

    @And("the user introduces his address: {string}, {string}, {string}, {string}, {string}")
    public void theUserIntroducesPersonalInformation(String firstName, String lastName,
                                                     String address, String city, String postCode) {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.introducesPersonalInformation(firstName,lastName, address, city, postCode);
    }

    @And("the user select his country {string} and region {string}")
    public void theUserSelectHisCountry(String optionCountry, String optionRegion) {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.selectCountry(optionCountry);
        checkoutPage.selectZone(optionRegion);
    }

    @And("the user clicks continueButton step 2")
    public void theUserClicksContinueButtonStep2() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickContinueButton01();
    }

    @And("the user clicks continueButton step 3")
    public void theUserClicksContinueButtonStep3() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickContinueButton02();
    }

    @And("the user clicks continueButton step 4")
    public void theUserClicksContinueButtonStep4() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickContinueButton03();
    }

    @And("the user clicks cod radioButton")
    public void theUserClicksCODRadioButton(){
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickCashOnDeliveryRadioButton();
    }

    @And("the user clicks conditions checkbox")
    public void theUserClicksConditionsCheckbox(){
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickConditionsCheckbox();
    }

    @And("the user clicks continueButton step 5")
    public void theUserClicksContinueButtonStep5() {
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickContinueButton04();
    }

    @And("the user clicks confirm order button")
    public void theUserClicksConfirmOrderButton(){
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        checkoutPage.clickConfirmButton();
    }

    @Then("the user see the Order Placed Page")
    public void theUserSeeOrderPlacedPage() throws InterruptedException {
        log.info("the user see Order Placed Page");
        PagesFactory pf = PagesFactory.getInstance();
        OrderPlacedPage orderPlacedPage = pf.getOrderPlacedPage();
        orderPlacedPage.waitForPageLoad();
        // String orderPlacePage = OrderPlacedPage.PAGE_URL;
        // Thread.sleep(5000);
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not Order Placed Page", OrderPlacedPage.PAGE_URL, currentUrl);
    }

}
