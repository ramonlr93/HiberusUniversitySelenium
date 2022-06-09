package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.model.InventoryProduct;
import com.hiberus.university.selenium.pages.HomePage;
import com.hiberus.university.selenium.pages.PagesFactory;
import com.hiberus.university.selenium.utils.AccountOptionsClass.*;
import com.hiberus.university.selenium.utils.NavBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;

public class HomePageSteps {

    private HomePage homePage;

    public HomePageSteps() {
        homePage = PagesFactory.getInstance().getHomePage();
    }

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        homePage.navigateTo(HomePage.HOME_PAGE_URL);
    }

    @And("the user clicks on the my account button")
    public void theUserClicksOnTheMyAccountButton() {
        homePage.clickTopNavBarOption(NavBar.MY_ACCOUNT);
    }

    @And("the user clicks on the login option")
    public void theUserClicksOnTheLoginOption() {
        homePage.clickAccountOption(UnLoggedAccount.LOGIN);
    }

    @Then("the user sees on the menu, on my account, all the logged in options")
    public void theUserSeesOnTheMenuOnMyAccountAllTheLoggedInOptions() {
        homePage.clickTopNavBarOption(NavBar.MY_ACCOUNT);
        String optionsExpected = "";
        for (LoggedAccount option : LoggedAccount.values())
            optionsExpected += option.value();

        for (String option : homePage.getMyAccountOptions())
            Assert.assertTrue(
                    "Las opciones no son las adecuadas [" + option + "]",
                    optionsExpected.contains(option)
            );
    }

    @And("the user clicks on the register option")
    public void theUserClicksOnTheRegisterOption() {
        homePage.clickAccountOption(UnLoggedAccount.REGISTER);
    }

    InventoryProduct actualProduct;
    double totalPrice = 0;
    @When("the user adds the {string} product")
    public void theUserAddsTheProduct(String productName) {
        actualProduct = homePage.getInventoryProduct(productName);
        actualProduct.addCart();
        totalPrice += actualProduct.getPrice();
    }

    @Then("the cart is with {int} product and the correct price")
    public void theCartIsWithNumberProductsProductAndTheCorrectPrice(int numberProducts) {
        Assert.assertEquals("El número de productos no es el correcto", numberProducts, homePage.numberCartItems());
        Assert.assertEquals("El precio no es el correcto", totalPrice + "", homePage.totalPriceCart() + "");
    }
}
