package es.david.practica.pages;

import jdk.internal.util.xml.impl.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends AbstractPage {

    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=checkout/cart";

    @FindBy(xpath = "//form//descendant::td[contains(@class, 'text-left')]//child::a")
    private List<WebElement> itemNames;

    @FindBy(xpath = "//form//descendant::td[contains(text(), '$')][1]")
    private List<WebElement> itemPrices;

    @FindBy(xpath = "//form//descendant::td[contains(text(), '$')][2]")
    private List<WebElement> itemTotalPrices;

    @FindBy(xpath = "//strong[(text() = 'Total:')]//parent::td//following::td")
    private WebElement totalPrice;

    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    private List<WebElement> productQuantities;

    @FindBy(xpath = "//a[contains(text(), 'Checkout')]")
    private WebElement checkout;

    CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public List<String> getItemNames() {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < itemNames.size(); i++) {
            names.add(itemNames.get(i).getText());
        }
        return names;
    }

    public Double getTotalCalculatedPrice() {
        double sum = 0.0;
        for (int i = 0; i < itemTotalPrices.size(); i++) {
            sum += (Double.parseDouble(itemTotalPrices.get(i).getText().substring(1).trim()));
        }
        return sum;
    }

    public Double getTotalPrice(){
        return Double.parseDouble(totalPrice.getText().substring(1).trim());
    }

    public Double getTotalCalculatedPricePerProduct() {
        return (Double.parseDouble(itemTotalPrices.get(0).getText().substring(1).trim())) * Integer.parseInt(productQuantities.get(0).getAttribute("value"));
    }

    public Double getTotalPricePerProduct(){
        return Double.parseDouble(itemTotalPrices.get(0).getText().substring(1).trim());
    }

    public void clickCheckoutButton(){
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();
    }

}
