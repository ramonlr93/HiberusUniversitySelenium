package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.HomePage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HomePageSteps {

  @Given("the user is on the Home page")
  public void theUserIsOnTheHomePage() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("The user is on the Home Page");
    HomePage homePage = pf.getHomePage();
    homePage.navigateTo(HomePage.HOME_PAGE_URL);
  }

//  @And("the user adds a {string} by clicking 'Add To Cart'")
//  public void theUserAddsAByClickingAddToCart(String itemName) {
//    log.info("the user adds " + itemName + " by 'Add To Cart'");
//    PagesFactory pf = PagesFactory.getInstance();
//    AccountPage accountPage = pf.getAccountPage();
//    accountPage.addItemToCartByName(itemName);
//  }
//  @And("the user clicks on the shopping cart")
//  public void theUserClicksOnTheShoppingCart() {
//    log.info("the user clicks on the shopping cart");
//    PagesFactory pf = PagesFactory.getInstance();
//    AccountPage accountPage = pf.getAccountPage();
//   // accountPage.clickOnShoppingCart();
//  }
//
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
