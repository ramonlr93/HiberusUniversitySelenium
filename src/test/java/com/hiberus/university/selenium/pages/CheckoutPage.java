package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

@Slf4j
public class CheckoutPage extends BasePage {
  public static final String PAGE_URL = "http://opencart.abstracta.us/";
  public static final String CHECKOUT_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";
  public static final String SUCCESS_URL = "http://opencart.abstracta.us/index.php?route=checkout/success";


  @FindBy(xpath = "//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")
  private WebElement checkoutLink;

  @FindBy(xpath = "//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label/input")
  private WebElement guestCheckoutInput;

  @FindBy(xpath = "//*[@id=\"button-account\"]")
  private WebElement firstContinueCheckoutButton;

  @FindBy(xpath = "//*[@id=\"input-payment-firstname\"]")
  private WebElement firstNameInput;

  @FindBy(xpath = "//*[@id=\"input-payment-lastname\"]")
  private WebElement lastNameInput;

  @FindBy(xpath = "//*[@id=\"input-payment-email\"]")
  private WebElement emailInput;

  @FindBy(xpath = "//*[@id=\"input-payment-telephone\"]")
  private WebElement telephoneInput;

  @FindBy(xpath = "//*[@id=\"input-payment-address-1\"]")
  private WebElement addressInput;

  @FindBy(xpath = "//*[@id=\"input-payment-city\"]")
  private WebElement cityInput;

  @FindBy(xpath = "//*[@id=\"input-payment-postcode\"]")
  private WebElement postCodeInput;

  @FindBy(xpath = "//*[@id=\"input-payment-country\"]")
  private WebElement countrySelect;

  @FindBy(xpath = "//*[@id=\"input-payment-zone\"]")
  private WebElement regionSelect;

  @FindBy(xpath = "//*[@id=\"button-guest\"]")
  private WebElement secondContinueCheckoutButton;

  @FindBy(xpath = "//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")
  private WebElement termsInput;

  @FindBy(xpath = "//*[@id=\"button-payment-method\"]")
  private WebElement thirdContinueCheckoutButton;

  @FindBy(xpath = "//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tfoot/tr[4]/td[2]")
  private WebElement totalPriceText;

  @FindBy(xpath = "//*[@id=\"button-confirm\"]")
  private WebElement confirmOrderButton;

  @FindBy(xpath = "//*[@id=\"collapse-checkout-option\"]")
  private WebElement step1Panel;

  @FindBy(xpath = "//*[@id=\"collapse-payment-address\"]")
  private WebElement step2Panel;

  @FindBy(xpath = "//*[@id=\"collapse-payment-method\"]")
  private WebElement step3Panel;

  @FindBy(xpath = "//*[@id=\"collapse-checkout-confirm\"]")
  private WebElement step4Panel;

  @FindBy(xpath = "//*[@id=\"accordion\"]/div[2]/div[1]")
  private WebElement panels;

  @FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
  private WebElement lastContinue;


  public CheckoutPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public void clickOnChekoutLink(){
    getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    try {
      checkoutLink.click();
    } catch (org.openqa.selenium.TimeoutException e) {
    } catch (Exception e) {
    }
  }

  public void fillBillingDetails (String firstName, String lastName, String address, String mail, String telephone, String city, String country, String region) {

      try {
        Select drpCountry = new Select(countrySelect);
        Select drpRegion = new Select(regionSelect);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        addressInput.sendKeys(address);
        emailInput.sendKeys(mail);
        telephoneInput.sendKeys(telephone);
        cityInput.sendKeys(city);
        drpCountry.selectByVisibleText(country);
        drpRegion.selectByVisibleText(region);
      } catch (org.openqa.selenium.TimeoutException e) {
      } catch (Exception e) {
      }

  }
  @Override
  public WebElement getPageLoadedTestElement() {
    return checkoutLink;
  }

  public void selectGuestUser(){
    guestCheckoutInput.click();
  }

  public void clickStepOneContinueButton (){
    firstContinueCheckoutButton.click();
  }

  public void clickStepTwoContinueButton (){
    secondContinueCheckoutButton.click();
    getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  public void clickStepThreeContinueButton (){
    getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    try {
      thirdContinueCheckoutButton.click();
    } catch (org.openqa.selenium.TimeoutException e) {
    } catch (Exception e) {
    }
  }

  public void clickTermsAndConditions () {
    getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    try {
      termsInput.click();
    } catch (org.openqa.selenium.TimeoutException e) {
    } catch (Exception e) {
    }
  }

  public void clickConfirmOrderButton (){
    getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    try {
      confirmOrderButton.click();
    } catch (org.openqa.selenium.TimeoutException e) {
    } catch (Exception e) {
    }
  }

  public void waitTillOrderSuccess(){
    getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    try {
      lastContinue.isDisplayed();
    } catch (org.openqa.selenium.TimeoutException e) {
    } catch (Exception e) {
    }
  }

}
