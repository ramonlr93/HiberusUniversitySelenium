package com.opencart.pages;

import com.opencart.utils.Enums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=common/home";

    @FindBy(xpath = "//div[@class='product-thumb transition']")
    private List<WebElement> featuredItems;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // GETTERS & SETTERS
    @Override
    public WebElement getPageLoadedTestElement() {
        return featuredItems.get(0);
    }


    // METODOS
    public void addItemToCart(Enums.HomePageItems selected) {
        for (WebElement item : featuredItems) {
            try {
                String itemName = item.findElement(By.xpath("./descendant::h4/a")).getText();
                if (itemName.equals(selected.value()))
                    item.findElement(By.xpath("./descendant::button")).click();

            } catch (Exception ignore) {
            }
        }
    }
}
