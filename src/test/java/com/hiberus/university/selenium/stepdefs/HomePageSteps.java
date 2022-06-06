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

  @When("the user adds a single product by clicking AddToCart")
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

  @Then("the user verify that the product info appear in the shopping cart")
  public void theUserVerifyThatTheProductInfoAppearInTheShoppingCart() {
     log.info("The user verify that the product info appear in the shopping cart");
     PagesFactory pf = PagesFactory.getInstance();
     HomePage homePage = pf.getHomePage();
     //Assert.assertTrue();
     Assert.assertEquals("The Product info is shown","1 item(s) - $123.20", homePage.shoppingCartInfo());
  }








//  @Then("there should be {string} items in the shopping cart")
//  public void thereShouldBeItemsInTheShoppingCart(String count) {
//    log.info("there should be " + count + " items in the shopping cart");
//    PagesFactory pf = PagesFactory.getInstance();
//    HomePage homePage = pf.getHomePage();
//    int actualCount = homePage.getItemCount();
//    int expectedCount = Integer.parseInt(count);
//    Assert.assertEquals(actualCount, expectedCount);
//  }

//  @Then("the user see the inventory list with {string} size list")
//  public void theUserSeeTheInventoryListWith(String itemSize) {
//    log.info("the user see the item list");
//    PagesFactory pf = PagesFactory.getInstance();
//    AccountPage accountPage = pf.getAccountPage();
//    Assert.assertEquals("the item list size is different", Integer.parseInt(itemSize),
//      accountPage.getInventoryNameList().size());
//  }
//
//  @Then("the user see the {string} in the inventory list")
//  public void theUserSeeTheInTheInventoryList(String itemName) {
//    log.info("the user see the item list");
//    PagesFactory pf = PagesFactory.getInstance();
//    AccountPage accountPage = pf.getAccountPage();
//    Assert.assertTrue("the item not exist in inventory list",
//      accountPage.existProductInInventoryList(itemName));
//  }
//
//  @And("the user selects")
//  public void theUserSelects(DataTable dataTable) {
//    PagesFactory pf = PagesFactory.getInstance();
//    AccountPage accountPage = pf.getAccountPage();
//    List<String> selectedItems = dataTable.asList(String.class);
//    for (String itemName : selectedItems)
//    {
//      log.info("the user selects " + itemName);
//      accountPage.addItemToCartByName(itemName);
//    }
//  }
//
//  @And("the user clicks select {string}")
//  public void theUserClicksSelect(String optionSort) {
//    PagesFactory pf = PagesFactory.getInstance();
//    AccountPage accountPage = pf.getAccountPage();
//    accountPage.selectOption(optionSort);
//  }
//
//  @Then("the user see the list by alphabetical desc order")
//  public void theUserSeeTheListByAlphabeticalDescOrder() {
//    PagesFactory pf = PagesFactory.getInstance();
//    AccountPage accountPage = pf.getAccountPage();
//    List<WebElement> inventoryList = accountPage.getInventoryNameList();
//    List<String> nameInventoryResult = new ArrayList<>();
//    List<String> nameInventoryResultSorted = new ArrayList<>();
//    for (WebElement webElement : inventoryList) {
//      nameInventoryResult.add(webElement.getText());
//      nameInventoryResultSorted.add(webElement.getText());
//    }
//    nameInventoryResultSorted.sort(Collections.reverseOrder());
//    Assert.assertEquals("list is not sorted",
//      nameInventoryResultSorted, nameInventoryResult);
//  }
//
//  @Then("the user see the list by price desc order")
//  public void theUserSeeTheListByPriceDescOrder() {
//    PagesFactory pf = PagesFactory.getInstance();
//    AccountPage accountPage = pf.getAccountPage();
//    List<WebElement> inventoryPriceList = accountPage.getInventoryPriceList();
//    List<Double> priceInventoryResultsHighToLow = new ArrayList<>();
//    List<Double> priceInventoryResultsHighToLowSorted = new ArrayList<>();
//    for (WebElement webElement : inventoryPriceList) {
//      priceInventoryResultsHighToLow.add(
//        Double.parseDouble(webElement.getText().replace("$", "").trim()));
//      priceInventoryResultsHighToLowSorted.add(
//        Double.parseDouble(webElement.getText().replace("$", "").trim()));
//    }
//    priceInventoryResultsHighToLowSorted.sort(Collections.reverseOrder());
//    Assert.assertEquals("list is sorted by price",
//      priceInventoryResultsHighToLowSorted, priceInventoryResultsHighToLow);
//  }
//}
}
