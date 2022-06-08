package com.opencart.automation.stepdefs;

import com.opencart.automation.pages.PagesFactory;
import com.opencart.automation.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class RegisterPageSteps {


    WebDriver driver;
    private final RegisterPage registerPage;

    public RegisterPageSteps() {
        registerPage = PagesFactory.getInstance().getRegisterPage();
    }


    @Given("the user is on the register page")
    public void theUserIsOnTheRegisterPage() {
        registerPage.navigateTo(RegisterPage.PAGE_URL);
    }
    @And("user enter {string}, {string}, {string}, {string}, {string}")
    public void userEnterData(String firstName, String lastName, String email, String telephone, String password) {
        registerPage.enterRegistrationData(firstName, lastName, email, telephone, password, password );
    }

    @And("choose if he wants to accept newsletter")
    public void chooseIfHeWantsToAcceptNewsletter() {
        registerPage.acceptingNewsletter();
    }


    @And("agree with privacy policy")
    public void agreeWithPrivacyPolicy() {
        registerPage.acceptingPrivacyPolicy();
    }


    @When("clicks on continue button")
    public void clicksOnContinueButton() {
        registerPage.clickContinue();
    }

    @Then("user should see the success message")
    public void userShouldSeeTheSuccessMessage() {
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        assertEquals("The account not has been created", "http://opencart.abstracta.us/index.php?route=account/success", currentUrl);

    }

    @Then("user should see error message, account already registered")
    public void aAccountAlreadyRegistered() {
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        assertEquals("Account was created", RegisterPage.PAGE_URL, currentUrl);
    }
}




