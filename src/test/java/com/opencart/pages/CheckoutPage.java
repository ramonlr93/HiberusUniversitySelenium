package com.opencart.pages;

import org.jsoup.Connection;
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

    @FindBy(id = "button-payment-method")
    private WebElement paymentButton;

    @FindBy(id = "button-confirm")
    private WebElement confirmOrderButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // GETTERS & SETTERS
    @Override
    public WebElement getPageLoadedTestElement() {
        return continuePaymentButton;
    }


    // METODOS
    public void clickContinueWithoutAccountButton() {
        continueWithoutAccountButton.click();
    }

    public void clickLoginAccountButton() {
        loginAccountButton.click();
    }

    public void clickContinueButton() {
        continuePaymentButton.click();
    }

    public void clickShippingAddressButton() {
        shippingAddressButton.click();
    }

    public void clickShippingMethodButton() {
        shippingMethodButton.click();
    }

    public void clickAcceptTerms() {
        acceptTerms.click();
    }

    public void clickPaymentButton() {
        paymentButton.click();
    }

    public void clickConfirmOrderButton() {
        confirmOrderButton.click();
    }


}
