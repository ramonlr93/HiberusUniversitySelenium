package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MobileDevicesPage extends BasePage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=product/category&path=24";
    @FindBy(xpath = "//span[contains(text(), 'Add to Cart')]")
    List<WebElement> button;
    @FindBy(xpath = "//button[@title='Remove']")
    WebElement delButton;
    @FindBy(xpath = "//span[@id='cart-total']")
    WebElement cartItems;
    @FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    WebElement cartButton;
    @FindBy(xpath = "//strong[contains(text(), 'Checkout')]")
    private WebElement cartWebBtn;

    MobileDevicesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void clickOnHTC() {
        button.get(0).click();
    }

    public String numberOfItemsAdded() {
        return cartItems.getText();
    }

    public void goToCart() {
        cartButton.click();
        cartWebBtn.click();
    }
    public String currentWebPage() {
        return getDriver().getCurrentUrl();
    }
    public void delProduct(){
        cartButton.click();
        delButton.click();
    }
}