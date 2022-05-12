package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

/*MI CÓDIGO
public class CartPage extends AbstractPage {
    public static final String PAGE_URL = "https://www.saucedemo.com/cart.html";

    @FindBy(xpath = "//div[@class='cart-item']")
    private List<WebElement> inventoryItems;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingBtn;

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void clickRemoveCartItem(String itemName) {
        try {
            for (WebElement elm : inventoryItems) {
                elm.findElement(By.xpath("//button[contains(@id='remove-"+itemName+"')]")).click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void clickContinueShoppingBtn() {
        continueShoppingBtn.click();
    }

    public void clickChekoutBtn() {
        checkoutBtn.click();
    }
}*/

// SOLUCIÓN JONATAN
public class CartPage extends AbstractPage {
    public static final String PAGE_URL = "https://www.saucedemo.com/cart.html";

    @FindBy(xpath = "//button[text()='Open Menu']")
    private WebElement hamburgerElem;

    @FindBy(css = "//button[@data-test='checkout']")
    private WebElement checkoutButton;

    @FindBy(css = "#shopping_cart_container > a")
    private WebElement shoppingCartElem;

    @FindAll({@FindBy(css = "#cart_contents_container > div > div.cart_list > div.cart_item")})
    private List<WebElement> itemsList;

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
        return itemsList.size();
    }

    public List<WebElement> getItemsList() {
        return itemsList;
    }

    public void deleteCarItemtByName(String itemName) {
        String xpathName = itemName.replace(" ", "-").toLowerCase();
        String xpath = String.format("//button[@data-test='remove-" + xpathName + "']");
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));
        itemElem.click();
    }
}