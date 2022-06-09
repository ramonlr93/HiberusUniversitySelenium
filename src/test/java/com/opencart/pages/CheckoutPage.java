package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";

    @FindBy(id = "button-account")
    private WebElement continueWithoutAccountButton;

    @FindBy(id = "button-login")
    private WebElement loginAccountButton;

    @FindBy(id = "button-payment-address")
    private WebElement continuePaymentButton;

    @FindBy(id = "button-shipping-address")
    private WebElement shippingAddressButton;

    @FindBy(id = "button-shipping-method")
    private WebElement shippingMethodButton;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement acceptTerms;

    @FindBy(xpath = "//input[@name='payment_method' and @value='bank_transfer']")
    private WebElement paymentTransfer;

    @FindBy(xpath = "//input[@name='payment_method' and @value='cod']")
    private WebElement paymentCash;

    @FindBy(id = "button-payment-method")
    private WebElement paymentButton;

    @FindBy(id = "button-confirm")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement orderStatus;

    @FindBy(xpath = "//input[@value='register']")
    private WebElement registerAccount;

    @FindBy(xpath = "//input[@value='guest']")
    private WebElement guestAccount;

    @FindBy(id = "button-account")
    private WebElement continueWithAccount;

    @FindBy(id = "button-login")
    private WebElement continueWithLogin;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // GETTERS & SETTERS
    @Override
    public WebElement getPageLoadedTestElement() {
        return continuePaymentButton;
    }

    public String getOrderStatus() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return orderStatus.getText();
    }

    // register account on checkout
    public void clickRegisterAccount() {
        registerAccount.click();
    }


    // guest account on checkout
    public void clickGuestAccount() {
        guestAccount.click();
    }


    // METODOS
    public void clickContinueWithoutAccountButton() {
        continueWithoutAccountButton.click();
    }

    public void clickLoginAccountButton() {
        loginAccountButton.click();
    }

    public void clickBillingDetaillsButton() {
        continuePaymentButton.click();
    }

    public void clickDeliveryDetailsButton() {
        shippingAddressButton.click();
    }

    public void clickDeliveryMethodButton() {
        shippingMethodButton.click();
    }

    public void clickPaymentMethodButton() {
        paymentButton.click();
    }

    public void clickAcceptTerms() {
        acceptTerms.click();
    }

    public void clickConfirmOrderButton() {
        confirmOrderButton.click();
    }

    public void selectPaymentOption(String optSelected) {
        if (optSelected.equals("Bank Transfer")) paymentTransfer.click();
        else paymentCash.click();
    }
}
