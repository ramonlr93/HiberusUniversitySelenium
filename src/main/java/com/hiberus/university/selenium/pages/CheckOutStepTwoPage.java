package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
@Slf4j

/* MI CÓDIGO
public class CheckoutStepTwoPage extends AbstractPage {
    public static final String PAGE_URL = "https://www.saucedemo.com/checkout-step-two.html";

    @FindBy(xpath = "//div[@class='cart.feature-item']")
    private List<WebElement> checkoutItems;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement summarySubtotalDiv;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    private WebElement summaryTotalDiv;


    @FindBy(id = "finish")
    private WebElement finishBtn;

    @FindBy(id = "cancel")
    private WebElement cancelBtn;

    CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public float getItemPrice(String itemName) {
        String price = "";
        for (WebElement item : checkoutItems) {
            price = item.findElement(By.xpath("//div[contains(@text,'"+itemName+"')]//following-sibling::div[@class='inventory_item_price']")).getText().substring(1);
        }
        return Float.parseFloat(price);
    }

    public float getItemTotalNoTaxes() {
        return Float.parseFloat(summaryTotalDiv.getText().substring(13));
    }

    public void clickFinishButton() {
        finishBtn.click();
    }

    public void clickCancelBtn() {
        cancelBtn.click();
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

}*/

// SOLUCIÓN DE JONATAN
public class CheckOutStepTwoPage extends AbstractPage {
    public static final String PAGE_URL = "https://www.saucedemo.com/checkout-step-two.html";

    @FindBy(css = "div.summary_subtotal_label")
    private WebElement itemTotal;

    @FindBy(css = "div.summary_tax_label")
    private WebElement tax;

    @FindBy(css = "div.summary_total_label")
    private WebElement total;

    public CheckOutStepTwoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return itemTotal;
    }

    public String getItemTotal() {
        return itemTotal.getText();
    }

    public String getTax() {
        return tax.getText();
    }

    public String getTotal() {
        return total.getText();
    }
}