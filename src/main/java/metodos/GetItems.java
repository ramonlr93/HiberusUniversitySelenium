package metodos;

import common.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GetItems {

    public static WebDriver driver;
    public static WebDriverWait pausa;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + Constants.userProfile);

        driver = new ChromeDriver(options);
        pausa = new WebDriverWait(driver, 10, 1000);
        driver.manage().window().maximize();


    }

    public static void getAddToChartButtons() {
        System.out.printf("");
    }
}
