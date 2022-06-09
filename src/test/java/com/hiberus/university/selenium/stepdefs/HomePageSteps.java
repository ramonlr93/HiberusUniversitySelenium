package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.HomePage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class HomePageSteps {

  @Given("the user is on the Home page")
  public void theUserIsOnTheHomePage() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user is on the Home Page");
    HomePage homePage = pf.getHomePage();
    homePage.navigateTo(HomePage.HOME_PAGE_URL);
  }

  @And("the user visualizes that the currency displayed in the shopping cart is Dollar")
  public void theUserVisualizesThatTheCurrencyDisplayedInTheShoppingCartIsDollar() {
    log.info("The user visualizes that the currency displayed in the shopping cart is Dollar");
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    Assert.assertEquals("the value off the shopping cart is not 0", "0 item(s) - $0.00", homePage.shoppingCartText());
  }

  @And("the user clicks the Currency button")
  public void theUserClicksTheCurrencyButton() {
    log.info("The user clicks the Currency button");
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    homePage.clickCurrencyButton();
  }

  @When("the user clicks the Euro button")
  public void theUserClicksTheEuroButton() {
    log.info("The ser clicks the Euro button");
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    homePage.clickEuroButton();
  }

  @Then("the user validate that the currency in the shopping cart button is Euro")
  public void theUserValidateThatTheCurrencyInTheShoppingCartButtonIsEuro() {
    log.info("The user visualizes that the currency displayed in the shopping cart is Dollar");
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    Assert.assertEquals("the value off the shopping cart is not in Euro", "0 item(s) - 0.00€", homePage.shoppingCartText());
  }

  @And("the user adds a single product by clicking AddToCart")
  public void theUserAddsASingleProductByClickingAddToCart() {
    log.info("The user adds a item by clicking AddToCart");
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    homePage.clickIphoneProductButton();
  }

  @And("the user should be shown a success_added_product message")
  public void theUserShouldBeShownASuccessAddedItemMessage() {
    log.info("The user should be shown a success added product message");
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    Assert.assertTrue(homePage.successAddToCartMessageIsDisplayed());
  }

  @Then("the user verify that the product info appear in the shopping cart button")
  public void theUserVerifyThatTheProductInfoAppearInTheShoppingCart() {
    log.info("The user verify that the product info appear in the shopping cart");
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    Assert.assertTrue(homePage.shoppingCartInfo());
  }

  @When("the user clicks on the Shopping Cart button")
  public void theUserClicksOnTheShoppingCartButton() {
    log.info("The user clicks on the Shopping Cart button");
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    homePage.clickShoppingCartButton();
  }

  @Then("the user should be shown a view panel with the info of the product added to the shopping cart")
  public void theUserShouldBeShownAViewPanelWithTheInfoOfTheProductAddedToTheShoppingCart() throws InterruptedException {
    log.info("The user should be shown a view panel with the info of the product added to the shopping cart");
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    homePage.waitForPageLoad();
    Assert.assertTrue(homePage.infoPanelView());
  }

  @When("the user clicks on the Delete button")
  public void theUserClicksOnTheDeleteButton() {
    log.info("The user clicks on the Delete button");
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    homePage.clickDeleteButton();
    //homePage.clickDeleteButton();
  }

  @Then("the user deletes the product from the shopping cart")
  public void theUserDeletesTheProductFromTheShoppingCart() {
    log.info("The user deletes the product from the shopping cart");
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    Assert.assertTrue(homePage.shoppingCartInfo());
    Assert.assertEquals("the value off the shopping cart is not 0", "0 item(s) - $0.00€", homePage.shoppingCartText());
  }
}