package com.hiberus.university.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsInventoryPage extends AbstractPage {
    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=product/category&path=18";

    @FindBy(xpath = "//div[@class='product-thumb']")
    private List<WebElement> laptopsInventory;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement successMessage;


    LaptopsInventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public List<WebElement> getLaptopsList() {
        return laptopsInventory;
    }

    public List<String> getLaptopsNameList() {
        List<WebElement> LaptopName = new ArrayList<>();
        for (WebElement name : laptopsInventory) {
            LaptopName.add(name.findElement(By.xpath("./descendant::div[@class='caption']/descendant::a[contains(@href,'http://opencart.abstracta.us:80/index.php?route=product/product&path=18&product_id=')]")));
        }
        List<String> LaptopNam = new ArrayList<>();
        for (WebElement nameLap : LaptopName) {
            LaptopNam.add(nameLap.getText());
        }
        return LaptopNam;
    }

    public void clickLaptopsInventory() {
        wait.until(ExpectedConditions.visibilityOf(inventoryConteiner.findElement(By.xpath("./descendant::li[@class='dropdown'][2]/descendant::a[@class='dropdown-toggle']")))).click();
        wait.until(ExpectedConditions.visibilityOf(inventoryConteiner.findElement(By.xpath("./descendant::li[@class='dropdown open']/descendant::div[@class='dropdown-menu']/descendant::a[@class='see-all']")))).click();
    }

    public boolean isLaptopContains(String laptopName) {
        return getLaptopsNameList().contains(laptopName);
    }

    public void clickOnRandomLaptop(int number) {
        if (number > 0) {
            List<WebElement> randList = new ArrayList<>();
            for (WebElement elementLaptopsContainer : laptopsInventory) {
                randList.add(elementLaptopsContainer.findElement(By.xpath("./descendant::button[contains(@onclick,'cart.add')]")));
            }
            Collections.shuffle(randList);
            List<WebElement> subRandList = randList.subList(0, number);
            for (WebElement buttonLaptop : subRandList) {
                buttonLaptop.click();
            }
        } else {
            System.out.println("The number of laptops have to be more than zero and equal or more than the inventory list size");
        }
    }

    public boolean hasSuccessMessageLaptopInventory() {
        try {
            return successMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("The success message isnt displayed");
        }
        return false;
    }

    public void clickShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable((shoppingCart.findElement(By.xpath("./descendant::button[@type='button']"))))).click();

    }

    public void checkoutLink() {
        shoppingCart.findElement(By.xpath("./descendant::div[@class='btn-group btn-block open']/descendant::a[@href='https://opencart.abstracta.us:443/index.php?route=checkout/checkout']")).click();
    }
}

