package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class InventoryPage extends AbstractPage {

    public static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

    @FindBy(className = "btn btn_primary btn_small btn_inventory")
    private List <WebElement> addToCartButtons;

    @FindBy(className = "btn btn_secondary btn_small btn_inventory")
    private List <WebElement> removeItemFromCartButtons;

    @FindBy(xpath = "//select[@data-test = 'product_sort_container']")
    private WebElement filtre;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCart;

    @FindBy(xpath = "//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_name']")
    private List <WebElement> itemNames;

    @FindBy(xpath = "//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']")
    private List <WebElement> itemPrices;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return filtre;
    }


    private String getButton(String itemName) {
        return "//div[contains(., '" + itemName + "')]/parent::a/parent::div/following-sibling::div/button";
    }

    public List<String> getItemNames(){
        List<String> names = new ArrayList<String>();
        for(int i=0;i<itemNames.size();i++){
            names.add(itemNames.get(i).getText());
        }
        return names;
    }

    public List<Double> getItemPrices(){
        List<Double> prices = new ArrayList<Double>();
        for(int i=0;i<itemPrices.size();i++){
            prices.add(Double.parseDouble(itemPrices.get(i).getText().substring(1)));
        }
        return prices;
    }

    public int getNumberOfItems(){
        return itemNames.size();
    }

    public boolean findItemByName(String name){
        String xpath = getButton(name);
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));
        return itemElem.isDisplayed();
    }

    public void addItemToCartByName(String name){
        String xpath = getButton(name);
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));
        itemElem.click();
    }

    public void removeItemFromCart(String name){
        String xpath = getButton(name);
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));
        itemElem.click();
    }

    public void clickOnCheckout(){
        checkoutButton.click();
    }

    public void clickOnShoppingCart() {
        shoppingCart.click();
    }

    public void sortOption(String option) {
        Select selectFiltre = new Select(filtre);
        selectFiltre.selectByValue(option);
    }

    public String getShoppingCartNumber(){
        return shoppingCart.getText();
    }

    // MI SORT

    public List<String> sortFromAToZ(){
        List <String> namesAZ = new ArrayList<String>();

        List<WebElement> sortedItemNames = getDriver().findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_name']"));

        for (int i=0;i<itemNames.size();i++){
            namesAZ.add(sortedItemNames.get(i).getText());
        }

        return namesAZ;
    }

    public List<String> sortFromZToA(){
        List <String> namesZA = new ArrayList<String>();

        List<WebElement> sortedItemNames = getDriver().findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_name']"));

        for (int i=0;i<itemNames.size();i++){
            namesZA.add(sortedItemNames.get(i).getText());
        }

        return namesZA;
    }

    public List<Double> sortFromLoToHi(){
        List <Double> pricesLoHi = new ArrayList<Double>();

        List<WebElement> sortedItemNames = getDriver().findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']"));

        for (int i=0;i<itemPrices.size();i++){
            pricesLoHi.add(Double.parseDouble(sortedItemNames.get(i).getText().substring(1)));
        }

        return pricesLoHi;
    }

    public List<Double> sortFromHiToLo(){
        List <Double> pricesHiLo = new ArrayList<Double>();

        List<WebElement> sortedItemNames = getDriver().findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']"));

        for (int i=0;i<itemPrices.size();i++){
            pricesHiLo.add(Double.parseDouble(sortedItemNames.get(i).getText().substring(1)));
        }

        return pricesHiLo;
    }


}
