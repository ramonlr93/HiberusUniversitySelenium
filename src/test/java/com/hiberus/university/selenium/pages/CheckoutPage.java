package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends AbstractPage{
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";

    @FindBy(xpath = "//input[@value='guest']")
    private WebElement guestCheck;

    @FindBy(id = "button-account")
    private WebElement accountButton;

    @FindBy(id = "input-payment-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-payment-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-payment-email")
    private WebElement emailInput;

    @FindBy(id = "input-payment-telephone")
    private WebElement telephoneInput;

    @FindBy(id = "input-payment-address-1")
    private WebElement addressInput;

    @FindBy(id = "input-payment-city")
    private WebElement cityInput;

    @FindBy(id = "input-payment-postcode")
    private WebElement postCodeInput;

    @FindBy(id = "input-payment-country")
    private WebElement countrySelect;

    @FindBy(id = "input-payment-zone")
    private WebElement regionSelect;

    @FindBy(id = "button-guest")
    private WebElement continueAddress;

    @FindBy(name = "agree")
    private WebElement termConditionsCheck;

    @FindBy(id = "button-shipping-method")
    private WebElement continueShippingMethod;

    @FindBy(id = "button-payment-method")
    private WebElement continuePaymentMethod;

    @FindBy(id = "button-confirm")
    private WebElement confirmOrder;

    @FindBy(id = "content")
    private WebElement orderConfirmed;

    @FindBy(xpath = "//div[@class='text-danger']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement warningTermConditions;

    CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return accountButton;
    }

    public void clickGuest(){
        guestCheck.click();
    }

    public void clickContinueCostumer(){
        accountButton.click();
    }

    public void enterFirstName(String firstName){
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameInput.click();
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email){
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void enterTelephone(String telephone){
        telephoneInput.click();
        telephoneInput.sendKeys(telephone);
    }

    public void enterAddress(String address){
        addressInput.click();
        addressInput.sendKeys(address);
    }

    public void enterCity(String city){
        cityInput.click();
        cityInput.sendKeys(city);
    }

    public void enterPostCode(String postCode){
        postCodeInput.click();
        postCodeInput.sendKeys(postCode);
    }

    public void clickCountry(String country){
        countrySelect.click();
        wait.until(ExpectedConditions.visibilityOf(countrySelect.findElement(By.xpath("//option[contains(text(),'"+country+"')]")))).click();
    }

    public void clickRegion(String region){
        regionSelect.click();
        wait.until(ExpectedConditions.visibilityOf(regionSelect.findElement(By.xpath("//option[contains(text(),'"+region+"')]")))).click();
    }

    public void clickContinueAddress(){
        continueAddress.click();
    }


    public void clickTermConditions(){
        termConditionsCheck.click();
    }

    public void clickContinueShippingMethod(){
        try{
            continueShippingMethod.click();
        }catch (NoSuchElementException e){

        }
    }

    public void clickContinuePaymentMethod(){
        continuePaymentMethod.click();
    }

    public void clickConfirmOrder(){
        confirmOrder.click();
    }

    public boolean orderConfirmMessage(){
        return orderConfirmed.isDisplayed();
    }

    public boolean hasTermConditionsError() {
        return warningTermConditions.isDisplayed();
    }

    public String errorMessageDisplay(){
        if(errorMessage.isDisplayed()){
            return errorMessage.getText();
        }else{
            return null;
        }
    }
}
