package com.opencart.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public static final String PAGE_URL = "http://opencart.abstracta.us";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='common-home']")
    private WebElement slider;

    @FindBy (xpath = "//a[@title='My Account']")
    private WebElement myAccountButton;

    @FindBy (xpath = "//a[normalize-space()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[contains(@onclick, 'cart.add') and contains(@onclick, '43')]")
    private WebElement macBook;

    @FindBy(xpath="//span[@id='cart-total']")
    private WebElement cartTotal;

    @Override
    public WebElement getPageLoadedTestElement() {
        return slider;
    }

    public void clickOnMyAccount(){
        super.click(myAccountButton);
    }

    public void clickOnLogin(){
        super.click(loginButton);
    }

    public void clickAddToCart() {
        super.click(macBook);
    }

    public String getTextCart() {
        return cartTotal.getText();

    }
}
