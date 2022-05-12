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

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    private List<WebElement> addToCartButton;

    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small btn_inventory']")
    private List<WebElement> removeFromCart;

    @FindBy(xpath = "//select[data-test='product_sort_container']")
    private Select filter;

    @FindBy(xpath = "//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_name']")
    private List <WebElement> itemNames;

    @FindBy(id =  "shopping_cart_container")
    private WebElement shoppingCart;


    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    @Override
    public WebElement getPageLoadedTestElement() {

        return null;
    }

    public void addItem() {
        log.info("Adding item...");
        try {
            addToCartButton.get(0).click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking add: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking add, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    public void removeItem(String itemName) {
        log.info("Removing in...");
        try {
            removeFromCart.get(addToCartButton.indexOf(itemName)).click();
        } catch (TimeoutException e) {
            log.info("Timeout clicking remove: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            log.info("Clicking remove, caught exception, type: " + e.getClass().getSimpleName());
        }
    }

    private void sortByValue(String value) {
        log.info("Sorting...");
        switch (value) {
            case "az":
                sortFromAToZ("az");
                break;

            case "za":
                sortFromAToZ("za");
                break;

            case "lohi":
                sortFromLoToHi("lohi");
                break;

            case "hilo":
                sortFromHiToLo("hilo");
                break;

            default:
                log.info("Invalid parameter");
                break;
        }
    }

    private boolean sortFromAToZ(String value){
        List <String> defaultNames = new ArrayList<String>();
        List <String> namesAZ = new ArrayList<String>();

        filter.selectByValue(value);
        List<WebElement> sortedItemNames = getDriver().findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_name']"));

        for (int i=0;i<itemNames.size();i++){
            defaultNames.add(itemNames.get(i).getText());
            namesAZ.add(sortedItemNames.get(i).getText());
        }

        Collections.sort(defaultNames);

        return defaultNames == namesAZ;
    }

    private boolean sortFromZToA(String value){
        List <String> defaultNames = new ArrayList<String>();
        List <String> namesZA = new ArrayList<String>();

        filter.selectByValue(value);
        List<WebElement> sortedItemNames = getDriver().findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_name']"));

        for (int i=0;i<itemNames.size();i++){
            defaultNames.add(itemNames.get(i).getText());
            namesZA.add(sortedItemNames.get(i).getText());
        }

        Collections.sort(defaultNames, Collections.reverseOrder());

        return defaultNames == namesZA;
    }

    private boolean sortFromLoToHi(String value){
        List <Double> defaultNames = new ArrayList<Double>();
        List <Double> namesLoHi = new ArrayList<Double>();

        filter.selectByValue(value);
        List<WebElement> sortedItemNames = getDriver().findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_name']"));

        for (int i=0;i<itemNames.size();i++){
            defaultNames.add(Double.parseDouble(itemNames.get(i).getText().substring(1)));
            namesLoHi.add(Double.parseDouble(sortedItemNames.get(i).getText().substring(1)));
        }

        Collections.sort(defaultNames);

        return defaultNames == namesLoHi;
    }

    private boolean sortFromHiToLo(String value){
        List <Double> defaultNames = new ArrayList<Double>();
        List <Double> namesHiLo = new ArrayList<Double>();

        filter.selectByValue(value);
        List<WebElement> sortedItemNames = getDriver().findElements(By.xpath("//div[@class = 'inventory_list']/descendant::div[@class = 'inventory_item_name']"));

        for (int i=0;i<itemNames.size();i++){
            defaultNames.add(Double.parseDouble(itemNames.get(i).getText().substring(1)));
            namesHiLo.add(Double.parseDouble(sortedItemNames.get(i).getText().substring(1)));
        }

        Collections.sort(defaultNames, Collections.reverseOrder());

        return defaultNames == namesHiLo;
    }

}
