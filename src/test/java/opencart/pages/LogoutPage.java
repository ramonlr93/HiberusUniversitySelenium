package opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BasePage {

    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/logout";

    public LogoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }
}
