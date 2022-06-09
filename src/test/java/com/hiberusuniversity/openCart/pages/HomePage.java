package com.hiberusuniversity.openCart.pages;

import org.bouncycastle.jcajce.provider.symmetric.ChaCha;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.Locale;

public class HomePage extends BasePage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=common/home";

    @FindBy(xpath = "//div[@class='product-thumb transition']")
    private List<WebElement> featuredProducts;

    HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public void addProducts(String productName){
        for (WebElement element:featuredProducts) {
            if(element.findElement(By.xpath(".//div[@class='caption']//a")).getText().toLowerCase().equals(productName.toLowerCase())){
                JavascriptExecutor executor = (JavascriptExecutor)getDriver();
                executor.executeScript("arguments[0].click();", element.findElement(By.xpath(".//div[@class='button-group']//button[contains(@onclick,'cart.add')]")));
            }
        }
    }
}
