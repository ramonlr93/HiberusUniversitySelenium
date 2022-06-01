package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckOutStepTwoPage extends AbstractPage {
    public static final String PAGE_URL = "https://www.saucedemo.com/checkout-step-two.html";

    @FindBy(css = "div.summary_tax_label")
    private WebElement tax;
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement itemTotal;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    private WebElement total;

    @FindBy(xpath = "//div[@class='cart_item']")
    private List<WebElement> checkoutItems;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(xpath = "//div[@class='complete-text']")
    private WebElement finishMessage;


    public CheckOutStepTwoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return itemTotal;
    }
    public String getTax(){
        return tax.getText();
    }

    public String getFinishMessage(){
        return finishMessage.getText();
    }

    public void clickFinish() {
        finishButton.click();
    }

    public Double cartItemPrice() {
        List<WebElement> priceList = new ArrayList<>();
        for (WebElement price : checkoutItems) {
            priceList.add(price.findElement(By.xpath("./descendant::div[@class='inventory_item_price']")));
        }

        Double total = 0.0;
        for (WebElement number : priceList) {
            total = total + (Double.parseDouble(number.getText().replace("$", "").trim()));
        }
        return total;
    }

    public Double itemTotalByNumber() {
        return Double.parseDouble((itemTotal.getText().replace("Item total: $", "").trim()));
    }
}


