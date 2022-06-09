package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {
  public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";

  @FindBy(xpath = "//i[contains(@class, 'fa fa-share')]")
  private WebElement checkOutButton;
  @FindBy(xpath = "//input[contains(@name, 'firstname')]")
  private WebElement firstNameInput;

  @FindBy(xpath = "//input[@id='input-payment-lastname']")
  private WebElement lastNameInput;

  @FindBy(xpath = "//input[@id='input-payment-address-1']")
  private WebElement adressInput;

  @FindBy(xpath = "//input[@id='input-payment-city']")
  private WebElement cityInput;

  @FindBy(xpath = "//input[@id='input-payment-postcode']")
  private WebElement postalCodeInput;

  @FindBy(id = "button-confirm")
  private WebElement countryInput;

  @FindBy(xpath= "//select[contains(@id, 'input-payment-country')]")
  private WebElement selectCountry;

  @FindBy(xpath= "//select[contains(@id, 'input-payment-zone')]")
  private WebElement selectRegion;

  @FindBy(id = "button-confirm")
  private WebElement confirmOrder;

  @FindBy(id = "button-payment-address")
  private WebElement continueButtonPayment;

  @FindBy(id = "button-shipping-method")
  private WebElement continueButtonShippingMethod;

  @FindBy(id = "button-shipping-address")
  private WebElement continueShippingButton;

  @FindBy(id = "button-payment-method")
  private WebElement continuePaymentButtonMethod;
  @FindBy(xpath = "//input[contains(@name, 'agree')]")
  private WebElement conditionsCheck;

  public CheckOutPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return checkOutButton;
  }

  public void enterFirstName(String firstName) {
    firstNameInput.clear();
    firstNameInput.sendKeys(firstName);
  }

  public void enterLastName(String lastName) {
    lastNameInput.clear();
    lastNameInput.sendKeys(lastName);
  }

  public void enterCity(String city) {
    cityInput.clear();
    cityInput.sendKeys(city);
  }
  public void enterAddressCode(String addressCode) {
    adressInput.clear();
    adressInput.sendKeys(addressCode);
  }

  public void enterPostalCode(String postalCode) {
    postalCodeInput.clear();
    postalCodeInput.sendKeys(postalCode);
  }

  public void selectCountry(String country) {
//    selectCountry.clear();
    Select countrySelect = new Select(selectCountry);
    countrySelect.selectByVisibleText(country);

  }

  public void selectRegion(String region) {
//    selectRegion.clear();
    Select regionSelect = new Select(selectRegion);
    regionSelect.selectByVisibleText(region);
  }

  public void clickContinueButtonPayment() {
    continueButtonPayment.submit();
  }

  public void clickContinueButtonPaymentMethod() {
    continuePaymentButtonMethod.submit();
  }
  public void clickContinueButtonShipping() {
    continueShippingButton.submit();
  }

  public void clickContinueButtonShippingMethod() {
    continueButtonShippingMethod.submit();
  }

  public void clickConfirmOrder() {
    confirmOrder.submit();
  }
  public void clickCheckout() {

    checkOutButton.click();
  }

  public void clickConditions() {

    conditionsCheck.click();
  }

}

