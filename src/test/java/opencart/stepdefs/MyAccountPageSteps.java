package opencart.stepdefs;

import io.cucumber.java.en.Then;
import opencart.pages.MyAccountPage;
import opencart.pages.PagesFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MyAccountPageSteps {

    private PagesFactory pf = PagesFactory.getInstance();
    private MyAccountPage myAccountPage = pf.getMyAccountPage();
    private WebDriver driver = pf.getDriver();

    @Then("The user can see my account page")
    public void theUserIsOnMyAccountPage(){
        Assert.assertEquals("The user is not on my account page", myAccountPage.PAGE_URL, driver.getCurrentUrl());
    }
}
