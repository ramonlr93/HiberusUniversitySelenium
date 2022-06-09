package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends AbstractPage{
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";

    @FindBy(xpath = "//input[@value='new']")
    private WebElement newAddressSelect;

    @FindBy(id = "input-payment-firstname")
    private WebElement firstnameInput;

    @FindBy(id = "input-payment-lastname")
    private WebElement lastnameInput;

    @FindBy(id = "input-payment-address-1")
    private WebElement addressInput;

    @FindBy(id = "input-payment-city")
    private WebElement cityInput;

    @FindBy(id = "input-payment-postcode")
    private WebElement postcodeInput;

    @FindBy(id = "input-payment-country")
    private WebElement selectOption1;

    @FindBy(id = "input-payment-zone")
    private WebElement selectOption2;

    @FindBy(id = "button-payment-address")
    private WebElement continueButton;

    @FindBy(id = "button-shipping-address")
    private WebElement continueButton2;

    @FindBy(id = "button-shipping-method")
    private WebElement continueButton3;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement termsConditionsButton;

    @FindBy(id = "button-payment-method")
    private WebElement continueButton4;

    @FindBy(id = "button-confirm")
    private WebElement confirmButton;

    @FindBy(id = "content")
    private WebElement confirmationOrderMessage;

    CheckoutPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement(){
        return continueButton;
    }

    public void selectCountry(String country){
        Select selectOption = new Select(selectOption1);
        selectOption.selectByValue(country);
    }

    public void selectState(String state){
        Select selectOption = new Select(selectOption2);
        selectOption.selectByValue(state);
    }

    public void newAddressClick(){
        newAddressSelect.click();
    }

    public void enterFirstName(String name){
        firstnameInput.click();
        firstnameInput.sendKeys(name);
    }

    public void enterLastName(String lastname){
        lastnameInput.click();
        lastnameInput.sendKeys(lastname);
    }

    public void enterAddress(String address){
        addressInput.click();
        addressInput.sendKeys(address);
    }

    public void enterCity(String city){
        cityInput.click();
        cityInput.sendKeys(city);
    }

    public void enterPostcode(String postcode){
        postcodeInput.click();
        postcodeInput.sendKeys(postcode);
    }

    public void clickContinue(){
        continueButton.click();
    }

    public void clickContinue2(){
        continueButton2.click();
    }

    public void clickContinue3(){
        continueButton3.click();
    }

    public void clickContinue4(){
        continueButton4.click();
    }

    public void clickTermsConditions(){
        termsConditionsButton.click();
    }

    public void clickConfirmOrder(){
        confirmButton.click();
    }

    public void confirmationOrderMessage(){
        confirmationOrderMessage.isDisplayed();
    }

}
