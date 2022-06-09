package com.hiberus.university.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CheckoutPage extends AbstractPage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";

    @FindBy(xpath = "//div[@class='panel-heading']")
    private WebElement panel;

    @FindBy(id = "button-payment-address")
    private WebElement billingContinueButton;

    @FindBy(id = "button-shipping-address")
    private WebElement deliveryDetailsContinueButton;

    @FindBy(id = "button-shipping-method")
    private WebElement deliveryMethodsContinueButton;

    @FindBy(xpath = "//input=[@name='agree']")
    private WebElement agreeTerms;

    @FindBy(id = "button-payment-method")
    private WebElement paymentContinueButton;

    @FindBy(id = "button-confirm")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//*[@id='content']/child::h1")
    private WebElement successOrderMessage;

    CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void clickBillingContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(billingContinueButton)).click();
    }

    public void clickDDetailsContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(deliveryDetailsContinueButton)).click();
    }

    public void clickDMethodContinue() {
        deliveryMethodsContinueButton.click();
    }

    public void clickAgree() {

        wait.until(ExpectedConditions.elementToBeClickable(agreeTerms)).click();
    }

    public void clickPaymentContinue() {

        wait.until(ExpectedConditions.elementToBeClickable(paymentContinueButton)).click();
    }

    public void clickConfirmOrder() {
        confirmOrderButton.click();
    }

    public boolean hasCheckoutOrderSuccess() {
        try {
            return successOrderMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Order failed");
        }
        return false;
    }
}

