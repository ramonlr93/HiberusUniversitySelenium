package es.david.practica.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage extends AbstractPage{

    public static final String PAGE_URL = "http://opencart.abstracta.us/index.php?route=account/success";

    AccountSuccessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

}
