package com.hiberusuniversity.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(id = "input-payment-firstname")
    private WebElement inputPaymentFirstname;

    @FindBy(id = "input-payment-lastname")
    private WebElement inputPaymentLastName;

    @FindBy(id = "input-payment-email")
    private WebElement inputPaymentEmail;

    @FindBy(id = "input-payment-telephone")
    private WebElement inputPaymentTelephone;

    @FindBy(id = "input-payment-address-1")
    private WebElement inputPaymentAddress;

    @FindBy(id = "input-payment-city")
    private WebElement inputPaymentCity;

    @FindBy(id = "input-payment-postcode")
    private WebElement inputPaymentPostCode;

    @FindBy(id = "input-payment-country")
    private WebElement inputPaymentCountry;

    @FindBy(id = "input-payment-zone")
    private WebElement inputPaymentZone;

    @FindBy(id = "input-shipping-firstname")
    private WebElement inputShippingFirstname;

    @FindBy(id = "input-shipping-lastname")
    private WebElement inputShippingLastName;

    @FindBy(id = "input-shipping-address-1")
    private WebElement inputShippingAddress;

    @FindBy(id = "input-shipping-city")
    private WebElement inputShippingCity;

    @FindBy(id = "input-shipping-postcode")
    private WebElement inputShippingPostCode;

    @FindBy(id = "input-shipping-country")
    private WebElement inputShippingCountry;

    @FindBy(id = "input-shipping-zone")
    private WebElement inputShippingZone;

    @FindBy(xpath = "//input[@name='payment_address' and @value='new']")
    private WebElement inputRadioPayment;

    @FindBy(xpath = "//input[@name='shipping_address' and @value='new']")
    private WebElement inputRadioAddress;

    @FindBy(id = "button-account")
    private WebElement guestButton;

    @FindBy(id = "button-login")
    private WebElement loginButton;

    @FindBy(id = "button-payment-address")
    private WebElement billingButton;

    @FindBy(id = "button-shipping-address")
    private WebElement deliveryButton;

    @FindBy(id = "button-guest")
    private WebElement billingButtonGuest;


    @FindBy(id = "button-shipping-method")
    private WebElement shippingButton;

    @FindBy(id = "button-payment-method")
    private WebElement paymentButton;

    @FindBy(id = "button-confirm")
    private WebElement confirmButton;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement checkPayment;

    @FindBy(xpath = "//input[@value='guest']")
    private WebElement checkboxGuestCheckout;

    CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void loginCheckout(String email,String password){
        inputEmail.click();
        inputEmail.sendKeys(email);
        inputPassword.click();
        inputPassword.sendKeys(password);
        loginButton.click();
    }

    public void clickButtonBillingAddress(){
        wait.until(ExpectedConditions.elementToBeClickable(billingButton)).click();
    }

    public void clickButtonDeliveryAddress(){
        wait.until(ExpectedConditions.elementToBeClickable(deliveryButton)).click();
    }

    public void clickButtonBillingAddressGuest(){
        wait.until(ExpectedConditions.elementToBeClickable(billingButtonGuest)).click();
    }

    public void clickButtonShipping(){
        wait.until(ExpectedConditions.elementToBeClickable(shippingButton)).click();
    }

    public void clickButtonPayment(){
        wait.until(ExpectedConditions.elementToBeClickable(checkPayment)).click();
        paymentButton.click();
    }

    public void clickButtonConfirm(){
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
    }

    public WebElement getInputRadioPayment() {
        return inputRadioPayment;
    }

    public WebElement getInputRadioAddress() {
        return inputRadioAddress;
    }

    public void createBillingDetails(String name,String lastname,String address,String city,String country,String region){
        inputPaymentFirstname.sendKeys(name);
        inputPaymentLastName.sendKeys(lastname);
        inputPaymentAddress.sendKeys(address);
        inputPaymentCity.sendKeys(city);
        Select countrySelect = new Select(inputPaymentCountry);
        countrySelect.selectByVisibleText(country);
        Select regionSelect = new Select(inputPaymentZone);
        regionSelect.selectByVisibleText(region);
        clickButtonBillingAddress();
    }

    public void createBillingDetailsGuest(String name,String lastname,String email,String Telephone,String address,String city,String country,String region){
        inputPaymentFirstname.sendKeys(name);
        inputPaymentLastName.sendKeys(lastname);
        inputPaymentEmail.sendKeys(email);
        inputPaymentTelephone.sendKeys(Telephone);
        inputPaymentAddress.sendKeys(address);
        inputPaymentCity.sendKeys(city);
        Select countrySelect = new Select(inputPaymentCountry);
        countrySelect.selectByVisibleText(country);
        Select regionSelect = new Select(inputPaymentZone);
        regionSelect.selectByVisibleText(region);
        clickButtonBillingAddressGuest();
    }

    public void createDeliveyDetails(String name,String lastname,String address,String city,String postcode,String country,String region){
        inputShippingFirstname.sendKeys(name);
        inputShippingLastName.sendKeys(lastname);
        inputShippingAddress.sendKeys(address);
        inputShippingCity.sendKeys(city);
        inputShippingPostCode.clear();
        inputShippingPostCode.sendKeys(postcode);
        Select countrySelect = new Select(inputShippingCountry);
        countrySelect.selectByVisibleText(country);
        Select regionSelect = new Select(inputShippingZone);
        regionSelect.selectByVisibleText(region);
        clickButtonDeliveryAddress();
    }

    public void checkGuestCheckout(){
        checkboxGuestCheckout.click();
        guestButton.click();
    }



}



