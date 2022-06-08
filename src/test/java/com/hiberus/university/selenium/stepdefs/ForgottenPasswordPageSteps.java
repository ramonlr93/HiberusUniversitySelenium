package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.ForgottenPasswordPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.RegisterSuccessPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ForgottenPasswordPageSteps {
    private PagesFactory pf = PagesFactory.getInstance();
    private ForgottenPasswordPage forgottenPasswordPage = pf.getForgottenPasswordPage();
    private WebDriver driver = pf.getDriver();

    @Then("the user is in the Forgotten Password page")
    public void theUserIsInTheForgottenPasswordPage() {
        Assert.assertEquals("The user not is in the register success page.", forgottenPasswordPage.PAGE_URL, driver.getCurrentUrl());
    }
}
