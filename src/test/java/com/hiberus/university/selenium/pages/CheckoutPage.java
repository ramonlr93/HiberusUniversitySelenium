package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
  public static final String CHECKOUT_PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";

  @FindBy(xpath = "//div[@id='checkout-checkout']")
  private WebElement checkoutContainer;

  //Billing Details WeBElements
  @FindBy(xpath = "//input[@name='payment_address' and @value='new']")
  private WebElement paymentAddressNewCheck;

  @FindBy(xpath = "//div[@id='payment-new']")
  private WebElement billingDetailsContainer;

  @FindBy(xpath = "//input[@id='button-payment-address']")
  private WebElement paymentAddressContinueButton;

  //Delivery Details WeBElements
//  @FindBy(xpath = "//input[@name='shipping_address' and @value='existing']")
//  private WebElement shippingAddressExistingCheck;

  @FindBy(xpath = "//input[@id='button-shipping-address']")
  private WebElement shippingAddressContinueButton;

  //Delivery Method WeBElements
  @FindBy(id = "button-shipping-method")
  private WebElement shippingMethodContinueButton;

  //Payment Method WeBElements
  @FindBy(xpath = "//input[@name='payment_method' and @value='bank_transfer']")
  private WebElement paymentMethodCheck;

  @FindBy(xpath = "//input[@name='agree']")
  private WebElement agreeContinueButton;

  @FindBy( id = "button-payment-method")
  private WebElement paymentMethodContinueButton;

  //Confirm Order WeBElements
  @FindBy(id = "button-confirm")
  private WebElement confirmOrderButton;

  public CheckoutPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return checkoutContainer;
  }

  //Billing Details
  public void billingAddressCheck() {
    paymentAddressNewCheck.click();
  }

  public void fillBillingDetailsForm(String firstname, String lastname, String address, String city, String country, String region_state) {
    WebElement firstnameWebElement = billingDetailsContainer.findElement(By.id("input-payment-firstname"));
    firstnameWebElement.click();
    firstnameWebElement.sendKeys(firstname);

    WebElement lastnameWebElement = billingDetailsContainer.findElement(By.id("input-payment-lastname"));
    lastnameWebElement.click();
    lastnameWebElement.sendKeys(lastname);

    WebElement addressWebElement = billingDetailsContainer.findElement(By.id("input-payment-address-1"));
    addressWebElement.click();
    addressWebElement.sendKeys(address);

    WebElement cityWebElement = billingDetailsContainer.findElement(By.id("input-payment-city"));
    cityWebElement.click();
    cityWebElement.sendKeys(city);

    WebElement countryWebElement = billingDetailsContainer.findElement(By.id("input-payment-country"));
    Select selectCountry = new Select(countryWebElement);
    selectCountry.selectByValue(country);

    WebElement region_stateWebElement = billingDetailsContainer.findElement(By.id("input-payment-zone"));
    Select selectRegion_State = new Select(region_stateWebElement);
    selectRegion_State.selectByValue(region_state);
  }

  public void clickBillingDetailsContinueButton() {
    wait.until(ExpectedConditions.elementToBeClickable(paymentAddressContinueButton)).click();
  }

  //Delivery Details
   public void clickDeliveryDetailsContinueButton() {
     wait.until(ExpectedConditions.elementToBeClickable(shippingAddressContinueButton)).click();
  }

  //Delivery Method WeBElements
  public void clickDeliveryMethodContinueButton() {
    wait.until(ExpectedConditions.elementToBeClickable(shippingMethodContinueButton)).click();
  }

//  //Payment Method WeBElements
//  public void paymentMethodCheck() {
//    paymentMethodCheck.click();
//  }

  public void clickAgreeTermsCondButton() {
    wait.until(ExpectedConditions.elementToBeClickable(agreeContinueButton)).click();
  }

  public void clickPaymentMethodContinueButton() {
    wait.until(ExpectedConditions.elementToBeClickable(paymentMethodContinueButton)).click();
  }

  //Confirm Order
  public void clickConfirmOrderButton() {
    wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton)).click();
  }
}