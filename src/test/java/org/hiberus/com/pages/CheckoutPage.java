package org.hiberus.com.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
@Slf4j
public class CheckoutPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";

    @FindBy(xpath = "//input[@value='new']")
    private WebElement newAdreesRadioButton;

    @FindBy(id = "input-payment-firstname")
    private WebElement inputFirstName;

    @FindBy(id = "input-payment-lastname")
    private WebElement inputLastName;

    @FindBy(id = "input-payment-address-1")
    private WebElement inputAddress;

    @FindBy(id = "input-payment-city")
    private WebElement inputCity;

    @FindBy(id = "input-payment-postcode")
    private WebElement inputPostCode;

    @FindBy(id = "input-payment-country")
    private WebElement selectCountry;

    @FindBy(id = "input-payment-zone")
    private WebElement selectZone;

    @FindBy(id = "button-payment-address")
    private WebElement continueButton01;

    @FindBy(xpath = "//select[@name='address_id']")
    private WebElement selectAddress;

    @FindBy(id = "button-shipping-address")
    private WebElement continueButton02;

    @FindBy(id = "button-shipping-method")
    private WebElement continueButton03;


    @FindBy(xpath = "//input[@value='bank_transfer']")
    private WebElement bankTransferRadioButton;

    @FindBy(xpath = "//input[@value='cod']")
    private WebElement cashOnDeliveryRadioButton;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement conditionsCheckBox;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement warningConditionsMessage;

    @FindBy(id = "button-payment-method")
    private WebElement continueButton04;

    @FindBy(id = "button-confirm")
    private WebElement confirmButton;


    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return confirmButton;
    }

    public void clickNewAddressRadioButton(){
        log.info("Clicks on newAddressRadioButton...");
        try {
            newAdreesRadioButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking newAddressRadioButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking newAddressRadioButton, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void introducesPersonalInformation(String firstName, String lastName,
                                              String address, String city, String postCode){
        inputFirstName.click();
        inputFirstName.sendKeys(firstName);
        inputLastName.click();
        inputLastName.sendKeys(lastName);
        inputAddress.click();
        inputAddress.sendKeys(address);
        inputCity.click();
        inputCity.sendKeys(city);
        inputPostCode.click();
        inputPostCode.sendKeys(postCode);

    }

    public void selectCountry(String option) {
        selectCountry.click();
        Select selectOption = new Select(selectCountry);
        selectOption.selectByValue(option);
    }

    public void selectZone(String option) {
        selectZone.click();
        Select selectOption = new Select(selectZone);
        selectOption.selectByValue(option);
    }

    public void clickContinueButton01() {
        log.info("Clicks in continueButton01...");
        try {
            continueButton01.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking continueButton01: " + e.getClass().getSimpleName());

        } catch (Exception e) {
            log.info("Clicking continueButton01, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void clickContinueButton02() {
        log.info("Clicks in continueButton02...");
        try {
            continueButton02.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking continueButton02: " + e.getClass().getSimpleName());

        } catch (Exception e) {
            log.info("Clicking continueButton02, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void clickContinueButton03() {
        log.info("Clicks in continueButton03...");
        try {
            continueButton03.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking continueButton03: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking continueButton03, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void clickContinueButton04() {
        log.info("Clicks in continueButton04...");
        try {
            continueButton04.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking continueButton04: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking continueButton04, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void clickBankTransferRadioButton() {
        log.info("Clicks on bankTransferRadioButton...");
        try {
            bankTransferRadioButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking bankTransferRadioButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking bankTransferRadioButton, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void clickCashOnDeliveryRadioButton() {
        log.info("Clicks in cashOnDeliveryRadioButton...");
        try {
            cashOnDeliveryRadioButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking cashOnDeliveryRadioButton2: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking cashOnDeliveryRadioButton, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void clickConditionsCheckbox() {
        log.info("Clicks in conditionsCheckBox...");
        try {
            conditionsCheckBox.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking conditionsCheckBox: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking conditionsCheckBox, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

    public void clickConfirmButton() {
        log.info("Clicks in confirmButton...");
        try {
            confirmButton.click();
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Timeout clicking confirmButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking confirmButton, caught exception, type=" + e.getClass().getSimpleName());
        }
    }

}