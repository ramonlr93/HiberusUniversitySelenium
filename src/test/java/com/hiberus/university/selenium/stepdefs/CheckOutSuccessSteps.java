package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CheckOutPage;
import com.hiberus.university.selenium.pages.CheckOutSuccessPage;
import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CheckOutSuccessSteps {
    private PagesFactory pf = PagesFactory.getInstance();
    private CheckOutSuccessPage checkOutSuccessPage = pf.getCheckOutSuccessPage();
    private WebDriver driver = pf.getDriver();


    @Then("the user is in the checkout success page")
    public void theUserIsInTheCheckoutSuccessPage() {
        Assert.assertEquals("The user is not in the checkout success page", checkOutSuccessPage.PAGE_URL, driver.getCurrentUrl());

    }
}
