package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
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
}
