package com.hiberusuniversity.openCart.stepdefs;


import com.hiberusuniversity.openCart.pages.BasePage;
import com.hiberusuniversity.openCart.pages.CartPage;
import com.hiberusuniversity.openCart.pages.HomePage;
import com.hiberusuniversity.openCart.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@Slf4j
public class CartSteps {
    PagesFactory pf = PagesFactory.getInstance();
    CartPage cartPage = pf.getCartPage();
    HomePage homePage= pf.getHomePage();

    @Given("the user is on the home page")
    public void theUserIsOnTheLogInPage() {
        log.info("The user is on the login page");
        homePage.navigateTo(homePage.PAGE_URL);
    }

    @And("the user adds two product to the cart {string} and {string}")
    public void theUserAddsTwoProductToTheCart(String product,String product2) {
        homePage.addProducts(product);
        homePage.addProducts(product2);
    }

    @When("the user click the cart section")
    public void theUserClickTheCartSection() {
        cartPage.clickCartSection();
    }

    @Then("the user is redirected to the cart page and sees the {int} products he added {string} and {string} in alphabetical order")
    public void theUserIsRedirectedToTheCartPageAndSeesTheTwoProductsHeAddedAnd(int numberProducts,String product, String product2) {
        List<String> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        products.stream().sorted();
        Assert.assertEquals("The number of products is not correct",numberProducts,cartPage.getProductsName().size());
        Assert.assertEquals("The name of the first product is not correct",products.get(0).toLowerCase(),cartPage.getProductsName().get(0).getText().toLowerCase());
        Assert.assertEquals("The name of the second product is not correct",products.get(1).toLowerCase(),cartPage.getProductsName().get(1).getText().toLowerCase());
    }

    @And("the user is redirected to the cart page and removes one of the products")
    public void theUserIsRedirectedToTheCartPageAndRemovesOneOfTheProducts() {
        cartPage.clickCartSection();
        cartPage.getDeleteProductsButtons().get(0).click();
    }

    @Then("the cart list will only have {int} product")
    public void theCartListWillOnlyHaveProduct(int numberProducts) {
        Assert.assertEquals("The number of products is wrong",numberProducts,1);
    }

    @And("the user adds one product to the cart {string}")
    public void theUserAddsOneProductToTheCart(String product) {
        homePage.addProducts(product);
    }

    @And("the user is redirected to the cart page and updates the quantity of one of the products {string}")
    public void theUserIsRedirectedToTheCartPageAndUpdatesTheQuantityOfOneOfTheProducts(String quantity) {
        cartPage.updateProductQuantity(Integer.parseInt(quantity));

    }

    @Then("the cart list will only have one product with {int} units")
    public void theCartListWillOnlyHaveProductWithTwoUnits(int quantity) {
        Assert.assertEquals("The quantity of the product is not the same",quantity,cartPage.productQuantity());

    }

    @Then("the price of the product is equal to the total price")
    public void thePriceOfTheProductIsEqualToTheTotalPrice() {
        Assert.assertEquals("The price is not correct",cartPage.totalCart(),cartPage.productPriceValue(),0.01);
    }
}
