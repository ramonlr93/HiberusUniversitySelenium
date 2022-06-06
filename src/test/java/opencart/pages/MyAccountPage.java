package opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage{

    public static final String PAGE_URL = "https://opencart.abstracta.us/index.php?route=account/account";

    @FindBy(xpath = "//ul[@class = 'list-unstyled']//child:: a[text() = 'Edit Account']")
    private WebElement editAccountButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return editAccountButton;
    }
}
