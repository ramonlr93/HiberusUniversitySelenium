package opencart.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class PhonesAndPdasPage extends BasePage{

    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=product/category&path=24";

    @FindBy(xpath = "//h2[text() = 'Tablets']")
    private WebElement h2Tablets;

    @FindBy(xpath = "//button[contains(@onclick, 'cart.add')]")
    private List<WebElement> listAddToCartButton;

    @FindBy(id = "cart-total")
    private WebElement cartText;

    @FindBy(xpath = "//button[@class = 'btn btn-inverse btn-block btn-lg dropdown-toggle']")
    private WebElement cartButton;

    @FindBy(xpath = "//td[@class = 'text-right' and contains(text(), 'x')]")
    private List<WebElement> cartInfoXProducts;

    @FindBy(xpath = "//button[@class = 'btn btn-danger btn-xs']")
    private List<WebElement> removeButtons;

    @FindBy(xpath = "//*[@id='cart']/ul/li[2]/div/p/a[2]")
    private WebElement checkoutOption;

    public PhonesAndPdasPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public WebElement getPageLoadedTestElement() {
        return h2Tablets;
    }

    public void addToCartRandomByNumber(int number){

        ArrayList<Integer> selectValue = new ArrayList<>();
        int pos;
        int count = 0;
        for(int  i = 0; i < listAddToCartButton.size(); i++) {
            pos = (int) Math.floor(Math.random() * listAddToCartButton.size());

            while (selectValue.contains(pos)) {
                pos = (int) Math.floor(Math.random() * listAddToCartButton.size());
            }

            if(count < number) {
                selectValue.add(pos);
                count++;
            }
        }

        // Añadir al carrito los articulos seleccionados al azar
        for(int i = 0; i < selectValue.size(); i++) {
            listAddToCartButton.get(selectValue.get(i)).click();
        }
    }

    public boolean cartTextContainsNumber(int number){
        wait.until(ExpectedConditions.visibilityOf(cartButton));
        String arr[] = cartText.getText().split(" ");
        System.out.print(arr[0]);
        if(arr[0].equals(String.valueOf(number))) return true;
        else return false;
    }

    public void addTheFirstProductManyTimes(int number){
        for(int i=0; i<number; i++) {
            listAddToCartButton.get(0).click();
        }
    }

    public void clickCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.sendKeys(Keys.ENTER);
    }

    public boolean getSameFirstProducts(int number){
        if(cartInfoXProducts.get(0).getText().equals("x " + number)) return true;
        else return false;
    }

    public void removeFirstItem(){
        removeButtons.get(0).click();
    }

    public void clickCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutOption));
        checkoutOption.click();
    }

}
