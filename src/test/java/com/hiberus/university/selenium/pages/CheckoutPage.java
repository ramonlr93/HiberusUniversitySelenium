package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage extends BasePage {
    public static final String PAGE_URL = "https://www.saucedemo.com/checkout-step-one.html";
    private static final String CASH = "Cash";

    @FindBy(id = "input-payment-firstname")
    private WebElement firstNameImput;

    @FindBy(id = "input-payment-lastname")
    private WebElement lastNameImput;

    @FindBy(id = "input-payment-address-1")
    private WebElement adressImput;

    @FindBy(id = "input-payment-city")
    private WebElement cityImput;

    @FindBy(id = "input-payment-postcode")
    private WebElement postCodeImput;

    @FindBy(id = "input-payment-country")
    private WebElement countrySelect;

    @FindBy(id = "input-payment-zone")
    private WebElement regionSelect;

    @FindBy(xpath = "//div[@id='shipping-existing']/select[@name='address_id']")
    private WebElement addressDeliverySelect;

    @FindBy(xpath = "//input[@value='new']")
    private WebElement newAddressRadio;

    @FindBy(xpath = "//input[@value='existing']")
    private List<WebElement> existingAddressRadio;

    @FindBy(xpath = "//input[@name='shipping_method']")
    private WebElement shippingRadio;

    @FindBy(xpath = "//input[@value='bank_transfer']")
    private WebElement bankTransferRadio;

    @FindBy(xpath = "//input[@value='cod']")
    private WebElement cashDeliveryRadio;

    @FindBy(xpath = "//textarea[@name='comment']")
    private List<WebElement> textArea;

    @FindBy(xpath = "//div[@id='content']/descendant::*[contains(text(),'successfully')]")
    private WebElement textSucessfullyItem;

    @FindBy(id = "button-confirm")
    private WebElement confirmOrderButton;


    CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return adressImput;
    }
    public void enterFirstName(String firstName){
        firstNameImput.click();
        firstNameImput.clear();
        firstNameImput.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        lastNameImput.click();
        lastNameImput.clear();
        lastNameImput.sendKeys(lastName);
    }
    public void enterAddress(String address){
        adressImput.click();
        adressImput.clear();
        adressImput.sendKeys(address);
    }

    public void enterCity(String city){
        cityImput.click();
        cityImput.clear();
        cityImput.sendKeys(city);
    }

    public void enterPostCode(String postCode){
        postCodeImput.click();
        postCodeImput.clear();
        postCodeImput.sendKeys(postCode);
    }

    public void enterCountry(String country){
        Select selectOption = new Select(countrySelect);
        selectOption.selectByVisibleText(country);
    }

    public void enterRegion(String region){
        Select selectOption = new Select(regionSelect);
        selectOption.selectByVisibleText(region);
    }

    public void enterDatesPayment(List<String> details){
        enterFirstName(details.get(0));
        enterLastName(details.get(1));
        enterAddress(details.get(2));
        enterCity(details.get(3));
        enterPostCode(details.get(4));
        enterCountry(details.get(5));
        enterRegion(details.get(6));
    }

    public void newAdressRadioClick(){
        newAddressRadio.click();
    }

    public void addCommentToOrder(){
        textArea.get(0).click();
        textArea.get(0).clear();
        textArea.get(0).sendKeys("Un comentario sobre mi orden");
    }

    public void selectedPaymentMethod(String method){
        switch (method) {
            case CASH:
                cashDeliveryRadio.click();
                break;
            default:
                bankTransferRadio.click();
                break;
        }
    }

    public boolean textSucessfullyIsPresent(){
        return textSucessfullyItem.isDisplayed();
    }

    public void continueAdressButtonClick(String step){
        String xpath = "//input[@id='button-"+step+"-address']";
        WebElement continueButton = getDriver().findElement(By.xpath(xpath));
        continueButton.click();
    }

    public void continueMethodButtonClick(String step){
        String xpath = "//input[@id='button-"+step+"-method']";
        WebElement continueButton = getDriver().findElement(By.xpath(xpath));
        continueButton.click();
    }

    public void selectedAddressFinalDelivery(){
        String xpath = "//div[@id='shipping-existing']/select[@name='address_id']/option";
        List<WebElement> options = getDriver().findElements(By.xpath(xpath));
        int countOption = options.size();
        Select selectOption = new Select(addressDeliverySelect);
        selectOption.selectByIndex(countOption-1);
    }

    public void confirmOrderButtonClick(){
        confirmOrderButton.click();
    }
}
