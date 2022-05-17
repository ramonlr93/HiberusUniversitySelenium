package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutStepOnePage extends AbstractPage {
  public static final String PAGE_URL = "https://www.saucedemo.com/checkout-step-one.html";

  @FindBy(xpath = "//input[@data-test='firstName']")
  private WebElement firstNameInput;

  @FindBy(xpath = "//input[@data-test='lastName']")
  private WebElement lastNameInput;

  @FindBy(xpath = "//input[@data-test='postalCode']")
  private WebElement postalCodeInput;

  @FindBy(xpath = "//input[@data-test='continue']")
  private WebElement continueButton;

  public CheckOutStepOnePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return firstNameInput;
  }

  public void enterFirstName(String firstName) {
    firstNameInput.clear();
    firstNameInput.click();
    firstNameInput.sendKeys(firstName);
  }

  public void enterLastName(String lastName) {
    lastNameInput.clear();
    lastNameInput.click();
    lastNameInput.sendKeys(lastName);
  }

  public void enterPostalCode(String postalCode) {
    postalCodeInput.clear();
    postalCodeInput.click();
    postalCodeInput.sendKeys(postalCode);
  }

  public void fillInformation(String firstName, String lastName, String postalCode) {
    enterFirstName(firstName);
    enterLastName(lastName);
    enterPostalCode(postalCode);
  }

  public void clickContinue() {
    continueButton.submit();
  }
}

