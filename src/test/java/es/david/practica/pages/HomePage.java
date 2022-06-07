package es.david.practica.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class HomePage extends AbstractPage {

    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=common/home";

    @FindBy(xpath = "//h3[contains(text(), 'Featured')]")
    private WebElement featured;

    @FindBy(className = "product-layout")
    private List<WebElement> products;

    @FindBy(className = "swiper-viewport")
    private List<WebElement> carousels;

    @FindBy(xpath = "//button[contains(@onclick, 'cart.add')]")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//div[contains(@class, 'caption')]//descendant::a")
    private List<WebElement> itemNames;

    private List<String> itemsNamesAdded = new ArrayList<>();

    HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    public boolean isFeaturedDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(featured)).isDisplayed();
        } catch (NoSuchElementException ns) {
            return false;
        }
    }

    public int getNumberOfProducts() {
        wait.until(ExpectedConditions.visibilityOf(products.get(0)));
        return products.size();
    }

    public boolean isProductsCarouselDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(carousels.get(0))).isDisplayed();
        } catch (NoSuchElementException ns) {
            return false;
        }
    }

    public boolean isCompaniesCarouselDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(carousels.get(1))).isDisplayed();
        } catch (NoSuchElementException ns) {
            return false;
        }
    }

    // Este método no me gusta, quiero hacerlo mejor
    public void addItemsToCart() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(addToCartButtons.get(0)));
        for (int i = 0; i < addToCartButtons.size(); i++) {
            addToCartButtons.get(i).click();
            itemsNamesAdded.add(itemNames.get(i).getText());
            Thread.sleep(3000);
        }

    }

    public List<String> getItemAddedNames() {
        return itemsNamesAdded;
    }

}
