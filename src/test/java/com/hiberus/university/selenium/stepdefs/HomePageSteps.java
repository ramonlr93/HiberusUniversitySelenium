package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.HomePage;
import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.utils.AccountOptionsClass.*;
import com.hiberus.university.selenium.utils.NavBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;

public class HomePageSteps {

    private HomePage homePage;

    public HomePageSteps() {
        homePage = PagesFactory.getInstance().getHomePage();
    }

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        homePage.navigateTo(HomePage.HOME_PAGE_URL);
    }

    @And("the user clicks on the my account button")
    public void theUserClicksOnTheMyAccountButton() {
        homePage.clickTopNavBarOption(NavBar.MY_ACCOUNT);
    }

    @And("the user clicks on the login option")
    public void theUserClicksOnTheLoginOption() {
        homePage.clickAccountOption(UnLoggedAccount.LOGIN);
    }

    @Then("the user sees on the menu, on my account, all the logged in options")
    public void theUserSeesOnTheMenuOnMyAccountAllTheLoggedInOptions() {
        homePage.clickTopNavBarOption(NavBar.MY_ACCOUNT);
        for (String option : homePage.getMyAccountOptions())
            Assert.assertTrue(
                    "Las opciones no son las adecuadas [" + option + "]",
                    Arrays.stream(LoggedAccount.values()).anyMatch(loggedOption -> loggedOption.value().equals(option)) // Contains
            );
    }

    @And("the user clicks on the register option")
    public void theUserClicksOnTheRegisterOption() {
        homePage.clickAccountOption(UnLoggedAccount.REGISTER);
    }
}
