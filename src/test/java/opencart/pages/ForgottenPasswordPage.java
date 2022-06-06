package opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgottenPasswordPage extends BasePage{

    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/forgotten";

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    public ForgottenPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return inputEmail;
    }
}
