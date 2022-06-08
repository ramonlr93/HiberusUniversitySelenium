package com.pfopencart.stepdefs;


import com.pfopencart.pages.BasePage;
import com.pfopencart.pages.HomePage;
import com.pfopencart.pages.PagesFactory;
import com.pfopencart.pages.RegisterPage;
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

    @And("the user fills the firstname {string}")
    public void theUserFillsTheFirstname(String firstname) { registerPage.enterFirstname(firstname);
    }

    @And("the user fills the lastname {string}")
    public void theUserFillsTheLastname(String lastname) { registerPage.enterLastname(lastname);
    }

    @And("the user fills the telephone {string}")
    public void theUserFillsTheTelephone(String telephone) { registerPage.enterTelephone(telephone);
    }
    @And("the user fills the pass {string}")
    public void theUserFillsThePass(String password) { registerPage.enterPassword(password);
    }

    @And("the user fills the confirm {string}")
    public void theUserFillsTheConfirm(String confirm) { registerPage.enterConfirm(confirm);
    }

    @And("the user clicks on privacy button")
    public void theUserClicksOnPrivacyButton() {
        registerPage.clickPrivacy();
    }

    @When("the user clicks on continue button")
    public void theUserClicksOnContinueButton() {
        registerPage.clickContinue();
    }

    @And("the user fills the email {string}")
    public void theUserFillsTheEmail(String email) {
        registerPage.enterEmail(email);
    }

    @Then("the user is registered")
    public void theUserIsRegistered() {
        Assert.assertEquals("It is not the correct URL"
                , RegisterPage.PAGE_URL
                , pf.getDriver().getCurrentUrl());
    }

}
