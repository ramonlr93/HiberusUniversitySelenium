package org.hiberus.com.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.messages.types.Product;
import lombok.extern.slf4j.Slf4j;
import org.hiberus.com.pages.LoginPage;
import org.hiberus.com.pages.PagesFactory;
import org.hiberus.com.pages.ProductPage;
import org.hiberus.com.pages.StorePage;
import org.junit.Assert;

@Slf4j
public class StorePageSteps {

    @And("the user clicks on the tablets button")
    public void theUserIntroducesPersonalInformation() {
        log.info("the user clicks on the tablets button");
        PagesFactory pf = PagesFactory.getInstance();
        StorePage storePage = pf.getStorePage();
        storePage.clickTabletsButton();
    }

    @Then("the user see Product Page")
    public void theUserSeeYourStorePage() {
        log.info("the user see Product Page");
        PagesFactory pf = PagesFactory.getInstance();
        ProductPage productPage = pf.getProductPage();
        productPage.waitForPageLoad();
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not Product Page", ProductPage.PAGE_URL, currentUrl);
    }
}
