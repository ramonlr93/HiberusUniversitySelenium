package com.opencart.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@name, 'firstname')]")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[contains(@name, 'lastname')]")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[contains(@name, 'company')]")
    private WebElement companyField;

    @FindBy(xpath = "//input[contains(@name, 'address_1')]")
    private WebElement address_1Field;

    @FindBy(xpath = "//input[contains(@name, 'address_2')]")
    private WebElement address_2Field;

    @FindBy(xpath = "//input[contains(@name, 'city')]")
    private WebElement cityField;

    @FindBy(xpath = "//input[contains(@name, 'postcode')]")
    private WebElement postcodeField;

    @FindBy(id = "input-payment-country")
    private WebElement countrySelect;

    @FindBy(id = "input-payment-zone")
    private WebElement regionSelect;

    @FindBy(id = "button-payment-address")
    private WebElement addressContinueButton;

    @FindBy(id = "button-shipping-address")
    private WebElement shippingContinueButton;

    @FindBy(id = "button-shipping-method")
    private WebElement shippingMethodContinueButton;

    @FindBy(xpath = "//input[contains(@name, 'agree')]")
    private WebElement termsAndConditions;

    @FindBy(id = "button-confirm")
    private WebElement confirm;


    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void enterDataBillingDetailst(String firstName, String lastName, String company, String address, String city, String postCode){
        sendText(firstNameField, firstName);
        sendText(lastNameField, lastName);
        sendText(companyField, company);
        sendText(address_1Field, address);
        sendText(cityField, city);
        sendText(postcodeField, postCode);
    }

    public void countrySelection(String country){
        Select selectOption = new Select(countrySelect);
        selectOption.selectByValue(country);
    }

    public void regionSelection(String region){
        Select selectOption = new Select(regionSelect);
        selectOption.selectByValue(region);
    }

    public void regionSelection(){
        click(regionSelect);
    }

    public void clickAddressContinueButton(){
        click(addressContinueButton);
    }

    public void clickShippingContinueButton(){
        click(shippingContinueButton);
    }

    public void clickShippingMethodContinueButton(){
        click(shippingMethodContinueButton);
    }

    public void clickAcceptTermsAndConditions() {
        click(addressContinueButton);
    }

    public void clickConfirm() {
        click(confirm);
    }
}
