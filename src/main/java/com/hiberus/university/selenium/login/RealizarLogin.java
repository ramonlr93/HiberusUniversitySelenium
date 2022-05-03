package com.hiberus.university.selenium.login;

import com.hiberus.university.selenium.pages.InventoryPage;
import com.hiberus.university.selenium.pages.LoginPage;
import com.hiberus.university.selenium.pages.PagesFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class RealizarLogin {

  public static WebDriver driver;

  public static void main(String[] args) {

    //Paso0
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();

    // Paso1
    PagesFactory.start(driver);
    driver.get(LoginPage.PAGE_URL);
    PagesFactory pf = PagesFactory.getInstance();
    LoginPage loginPage = pf.getLoginPage();
    loginPage.enterUsername("standard_user");
    loginPage.enterPassword("secret_sauce");
    loginPage.clickLogin();
    if (InventoryPage.PAGE_URL.equals(driver.getCurrentUrl())) {
      System.out.println("Test OK");
    } else {
      System.out.println("Test KO");
    }
    driver.close();
  }
}
