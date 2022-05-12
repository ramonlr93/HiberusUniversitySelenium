package com.hiberus.university.selenium.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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

    InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    private String getButton(String itemName) {
        return "//div[contains(., '" + itemName + "')]/parent::a/parent::div/following-sibling::div/button";
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

    public boolean sortFromAToZ(){
        List <String> defaultNames = new ArrayList<String>();
        List <String> namesAZ = new ArrayList<String>();

        sortOption("az");

        List<WebElement> sortedItemNames = getDriver().findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_name']"));

        for (int i=0;i<itemNames.size();i++){
            defaultNames.add(itemNames.get(i).getText());
            namesAZ.add(sortedItemNames.get(i).getText());
        }

        Collections.sort(defaultNames);

        return defaultNames.equals(namesAZ);
    }

    public boolean sortFromZToA(){
        List <String> defaultNames = new ArrayList<String>();
        List <String> namesZA = new ArrayList<String>();

        sortOption("za");

        List<WebElement> sortedItemNames = getDriver().findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_name']"));

        for (int i=0;i<itemNames.size();i++){
            defaultNames.add(itemNames.get(i).getText());
            namesZA.add(sortedItemNames.get(i).getText());
        }

        Collections.sort(defaultNames, Collections.reverseOrder());

        return defaultNames.equals(namesZA);
    }

    public boolean sortFromLoToHi(){
        List <Double> defaultNames = new ArrayList<Double>();
        List <Double> namesLoHi = new ArrayList<Double>();

        sortOption("lohi");

        List<WebElement> sortedItemNames = getDriver().findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']"));

        for (int i=0;i<itemNames.size();i++){
            defaultNames.add(Double.parseDouble(itemPrices.get(i).getText().substring(1)));
            namesLoHi.add(Double.parseDouble(sortedItemNames.get(i).getText().substring(1)));
        }

        Collections.sort(defaultNames);

        return defaultNames.equals(namesLoHi);
    }

    public boolean sortFromHiToLo(){
        List <Double> defaultNames = new ArrayList<Double>();
        List <Double> namesHiLo = new ArrayList<Double>();

        sortOption("hilo");

        List<WebElement> sortedItemNames = getDriver().findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_price']"));

        for (int i=0;i<itemNames.size();i++){
            defaultNames.add(Double.parseDouble(itemPrices.get(i).getText().substring(1)));
            namesHiLo.add(Double.parseDouble(sortedItemNames.get(i).getText().substring(1)));
        }

        Collections.sort(defaultNames, Collections.reverseOrder());

        return defaultNames.equals(namesHiLo);
    }


}
