package com.practicafinal.stepdefs;

import com.practicafinal.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import com.practicafinal.pages.HomePage;

import static com.practicafinal.support.Hooks.driver;


@Slf4j
public class HomePageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    HomePage hp = pf.getHomepage();


    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        hp.navigateTo(HomePage.PAGE_URL);
        Assert.assertEquals("the url is not the same", HomePage.PAGE_URL, driver.getCurrentUrl());
    }

    @And("the user clicks on my account button and the register option")
    public void theUserClicksOnMyAccountButtonAndTheRegisterOption() {
        hp.goToRegister();
    }



    @And("the user clicks on my account button and the login option")
    public void theUserClicksTheLoginButton() {
        hp.goToLogin();
    }

}
