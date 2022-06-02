package es.david.practica.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class PagesFactory {

    private static PagesFactory pagesFactories;
    private final WebDriver driver;

    private final LoginPage loginPage;
    private final BasePage basePage;
    private final HomePage homePage;
    private final AccountPage accountPage;


    public PagesFactory(WebDriver driver) {
        this.driver = driver;

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        basePage = new BasePage(driver);
        accountPage = new AccountPage(driver);
    }

    public static void start(WebDriver driver) {
        pagesFactories = new PagesFactory(driver);
    }

    public static PagesFactory getInstance() {
        return pagesFactories;
    }


}
