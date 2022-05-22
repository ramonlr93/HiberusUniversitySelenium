package com.hiberus.university.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutStepTwoPage extends BasePage {
    public static final String PAGE_URL = "https://www.saucedemo.com/checkout-step-two.html";

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemPriceList;

    @FindBy(className = "summary_value_label")
    private WebElement paymentInformation;

    @FindBy(className = "summary_info_label")
    private WebElement shippingInformation;

    @FindBy(css = "div.summary_subtotal_label")
    private WebElement itemTotal;

    @FindBy(css = "div.summary_tax_label")
    private WebElement tax;

    @FindBy(css = "div.summary_total_label")
    private WebElement total;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    CheckOutStepTwoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return itemTotal;
    }

    public String getPaymentInformation() {
        return paymentInformation.getText();
    }

    public String getShippingInformation() {
        return shippingInformation.getText();
    }

    public Float getSumaItems(){
        Float suma = Float.valueOf(0);

        for (int i=0; i<3; i++) {
            String precio = itemPriceList.get(i).getText();
            Float precioProduct = Float.parseFloat(precio.substring(precio.indexOf("$")+1));

            suma = suma + precioProduct;
        }

        return suma;
    }

    public Float getItemTotal() {
        String textTotal = itemTotal.getText();
        return Float.parseFloat(textTotal.substring(textTotal.indexOf("$")+1));
    }

    public String getTax() {
        return tax.getText();
    }

    public Float getTotal() {
        String textTotal = total.getText();
        return Float.parseFloat(textTotal.substring(textTotal.indexOf("$")+1));
    }

    public void clickFinish(){
        finishButton.click();
    }

    public void clickCancel(){
        cancelButton.click();
    }
}
