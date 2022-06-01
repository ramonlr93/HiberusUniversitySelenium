package com.hiberus.university.selenium.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends AbstractPage {
    public static final String PAGE_URL = "https://www.saucedemo.com/cart.html";

    @FindBy(xpath = "//button[text()='Open Menu']")
    private WebElement hamburgerElem;

    @FindBy(xpath = "//button[@data-test='checkout']")
    private WebElement checkoutButton;

    @FindBy(css = "#shopping_cart_container > a")
    private WebElement shoppingCartElem;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> itemsListName;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return hamburgerElem;
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public int getItemCount() {
        return itemsListName.size();
    }

    public List<String> cartItemByName() {
        List<String> listByName = new ArrayList<>();
        for (WebElement name : itemsListName) {
            listByName.add(name.getText());
            System.out.println(listByName);
        }
        return listByName;
    }

    public void deleteCarItemtByPosition(int position) {
        String itemPosition = cartItemByName().get(position);
        String xpathName = itemPosition.replace(" ", "-").toLowerCase();
        String xpath = String.format("//button[@data-test='remove-" + xpathName + "']");
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));
        itemElem.click();
    }
}
