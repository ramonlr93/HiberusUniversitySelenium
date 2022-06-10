package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.MyAccountPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.pages.RegisterSuccessPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MyAccountPageSteps {
    private PagesFactory pf = PagesFactory.getInstance();
    private MyAccountPage myAccountPage = pf.getMyAccountPage();
    private WebDriver driver = pf.getDriver();

    @Then("the user is in the MyAccount page")
    public void theUserIsInTheMyAccountPage() {
        Assert.assertEquals("The user not is in the My Account page.", myAccountPage.PAGE_URL, driver.getCurrentUrl());
    }

}
