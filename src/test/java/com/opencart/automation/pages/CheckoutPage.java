package com.opencart.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=checkout/checkout";

    @FindBy(xpath = "//input[contains(@name, 'firstname')]")
    private WebElement firstname;

    @FindBy(xpath = "//input[contains(@name, 'lastname')]")
    private WebElement lastname;

    @FindBy(xpath = "//input[contains(@name, 'company')]")
    private WebElement company;

    @FindBy(xpath = "//input[contains(@name, 'address_1')]")
    private WebElement address_1;

    @FindBy(xpath = "//input[contains(@name, 'address_2')]")
    private WebElement address_2;

    @FindBy(xpath = "//input[contains(@name, 'city')]")
    private WebElement city;

    @FindBy(xpath = "//input[contains(@name, 'postcode')]")
    private WebElement postcode;

    @FindBy(id = "input-payment-country")
    private WebElement country_id;

    @FindBy(id = "input-payment-zone")
    private WebElement zone_id;

    @FindBy(id = "input-payment-zone")
    private WebElement region;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }
}
