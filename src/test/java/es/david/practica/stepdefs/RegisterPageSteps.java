package es.david.practica.stepdefs;

import es.david.practica.pages.BasePage;
import es.david.practica.pages.HomePage;
import es.david.practica.pages.PagesFactory;
import es.david.practica.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RegisterPageSteps {
    PagesFactory pf = PagesFactory.getInstance();
    BasePage bp = PagesFactory.getInstance().getBasePage();
    RegisterPage rp = pf.getRegisterPage();



    @And("the user goes to register")
    public void theUserGoesToRegister() {
        bp.clickMyAccount();
        bp.clickRegister();
    }

    @And("the user provides the firstname {string}")
    public void theUserProvidesTheFirstname(String firstname) {
        rp.enterName(firstname);
    }

    @And("the user provides the lastname {string}")
    public void theUserProvidesTheLastname(String lastname) {
        rp.enterLastname(lastname);
    }

    @And("the user provides the phone {string}")
    public void theUserProvidesThePhone(String phone) {
        rp.enterPhone(phone);
    }

    @And("the user provides the register password again {string}")
    public void theUserProvidesThePasswordAgain(String password) {
        rp.enterConfirmPassword(password);
    }

    @And("the user provides the register password {string}")
    public void theUserProvidesTheRegisterPassword(String password) {
        rp.enterPassword(password);
    }

    @And("the user provides the register mail {string}")
    public void theUserProvidesTheRegisterMail(String email) {
        rp.enterEmail(email);
    }

    @And("the user accept the policy check")
    public void theUserAcceptThePolicyCheck() {
        rp.acceptPoticy();
    }

    @When("the user clicks the register button")
    public void theUserClicksTheRegisterButton() {
        rp.clickRegister();
    }
}
