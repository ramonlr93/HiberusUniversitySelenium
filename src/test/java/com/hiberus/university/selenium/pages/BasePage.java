package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Slf4j
public class BasePage extends AbstractPage {

    public static final String PAGE_URL = "http://opencart.abstracta.us/";

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//a[@href='https://opencart.abstracta.us:443/index.php?route=account/login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='https://opencart.abstracta.us:443/index.php?route=account/register']")
    private WebElement registerButton;

    @FindBy(xpath = "//a[@href='https://opencart.abstracta.us:443/index.php?route=account/logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//button[contains(@onclick, 'cart')]")
    private List<WebElement> addCartButtons;

    @FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    private WebElement cartButton;

    @FindBy(xpath = "//button[@title='Remove']")
    private WebElement cartRemoveButton;

    @FindBy(xpath = "//span[contains(text(),'Checkout')]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//button[@class='btn btn-link dropdown-toggle']")
    private WebElement currencyButton;

    @FindBy(xpath = "//p[@class='price']")
    private WebElement price;

    @FindBy(xpath = "//p[@class='text-center']")
    private WebElement cartText;

    @FindBy(id = "content")
    private WebElement textLogout;

    public BasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return myAccountButton;
    }

    public void clickMyAccount(){
        myAccountButton.click();
    }

    public void clickLogin(){
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
    }

    public void clickRegister(){
        wait.until(ExpectedConditions.visibilityOf(registerButton)).click();
    }

    public void clickLogout(){
        wait.until(ExpectedConditions.visibilityOf(logoutButton)).click();
    }

    public void clickAddCartButton(){
        int random = (int)(Math.random() * (2));
        addCartButtons.get(random).click();
    }

    public boolean getCartValue(){
        return wait.until(ExpectedConditions.visibilityOf(cartRemoveButton)).isDisplayed();
    }

    public void removeFromCart(){
        cartRemoveButton.click();
    }

    public void clickCart(){
        moveTo(cartButton);
        cartButton.click();
    }

    public void clickCheckout(){
        checkoutButton.click();
    }

    public void changeCurrency(String currency){
        currencyButton.click();
        wait.until(ExpectedConditions.visibilityOf(currencyButton.findElement(By.xpath("//button[contains(text(),'"+currency+"')]")))).click();
    }

    public boolean getPrice(String symbol){
        String currency =  price.getText();
        if(currency.contains(symbol)){
            return true;
        }else{
            return false;
        }
    }

    public boolean textLogout(){
        return textLogout.isDisplayed();
    }

    public boolean textCart(){
        return cartText.isDisplayed();
    }
}
