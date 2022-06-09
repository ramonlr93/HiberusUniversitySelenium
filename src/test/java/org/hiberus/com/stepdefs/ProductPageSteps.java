package org.hiberus.com.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.hiberus.com.pages.*;
import org.junit.Assert;

@Slf4j
public class ProductPageSteps {

    @And("the user clicks on the add to cart button")
    public void theUserClicksOnAddToCartButton() {
        log.info("the user clicks on the add to cart button");
        PagesFactory pf = PagesFactory.getInstance();
        ProductPage productPagePage = pf.getProductPage();
        productPagePage.clickAddToCart();
    }

    @And("the user clicks on the cart button")
    public void theUserClicksOnCartButton() {
        log.info("the user clicks on the cart button");
        PagesFactory pf = PagesFactory.getInstance();
        ProductPage productPagePage = pf.getProductPage();
        productPagePage.clickCartButton();
    }

    @And("the user clicks on the checkout button")
    public void theUserClicksOnCheckOutButton() {
        log.info("the user clicks on the checkout button");
        PagesFactory pf = PagesFactory.getInstance();
        ProductPage productPagePage = pf.getProductPage();
        productPagePage.clickCheckOut();
    }

    @Then("the user see the Checkout Page")
    public void theUserSeeCheckoutPage() {
        log.info("the user see Checkout Page");
        PagesFactory pf = PagesFactory.getInstance();
        CheckoutPage checkoutPage = pf.getCheckoutPage();
        //checkoutPage.waitForPageLoad();
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not Store Page", CheckoutPage.PAGE_URL, currentUrl);

    }

}
