package es.david.practica.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends AbstractPage {

    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=checkout/cart";

    @FindBy(xpath = "//form//descendant::td[contains(@class, 'text-left')]//child::a")
    private List<WebElement> itemNames;

    @FindBy(xpath = "//form//descendant::td[contains(text(), '$')][1]")
    private List<WebElement> itemPrices;

    @FindBy(xpath = "//strong[(text() = 'Total:')]//parent::td//following::td")
    private WebElement totalPrice;

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
        for (int i = 0; i < itemPrices.size(); i++) {
            sum += (Double.parseDouble(itemPrices.get(i).getText().substring(1).trim()));
        }
        return sum;
    }

    public Double getTotalPrice(){
        return Double.parseDouble(totalPrice.getText().substring(1).trim());
    }

}
