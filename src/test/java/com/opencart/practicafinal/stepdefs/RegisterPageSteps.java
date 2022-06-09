package com.opencart.practicafinal.stepdefs;



import com.opencart.practicafinal.pages.BasePage;
import com.opencart.practicafinal.pages.HomePage;
import com.opencart.practicafinal.pages.PagesFactory;
import com.opencart.practicafinal.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegisterPageSteps {


    PagesFactory pf = PagesFactory.getInstance();
    BasePage bp = pf.getBasePage();
    RegisterPage registerPage = pf.getRegisterPage();
    HomePage hp = pf.getHomePage();


    @Given("the user is in the register page")
    public void userInLandingPage() {
        hp.navigateTo(RegisterPage.PAGE_URL);
    }

    @And("the user provides the firstname {string}")
    public void theUserProvidesTheFirstname(String firstname) { registerPage.enterFirstname(firstname);
    }

    @And("the user provides the lastname {string}")
    public void theUserProvidesTheLastname(String lastname) { registerPage.enterLastname(lastname);
    }

    @And("the user provides the telephone {string}")
    public void theUserProvidesTheTelephone(String telephone) { registerPage.enterTelephone(telephone);
    }
    @And("the user provides the pass {string}")
    public void theUserProvidesThePass(String password) { registerPage.enterPassword(password);
    }

    @And("the user clicks the confirm {string}")
    public void theUserProvidesTheConfirm(String confirm) { registerPage.enterConfirm(confirm);
    }

    @And("the user clicks on privacy button")
    public void theUserClicksOnPrivacyButton() {
        registerPage.clickPrivacy();
    }

    @When("the user clicks on continue button")
    public void theUserClicksOnContinueButton() {
        registerPage.clickContinue();
    }

    @And("the user provides the email {string}")
    public void theProvidesFillsTheEmail(String email) {
        registerPage.enterEmail(email);
    }

    @Then("the user is registered")
    public void theUserIsRegistered() {
        Assert.assertEquals("It is not the correct URL"
                , RegisterPage.PAGE_URL
                , pf.getDriver().getCurrentUrl());
    }

}
