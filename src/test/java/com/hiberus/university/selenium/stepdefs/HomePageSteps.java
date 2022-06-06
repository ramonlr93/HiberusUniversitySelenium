package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.HomePage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HomePageSteps {

    @Given("the user is on the home page actual")
    public void theUserIsOnTheHomePage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the Home Page");
        HomePage homePage = pf.getHomePage();
        homePage.navigateTo(HomePage.PAGE_URL);
    }

    @And("Pulso sobre MyAccount")
    public void myAccount() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user is on the Home Page");
        HomePage homePage = pf.getHomePage();
        homePage.clickMyAccount();
    }
}
