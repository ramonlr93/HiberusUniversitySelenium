package opencart.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import opencart.pages.PagesFactory;
import opencart.pages.RegistrationPage;
import opencart.pages.TopButtons;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

@Slf4j
public class RegistrationPageSteps {

    private PagesFactory pf = PagesFactory.getInstance();
    private RegistrationPage registrationPage = pf.getRegistrationPage();
    private WebDriver driver = pf.getDriver();

    @And("the user is on registration page")
    public void onRegistrationPage(){
        log.info("The user is accessing the Registration Page");
        registrationPage.getPageLoadedTestElement();
        Assert.assertEquals("The user is not on registration page", registrationPage.PAGE_URL, driver.getCurrentUrl());
    }

    @And("the user complete the form with first name {string} last name {string} e-mail {string} telephone {string} password {string} and password confirm {string}")
    public void completeForm(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
        registrationPage.completeForm(firstName, lastName, email, telephone, password, confirmPassword);
    }

    @And("the user selects suscribe option {string} and accepts check privacy policy {string}")
    public void theUserSelectsSuscribeOptionAndAcceptsCheckPrivacyPolicy(String suscribe, String privacyPolicy) {
        registrationPage.setSuscribe(suscribe);
        registrationPage.setCheckAgreeConditions(privacyPolicy);
    }

    @When("the user clicks the continue button")
    public void theUserClicksTheContinueButton() {
        registrationPage.clickContinueButton();
    }

    @Then("The user has successfully registered and can see the congratulations message")
    public void theUserHasSuccessfullyRegisteredAndCanSeeTheCongratulationsMessage() {
        Assert.assertTrue("The user has not registered correctly", registrationPage.congratulationsIsVissible());
    }

    @Then("The user can see an error message about the privacy policy {string}first name {string} last name {string} e-mail {string} telephone {string} and password {string}")
    public void allErrors(String privacyPolicy, String firstName, String lastName, String email, String telephone, String password) {

        String[] errors = {privacyPolicy, firstName, lastName, email, telephone, password};

        for(String e:errors){
            Assert.assertTrue("Alert of " + e + " is not vissible", registrationPage.alertOf(e));
        }
    }

    @Then("The user can see the error {string}")
    public void theUserCanSeeTheError(String errorType) {

        Assert.assertTrue("Alert of " + errorType + "is not vissible", registrationPage.alertOf(errorType));
    }

    @Then("The user can see registration page")
    public void theUserCanSeeRegistrationPage() {
        Assert.assertEquals("The user is not on registration page", registrationPage.PAGE_URL, driver.getCurrentUrl());
    }
}
