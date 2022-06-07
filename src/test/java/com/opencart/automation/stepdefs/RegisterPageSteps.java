package com.opencart.automation.stepdefs;

import com.opencart.automation.pages.PagesFactory;
import com.opencart.automation.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {

    public static String email, password;
    WebDriver driver;
    private RegisterPage registerPage;


    public RegisterPageSteps() {
        registerPage = PagesFactory.getInstance().getRegisterPage();
    }

    @Given("the user is on the register page")
    public void theUserIsOnTheRegisterPage() {
        registerPage.navigateTo(RegisterPage.PAGE_URL);
    }


    @When("user enter <firstName>, <lastName>, <email>, <telephone>, <password> and <confirmPassword>")
    public void userEntersData(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
        registerPage.enterRegistrationData(firstName, lastName, email, telephone, password, confirmPassword );
    }


    @And("choose if he wants to accept newsletter")
    public void chooseIfHeWantsToAcceptNewsletter() {
        registerPage.acceptingNewsletter();
    }


    @And("agree with privacy policy")
    public void agreeWithPrivacyPolicy() {
        registerPage.acceptingPrivacyPolicy();
    }


    @And("clicks on continue button")
    public void clicksOnContinueButton() {
        registerPage.clickContinue();
    }

    @Then("user should see the success message")
    public void userShouldSeeTheSuccessMessage() {

    }


}




