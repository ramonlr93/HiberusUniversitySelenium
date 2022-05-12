package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class CheckoutStepOnePage extends AbstractPage{
    public static final String PAGE_URL = "https://www.saucedemo.com/checkout-step-one.html";

    @FindBy(id = "first-name") // Se puede usar xpath, id, css...
    private WebElement firstNameInput;

    @FindBy (id = "last-name")
    private WebElement lastNameInput;

    @FindBy (id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy (id = "cancel")
    private WebElement cancelButton;

    @FindBy (xpath = "//div[@class='error-message-container error]")
    private WebElement errorMessage;

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return errorMessage;
    }

    public void enterFirstName (String firstName){
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName (String lastName){
        firstNameInput.sendKeys(lastName);
    }

    public void enterPostalCode (String postalCode){
        firstNameInput.sendKeys(postalCode);
    }

    public boolean hasError () {
        try {
            //log.info
        } catch (NoSuchElementException e) {}
        return errorMessage.isDisplayed();
    }



}
