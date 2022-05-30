package com.hiberus.university.selenium.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractPage {
    public static final String PAGE_URL = "https://www.saucedemo.com/cart.html";

    @FindBy(xpath = "//button[text()='Open Menu']")
    private WebElement hamburgerElem;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(css = "#shopping_cart_container > a")
    private WebElement shoppingCartElem;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemsList;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return hamburgerElem;
    }

    public List<String> getItemNames(){
        List<String> names = new ArrayList<String>();
        for(int i=0;i<itemsList.size();i++){
            names.add(itemsList.get(i).getText());
        }
        return names;
    }

    public boolean findItemByName(String name){
        String xpath = "//div[text() = '" + name + "']";
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));
        return itemElem.isDisplayed();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public void continueShoppingButton(){
        continueShoppingButton.click();
    }

    public int getItemCount() {
        return itemsList.size();
    }

    public List<WebElement> getItemsList() {
        return itemsList;
    }

    public void deleteCarItemByName(String itemName) {
        String xpathName = itemName.replace(" ", "-").toLowerCase();
        String xpath = String.format("//button[@data-test='remove-" + xpathName + "']");
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));
        itemElem.click();
    }
}