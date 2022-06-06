package com.hiberus.university.selenium.pages;


import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
//Clase para gestionar las distintas paginas
public class PagesFactory {

    private static PagesFactory pagesFactories;
    private final WebDriver driver;

    private final LoginPage loginPage;



    public PagesFactory(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);

    }

    public static void start(WebDriver driver) {
        pagesFactories = new PagesFactory(driver);
    }

    public static PagesFactory getInstance() {
        return pagesFactories;
    }

   //Getters
    public WebDriver getDriver() {
        return driver;
    }
}
