package com.hiberus.university.selenium.stepdefs;

import com.hiberus.university.selenium.pages.CheckOutPage;
//import com.hiberus.university.selenium.pages.CheckOutStepTwoPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckoutSteps {

  @And("the user clicks checkout")
  public void theUserClicksCheckout() {
    log.info("the user clicks in checkout button");
    PagesFactory pf = PagesFactory.getInstance();
    CheckOutPage checkOutPage = pf.getCheckOutStepOnePage();
    checkOutPage.clickCheckout();
  }
  @And("the user clicks continueButtonPayment")
  public void theUserClicksContinueButtonPayment() {
    log.info("the user clicks continueButtonPayment");
    PagesFactory pf = PagesFactory.getInstance();
    CheckOutPage checkOutPage = pf.getCheckOutStepOnePage();
    checkOutPage.clickContinueButtonPayment();
  }

  @And("the user clicks continueButtonShipping")
  public void theUserClicksContinueButtonShipping() {
    log.info("the user clicks continueButtonShipping");
    PagesFactory pf = PagesFactory.getInstance();
    CheckOutPage checkOutPage = pf.getCheckOutStepOnePage();
    checkOutPage.clickContinueButtonShipping();
  }

  @And("the user clicks continueButtonShippingMethod")
  public void theUserClicksContinueButtonShippingMethod() {
    log.info("the user clicks continueButtonShippingMethod");
    PagesFactory pf = PagesFactory.getInstance();
    CheckOutPage checkOutPage = pf.getCheckOutStepOnePage();
    checkOutPage.clickContinueButtonShippingMethod();
  }

  @Then("the user clicks confirm order")
  public void theUserClicksConfirmOrder() {
    log.info("the user clicks continueConfirmOrder");
    PagesFactory pf = PagesFactory.getInstance();
    CheckOutPage checkOutPage = pf.getCheckOutStepOnePage();
    checkOutPage.clickConfirmOrder();
  }

  @And("the user provides the first name {string} and last name {string} and address {string} and city {string} and postal code {string} and country {string} and region {string}")
  public void theUserProvidesTheFirstNameAsAndLastNameAsAndZipCodeAs(String name, String lastName,
                                                                     String address, String city, String postalCode, String country, String region) {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("the user provides the first checkout info");

    CheckOutPage page = pf.getCheckOutStepOnePage();
    page.enterFirstName(name);
    page.enterLastName(lastName);
    page.enterAddressCode(address);
    page.enterCity(city);
    page.enterPostalCode(postalCode);
    page.selectCountry(country);
    page.selectRegion(region);


  }

  @And("the user clicks continuePaymentButtonMethod")
  public void theUserClicksContinuePaymentButtonMethod() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("the user clicks 'Continue Payment Method'");
    CheckOutPage page = pf.getCheckOutStepOnePage();
    page.clickContinueButtonPaymentMethod();
  }
  @And("the user agrees the terms and conditions")
  public void theUserClicksTermsAndConditions() {
    PagesFactory pf = PagesFactory.getInstance();
    log.info("the user clicks 'Conditions'");
    CheckOutPage page = pf.getCheckOutStepOnePage();
    page.clickConditions();
  }

}

//
//  @Then("the user validates prices in checkout summary")
//  public void theUserValidatesPricesInCheckoutSummary() {
//    PagesFactory pf = PagesFactory.getInstance();
//    CheckOutStepTwoPage page = pf.getCheckOutStepTwoPage();
//    List<WebElement> listPriceProducts = page.getCheckoutItemPriceList();
//    List<Double> pricesProducts = new ArrayList<>();
//    for (WebElement webElement : listPriceProducts) {
//      pricesProducts.add(Double.parseDouble(webElement.getText().replace("$", "").trim()));
//    }
//    double value = 0;
//    for (Double pricesProduct : pricesProducts) {
//      value += pricesProduct;
//    }
//    String totalValueActual = page.getItemTotal();
//    Assert.assertTrue("the total price is not correct",
//      totalValueActual.contains(String.valueOf(value)));
//  }
//}
