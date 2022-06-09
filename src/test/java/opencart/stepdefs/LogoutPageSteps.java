package opencart.stepdefs;

import io.cucumber.java.en.Then;
import opencart.pages.LogoutPage;
import opencart.pages.PagesFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LogoutPageSteps {

    private PagesFactory pf = PagesFactory.getInstance();
    private LogoutPage logoutPage = pf.getLogoutPage();
    private WebDriver driver = pf.getDriver();

    @Then("the user is on logout page")
    public void onLogoutPage(){
        Assert.assertEquals("The user is not on logout page", logoutPage.PAGE_URL, driver.getCurrentUrl());
    }
}
