package es.david.practica.stepdefs;

import es.david.practica.pages.BasePage;
import es.david.practica.pages.LogoutPage;
import es.david.practica.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BasePageSteps {

    PagesFactory pf = PagesFactory.getInstance();

    BasePage bp = pf.getBasePage();

    LogoutPage lp = pf.getLogoutPage();

    @When("the user clicks logout")
    public void theUserClicksLogout(){
        bp.clickMyAccount();
        bp.clickLogoutButton();
    }

    @Then("the user is in logout page")
    public void theUserIsInLogoutPage() {
        Assert.assertEquals("The user isnt in the correct page", lp.PAGE_URL, pf.getDriver().getCurrentUrl());
    }
}
