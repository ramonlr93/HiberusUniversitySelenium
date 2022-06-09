package com.hiberus.university.opencart.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class CheckoutPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";

    @FindBy(xpath = "//ul[@class='breadcrumb']/descendant::a[text()='Checkout']")
    private WebElement checkoutLink;

    @FindBy(id = "input-payment-firstname")
    private WebElement firstNameInputPaymentCheckout;

    @FindBy(id = "input-payment-lastname")
    private WebElement lastNameInputPaymentCheckout;

    @FindBy(id = "input-payment-company")
    private WebElement companyInputPaymentCheckout;

    @FindBy(id = "input-payment-address-1")
    private WebElement address1InputPaymentCheckout;

    @FindBy(id = "input-payment-address-2")
    private WebElement address2InputPaymentCheckout;

    @FindBy(id = "input-payment-city")
    private WebElement cityInputPaymentCheckout;

    @FindBy(id = "input-payment-postcode")
    private WebElement postcodeInputPaymentCheckout;

    @FindBy(id = "input-shipping-firstname")
    private WebElement firstNameInputShippingCheckout;

    @FindBy(id = "input-shipping-lastname")
    private WebElement lastNameInputShippingCheckout;

    @FindBy(id = "input-shipping-company")
    private WebElement companyInputShippingCheckout;

    @FindBy(id = "input-shipping-address-1")
    private WebElement address1InputShippingCheckout;

    @FindBy(id = "input-shipping-address-2")
    private WebElement address2InputShippingCheckout;

    @FindBy(id = "input-shipping-city")
    private WebElement cityInputShippingCheckout;

    @FindBy(id = "input-shipping-postcode")
    private WebElement postcodeInputShippingCheckout;

    @FindBy(id = "button-payment-address")
    private WebElement continuePaymentAddressButtonCheckout;

    @FindBy(id = "button-shipping-address")
    private WebElement continueShippingAddressButtonCheckout;

    @FindBy(id = "button-shipping-method")
    private WebElement continueShippingMethodButtonCheckout;

    @FindBy(id = "button-payment-method")
    private WebElement continuePaymentMethodButtonCheckout;

    @FindBy(xpath = "//input[@type='checkbox' and @name='agree']")
    private WebElement termsAndConditionsButtonCheckout;

    @FindBy(id = "button-confirm")
    private WebElement confirmOrderButtonCheckout;

    @FindBy(xpath = "//input[@name='payment_address' and @value='new']/parent::label")
    private WebElement newPaymentAddressButtonCheckout;

    @FindBy(xpath = "//input[@name='shipping_address' and @value='new']/parent::label")
    private WebElement newShippingAddressButtonCheckout;


    CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterFirstNamePaymentCheckout(String first_name) {
        firstNameInputPaymentCheckout.click();
        firstNameInputPaymentCheckout.sendKeys(first_name);
    }

    public void enterLastNamePaymentCheckout(String last_name) {
        lastNameInputPaymentCheckout.click();
        lastNameInputPaymentCheckout.sendKeys(last_name);
    }

    public void enterCompanyPaymentCheckout(String company) {
        companyInputPaymentCheckout.click();
        companyInputPaymentCheckout.sendKeys(company);
    }

    public void enterAddress1PaymentCheckout(String address1) {
        address1InputPaymentCheckout.click();
        address1InputPaymentCheckout.sendKeys(address1);
    }

    public void enterAddress2PaymentCheckout(String address2) {
        address2InputPaymentCheckout.click();
        address2InputPaymentCheckout.sendKeys(address2);
    }

    public void enterCityPaymentCheckout(String address2) {
        cityInputPaymentCheckout.click();
        cityInputPaymentCheckout.sendKeys(address2);
    }

    public void enterPostCodePaymentCheckout(String post_code) {
        postcodeInputPaymentCheckout.click();
        postcodeInputPaymentCheckout.sendKeys(post_code);
    }

    public void enterFirstNameShippingCheckout(String first_name) {
        firstNameInputShippingCheckout.click();
        firstNameInputShippingCheckout.sendKeys(first_name);
    }

    public void enterLastNameShippingCheckout(String last_name) {
        lastNameInputShippingCheckout.click();
        lastNameInputShippingCheckout.sendKeys(last_name);
    }

    public void enterCompanyShippingCheckout(String company) {
        companyInputShippingCheckout.click();
        companyInputShippingCheckout.sendKeys(company);
    }

    public void enterAddress1ShippingCheckout(String address1) {
        address1InputShippingCheckout.click();
        address1InputShippingCheckout.sendKeys(address1);
    }

    public void enterAddress2ShippingCheckout(String address2) {
        address2InputShippingCheckout.click();
        address2InputShippingCheckout.sendKeys(address2);
    }

    public void enterCityShippingCheckout(String address2) {
        cityInputShippingCheckout.click();
        cityInputShippingCheckout.sendKeys(address2);
    }

    public void enterPostCodeShippingCheckout(String post_code) {
        postcodeInputShippingCheckout.click();
        postcodeInputShippingCheckout.sendKeys(post_code);
    }

    public void selectCountryPaymentByName(String country_payment) {
        String xpath =
                String.format("//select[@id='input-payment-country']/descendant::option[text()='%s']",
                        country_payment);
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));

        itemElem.click();
    }

    public void selectZonePaymentByName(String zone_payment) {
        String xpath =
                String.format("//select[@id='input-payment-zone']/descendant::option[text()='%s']",
                        zone_payment);
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));

        itemElem.click();
    }

    public void selectCountryShippingByName(String country_shipping) {
        String xpath =
                String.format("//select[@id='input-shipping-country']/descendant::option[text()='%s']",
                        country_shipping);
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));

        itemElem.click();
    }

    public void selectZoneShippingByName(String zone_shipping) {
        String xpath =
                String.format("//select[@id='input-shipping-zone']/descendant::option[text()='%s']",
                        zone_shipping);
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));

        itemElem.click();
    }

    public void clickPaymentAddressContinue() {
        log.info("clicking...");
        try {
            continuePaymentAddressButtonCheckout.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking continuePaymentButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking continuePaymentButton, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void clickShippingAddressContinue() {
        log.info("clicking...");
        try {
            continueShippingAddressButtonCheckout.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking continueShippingAddressButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking continueShippingAddressButton, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void clickShippingMethodContinue() {
        log.info("clicking...");
        try {
            continueShippingMethodButtonCheckout.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking continueShippingMethodButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking continueShippingMethodButton, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void checkTermsAndConditions() {
        log.info("checking...");
        try {
            termsAndConditionsButtonCheckout.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking termsAndConditionsButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking termsAndConditionsButton, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void clickPaymentMethodContinue() {
        log.info("clicking...");
        try {
            continuePaymentMethodButtonCheckout.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking continuePaymentMethodButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking continuePaymentMethodButton, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void clickConfirmOrder() {
        log.info("clicking...");
        try {
            confirmOrderButtonCheckout.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking confirmOrderButton: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking confirmOrderButton, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void clickNewPaymentAddressButtonCheckout() {
        log.info("clicking...");
        try {
            newPaymentAddressButtonCheckout.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking newPaymentAddressButtonCheckout: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking newPaymentAddressButtonCheckout, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void clickNewShippingAddressButtonCheckout() {
        log.info("clicking...");
        try {
            newShippingAddressButtonCheckout.click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking newShippingAddressButtonCheckout: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking newShippingAddressButtonCheckout, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return checkoutLink;
    }
}