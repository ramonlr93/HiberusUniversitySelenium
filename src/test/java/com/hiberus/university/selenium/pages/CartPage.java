package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    public static final String PAGE_URL = "https://www.saucedemo.com/cart.html";

    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/descendant::button[contains(@onclick,'remove')]")
    private List<WebElement> removeButton;

    @FindBy(linkText = "Continue Shopping")
    private WebElement continueShoppingButton;

    @FindBy(linkText = "Checkout")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr")
    private List<WebElement> itemsList;

    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/td[@class='text-left']/a")
    private List<WebElement> itemNameList;

    CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return itemsList.get(0);
    }

    public void clickCheckout(){
        checkoutButton.click();
    }

    public List<WebElement> getItemsList() {
        return itemsList;
    }

    public void clickContinueShopping(){
        continueShoppingButton.click();
    }

    public void removeItemToCart() {
        WebElement productButton = removeButton.get(0);
        productButton.click();
    }

    public List<String> getItemsName(){
        List<String> itemNames = new ArrayList<String>();
        for (WebElement webElement : itemNameList) {
            itemNames.add(webElement.getText());
        }
        return itemNames;
    }
}
