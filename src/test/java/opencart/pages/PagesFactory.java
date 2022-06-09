package opencart.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class PagesFactory {
  private static PagesFactory pagesFactories;
  private final WebDriver driver;
  private final HomePage homePage;
  private final TopButtons topButtons;
  private final RegistrationPage registrationPage;
  private final LoginPage loginPage;
  private final MyAccountPage myAccountPage;
  private final ForgottenPasswordPage forgottenPasswordPage;
  private final PhonesAndPdasPage phonesAndPdasPage;
  private final CheckoutPage checkoutPage;
  private final LogoutPage logoutPage;

  private PagesFactory(WebDriver driver) {
    this.driver = driver;
    homePage = new HomePage(driver);
    topButtons = new TopButtons(driver);
    registrationPage = new RegistrationPage(driver);
    loginPage = new LoginPage(driver);
    myAccountPage = new MyAccountPage(driver);
    forgottenPasswordPage = new ForgottenPasswordPage(driver);
    phonesAndPdasPage = new PhonesAndPdasPage(driver);
    checkoutPage = new CheckoutPage(driver);
    logoutPage = new LogoutPage(driver);
  }

  public static void start(WebDriver driver) {
    pagesFactories = new PagesFactory(driver);
  }

  public static PagesFactory getInstance() {
    return pagesFactories;
  }

  public WebDriver getDriver() {
    return driver;
  }
}
