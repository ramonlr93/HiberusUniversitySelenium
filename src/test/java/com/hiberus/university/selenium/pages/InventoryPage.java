package com.hiberus.university.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class InventoryPage extends BasePage {
    public static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

    @FindBy(xpath = "//button[text()='Open Menu']")
    private WebElement hamburgerElem;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCart;

    //@FindBy(css = "#inventory_item")
    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryContainer;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> inventoryItemNameList;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> inventoryItemPriceList;

    @FindBy(className = "product_sort_container")
    private WebElement productSortContainerSelect;

    @FindBy(xpath = "//button[contains(@id, 'add-to-cart')]")
    private List<WebElement> addToCartButton;

    @FindBy(xpath = "//button[contains(@id, 'remove')]")
    private List<WebElement> removeButton;

    InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return inventoryContainer.get(0);
    }

    public int getInventoryContainerSize(){
        return inventoryContainer.size();
    }

    public void clickOnShoppingCart(){
        shoppingCart.click();
    }

    public void sortSelectOption(String option){
        Select selectOption = new Select(productSortContainerSelect);
        selectOption.selectByValue(option);
    }

    public boolean itemPresentByName(String itemName){
        boolean isProductPresent = false;
        for (WebElement webElement : inventoryContainer) {
            if (webElement.getText().equals(itemName)) {
                isProductPresent = true;
                break;
            }
        }
        return isProductPresent;
    }

    public boolean cartIsPresent(){
        return shoppingCart.isDisplayed();
    }

    public int getNumberInCart(){
        try{
            return Integer.parseInt(shoppingCart.getText());
        } catch (NoSuchElementException findCart){
            return 0;
        }
    }

    public void getRandomAndClick(int itemNumber, String option){
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        int getRandom;

        for (int i=0; i< itemNumber; i++) {
            //System.out.println("Ramdon: "+ getRandom +" "+ random);
            getRandom = (int) Math.floor(Math.random() * inventoryContainer.size());

            while (posiciones.contains(getRandom)) {
                getRandom = (int) Math.floor(Math.random() * inventoryContainer.size());
            }
            posiciones.add(getRandom);
            getButtonByOption(option);
        }
    }

    private void clickButton(String xpath) {
        WebElement itemElem = getDriver().findElement(By.xpath(xpath));
        itemElem.click();
    }

    public void getButtonByName(String itemName, String option) {
        if (option.equals("add")){
            option = "add-to-cart";
        }else {
            option = "remove";
        }
        String xpathName = itemName.replace(" ", "-").toLowerCase();
        String xpath = String.format("//button[@data-test='" + option +"-" + xpathName + "']");
        clickButton(xpath);
    }

    public void getButtonByOption(String option) {
        if (option.equals("add")){
            option = "add-to-cart";
        }else {
            option = "remove";
        }

        String xpath = String.format("//button[contains(@id, '"+ option +"')]");
        clickButton(xpath);
    }

    public List<String> getItemNameList(){
        List<String> textOrder = new ArrayList<String>();

        for (WebElement webElement : inventoryItemNameList) {
            textOrder.add(webElement.getText());
        }
        return textOrder;
    }

    public List<Float> getItemPriceList(){
        List<Float> textOrder = new ArrayList<Float>();

        for (WebElement webElement : inventoryItemPriceList) {
            String text = webElement.getText();
            textOrder.add(Float.parseFloat(text.substring(text.indexOf("$") + 1)));
        }

        return textOrder;
    }

    public void logout(){
        hamburgerElem.click();
        getDriver().findElement(By.id("logout_sidebar_link")).click();
    }

}
