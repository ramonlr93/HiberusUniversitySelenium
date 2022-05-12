package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckoutOverviewPage extends AbstractPage {
    public static final String PAGE_URL = "https://www.saucedemo.com/checkout-step-two.html";

    @FindBy(css = "div.summary_subtotal_label")
    private WebElement itemTotal;

    @FindBy(css = "div.summary_tax_label")
    private WebElement tax;

    @FindBy(css = "div.summary_total_label")
    private WebElement total;

    @FindBy(css = "div.inventory_item_price")
    private List <WebElement> itemprices;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    public CheckoutOverviewPage(WebDriver driver) {
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

    public Float getSumPrices(){
        float sum = 0f;

        for(int i=0;i<itemprices.size();i++){
            sum += Float.parseFloat(itemprices.get(i).getText().substring(1));
        }
        return sum;
    }

    public void clickCancelButton(){
        cancelButton.click();
    }
}
