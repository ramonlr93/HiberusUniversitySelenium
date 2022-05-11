package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Slf4j
public class InventoryPage extends AbstractPage {
    public static final String PAGE_URL = "https://www.saucedemo.com";

    @FindBy(xpath = "//div[@class='inventory_item_description']")
    private List<WebElement> inventoryItems;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortProductBtn;


//    @FindBy(id = "react-burger-menu-btn")
//    private WebElement menuBtn;

    InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void clickAddToCartButton(String itemName) {
        for (WebElement elm : inventoryItems) {
            elm.findElement(By.xpath("//button[contains(@id='add-"+itemName+"')]")).click();
        }
    }

    public void clickRemoveCartButton(String itemName) {
        for (WebElement elm : inventoryItems) {
            elm.findElement(By.xpath("//button[contains(@id='remove-"+itemName+"')]")).click();
        }
    }

    public void sortItemsBy(String order) {
        sortProductBtn.click();
        sortProductBtn.findElement(By.xpath("//option[@value='"+order+"']")).click();
    }

}
