package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class MobileDevicesSteps {
    @Given("the user is logged and in the mobile devices page")
    public void theUserIsLoggedAndInTheMobileDevicesPage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Going to mobile devices page");
        LoginPage loginPage = pf.getLoginPage();
        UserPage userPage = pf.getUserPage();
        MainInventoryPage mainInventoryPage = pf.getMainInventoryPage();
        loginPage.navigateTo(LoginPage.PAGE_URL);
        loginPage.fillEmail("ojmeneses@hiberus.com");
        loginPage.fillPassword("encryptedPass");
        loginPage.clickOnLogin();
        userPage.clickOnHomePage();
        mainInventoryPage.clickOnPhonesAndPDAS();
    }
    @When("user clicks on the add to cart button")
    public void userClicksOnTheAddToCartButton() throws InterruptedException {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Clicking on the HTC device add to cart button");
        MobileDevicesPage mobileDevicesPage= pf.getMobileDevicesPage();
        mobileDevicesPage.clickOnHTC();
        Thread.sleep(2000);

    }
    @Then("the cart icon at the top right displays {string} and price item added")
    public void theCartIconAtTheTopRightDisplaysAndItemAdded(String number) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Validating item is added to cart");
        MobileDevicesPage mobileDevicesPage= pf.getMobileDevicesPage();
        Assert.assertEquals("Item not added to cart",number,mobileDevicesPage.numberOfItemsAdded());
    }
    @And("user clicks on ckeckout button")
    public void userClicksOnCkeckoutButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Clicking to checkout webpage");
        MobileDevicesPage mobileDevicesPage= pf.getMobileDevicesPage();
        mobileDevicesPage.goToCart();
    }
    @Then("checkout webpage {string} is displayed")
    public void checkoutWebpageIsDisplayed(String checkoutPage) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("Validating checkout page is displayed");
        MobileDevicesPage mobileDevicesPage= pf.getMobileDevicesPage();
        Assert.assertEquals("Checkout page not displayed", checkoutPage, mobileDevicesPage.currentWebPage());
        mobileDevicesPage.navigateTo(MobileDevicesPage.PAGE_URL);
        mobileDevicesPage.delProduct();
    }
}
