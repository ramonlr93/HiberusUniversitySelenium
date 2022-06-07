package es.david.practica.stepdefs;

import es.david.practica.pages.CheckoutPage;
import es.david.practica.pages.CheckoutSuccessPage;
import es.david.practica.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CheckoutSuccessPageSteps {

    PagesFactory pf = PagesFactory.getInstance();
    CheckoutSuccessPage csp = pf.getCheckoutSuccessPage();

    @Then("the user is in the checkout success site")
    public void theUserIsInTheCheckoutSuccessSite() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals("The page isnt correct", csp.PAGE_URL, pf.getDriver().getCurrentUrl());
    }
}
