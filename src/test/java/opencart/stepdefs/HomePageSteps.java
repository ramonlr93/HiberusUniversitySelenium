package opencart.stepdefs;

import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import opencart.pages.HomePage;
import opencart.pages.PagesFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

@Slf4j
public class HomePageSteps {

    private PagesFactory pf = PagesFactory.getInstance();
    private HomePage homePage = pf.getHomePage();
    private WebDriver driver = pf.getDriver();


    @Given("the user is on the home page")
    public void onHomePage(){
        log.info("The user is accessing the Home Page");
        homePage.navigateTo(HomePage.PAGE_URL);
        Assert.assertEquals("The user is not on home page", HomePage.PAGE_URL, driver.getCurrentUrl());
    }
}
