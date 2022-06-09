package com.hiberusuniversity.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=checkout/cart";

    @FindBy(xpath = "//div[@class='table-responsive']//td[@class='text-left']//a[contains(@href,'product')]")
    private List<WebElement> productsName;

    @FindBy(xpath = "//button[@class='btn btn-danger']")
    private List<WebElement> deleteProductsButtons;

    @FindBy(xpath = "//div[@class='col-sm-4 col-sm-offset-8']//td[@class='text-right' and contains(text(),'$')]")
    private List<WebElement> cartPrice;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='input-group btn-block']//input")
    private WebElement inputQuantity;

    @FindBy(xpath = "//div[@class='input-group btn-block']//button[@class='btn btn-primary']")
    private WebElement updateButton;

    @FindBy(xpath = "//div[@id='content']//div[@class='table-responsive']//td[@class='text-right' and contains(text(),'$')]")
    private List<WebElement> productPrice;

    CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public List<WebElement> getProductsName() {
        return productsName;
    }

    public List<WebElement> getDeleteProductsButtons() {
        return deleteProductsButtons;
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public float totalCart(){
        float total =  Float.parseFloat(cartPrice.get(cartPrice.size()-1).getText().replace("$",""));
        return total;
    }

    public void updateProductQuantity(int quantity){
        inputQuantity.clear();
        inputQuantity.sendKeys(quantity+"");
        updateButton.click();
    }

    public int productQuantity(){
        return Integer.parseInt(inputQuantity.getAttribute("value"));
    }

    public float productPriceValue(){
        int contador=1;
        List<WebElement> priceTotalElements = new ArrayList<WebElement>();
        for (WebElement element:productPrice) {
            if((contador%2)!=0){
                priceTotalElements.add(element);
            }
            contador++;
        }
        float priceTotal = 0;
        for (WebElement element: priceTotalElements) {
            priceTotal+=Float.parseFloat(element.getText().replace("$",""));
        }
        return priceTotal;
    }

}
