package com.hiberus.university.selenium.pages;

import com.hiberus.university.selenium.pages.PagesFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class CheckoutStepTwoPage extends AbstractPage {
    public static final String PAGE_URL = "https://www.saucedemo.com/checkout-step-two.html";

    @FindBy(xpath = "div[@class='cart-item']") // Se puede usar xpath, id, css...
    private List<WebElement> checkoutItems;

    @FindBy (xpath = "div[@class='cart-item]")
    private WebElement summarySubtotalDiv;

    @FindBy (xpath = "//div[@class='summary_total_label]")
    private WebElement summaryTotalDiv;

    @FindBy (id = "finish")
    private WebElement finishButton;

    @FindBy (id = "cancel")
    private WebElement cancelButton;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return cancelButton;
    }

    public float getItemPrice(String itemName) {
        String price = "";
        for (WebElement item : checkoutItems) {
            price = item.findElement(By.xpath("//div[contains(@text,'"+itemName+"')]//following-sibling::div[@class='inventory_item_price']")).getText().substring(1);
        }
        return Float.parseFloat(price);
    }

    public float getItemTotalNoTaxes () {
        return Float.parseFloat(summaryTotalDiv.getText().substring(13));
    }

    public void finish () {
        finishButton.click();
    }

    public void cancel () {
        cancelButton.click();
    }
}
