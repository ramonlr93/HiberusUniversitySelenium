package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

    private LoginPage loginPage;

    public LoginPageSteps() {
        loginPage = PagesFactory.getInstance().getLoginPage();
    }

    @When("the user introduces {string} as email")
    public void theUserIntroducesAsEmail(String email) {
        loginPage.enterEmail(email);
    }

    @And("the user introduces {string} as password")
    public void theUserIntroducesAsPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        loginPage.clickLoginButton();
    }
}
