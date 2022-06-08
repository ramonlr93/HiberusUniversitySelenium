package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.RegisterSuccessPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class RegisterSuccessPageSteps {
    private PagesFactory pf = PagesFactory.getInstance();
    private RegisterSuccessPage registerSuccessPage = pf.getRegisterSuccessPage();
    private WebDriver driver = pf.getDriver();

    @Then("the user is in the register success")
    public void theUserIsInTheRegisterSuccess() {
        Assert.assertEquals("The user not is in the register success page.", registerSuccessPage.PAGE_URL, driver.getCurrentUrl());
    }
}
