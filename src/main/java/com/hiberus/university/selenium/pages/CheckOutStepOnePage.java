package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutStepOnePage extends AbstractPage {
  public static final String PAGE_URL = "https://www.saucedemo.com/checkout-step-one.html";

  @FindBy(xpath = "//input[@data-test='firstName']")
  private WebElement firstNameElem;

  @FindBy(xpath = "//input[@data-test='lastName']")
  private WebElement lastNameElem;

  @FindBy(xpath = "//input[@data-test='postalCode']")
  private WebElement postalCodeElem;

  @FindBy(css = "div.checkout_buttons > input")
  private WebElement continueElem;

  public CheckOutStepOnePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Override
  public WebElement getPageLoadedTestElement() {
    return firstNameElem;
  }

  public void enterFirstName(String firstName) {
    firstNameElem.clear();
    firstNameElem.sendKeys(firstName);
  }

  public void enterLastName(String lastName) {
    lastNameElem.clear();
    lastNameElem.sendKeys(lastName);
  }

  public void enterPostalCode(String postalCode) {
    postalCodeElem.clear();
    postalCodeElem.sendKeys(postalCode);
  }

  public void clickContinue() {
    continueElem.submit();
  }
}

