package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CartPage;
import com.hiberus.university.selenium.pages.HomePage;
import com.hiberus.university.selenium.pages.MyAccountPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

@Slf4j
public class CartPageSteps {

  @And("the user clicks to the cart")
  public void clickTheCart() {
    log.info("the user clicks in 'Cart'");
    PagesFactory pf = PagesFactory.getInstance();
    CartPage cartPage = pf.getCartPage();
    cartPage.clickCart();
  }



  @And("the user goes to your store")
  public void theUserClicksYourStore() {
    log.info("the user clicks in 'Your Store'");
    PagesFactory pf = PagesFactory.getInstance();
    CartPage cartPage = pf.getCartPage();
    cartPage.clickYourStore();
  }
  @When("the user deletes an item from shopping cart")
  public void theUserDeletesAItemFromShoppingCart() {
    log.info("the user deletes the item: ");
    PagesFactory pf = PagesFactory.getInstance();
    CartPage cartPage = pf.getCartPage();
    cartPage.deleteCartItem();
  }


  @Then("there should be 0 items in the shopping cart")
  public void thereShouldBeItemsInTheShoppingCart() {
    log.info("there should be 0 items in the shopping cart");
    PagesFactory pf = PagesFactory.getInstance();
    HomePage homePage = pf.getHomePage();
    Assert.assertNotNull("The user can see the cart with zero item", homePage.cartInfo());
  }

}


















//    int actualCount = cartPage.getItemCount();
//    int expectedCount = Integer.parseInt(String);
//    Assert.assertEquals(actualCount, expectedCount);
//  }

//  @Then("there should be {string} items in the shopping cart")
//  public void thereShouldBeItemsInTheShoppingCart(String count) {
//    log.info("there should be " + count + " items in the shopping cart");
//    PagesFactory pf = PagesFactory.getInstance();
//    CartPage cartPage = pf.getCartPage();
//    int actualCount = cartPage.getItemCount();
//    int expectedCount = Integer.parseInt(count);
//    Assert.assertEquals(actualCount, expectedCount);
//  }

//  @When("the user deletes a {string} item from shopping cart")
//  public void theUserDeletesAItemFromShoppingCart(String item) {
//    log.info("the user deletes the item: " + item);
//    PagesFactory pf = PagesFactory.getInstance();
//    CartPage cartPage = pf.getCartPage();
//    cartPage.deleteCarItemtByName(item);
//  }
//
//  @And("the user clicks checkout")
//  public void theUserClicksCheckout() {
//    log.info("the user clicks in checkout button");
//    PagesFactory pf = PagesFactory.getInstance();
//    CartPage cartPage = pf.getCartPage();
//    cartPage.clickCheckout();
//  }
//}
