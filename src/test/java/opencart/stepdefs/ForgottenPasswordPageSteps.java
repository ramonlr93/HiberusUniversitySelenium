package opencart.stepdefs;

import io.cucumber.java.en.Then;
import opencart.pages.ForgottenPasswordPage;
import opencart.pages.HomePage;
import opencart.pages.PagesFactory;
import org.apache.velocity.runtime.directive.contrib.For;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ForgottenPasswordPageSteps {

    private PagesFactory pf = PagesFactory.getInstance();
    private ForgottenPasswordPage forgottenPasswordPage = pf.getForgottenPasswordPage();
    private WebDriver driver = pf.getDriver();

    @Then("The user can see forgotten password page")
    public void theUserIsOntForgottenPasswordPage(){
        Assert.assertEquals("The user is not on login page", forgottenPasswordPage.PAGE_URL, driver.getCurrentUrl());
    }
}
