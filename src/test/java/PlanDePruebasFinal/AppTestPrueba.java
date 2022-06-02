 package PlanDePruebasFinal;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


/**
 * Unit test for simple App.
 */
public class AppTestPrueba
{

    public static WebDriver driver;

    public static WebDriverWait wait;
    public static Actions actions;

    @BeforeClass  //Iniciializar valores para todas las pruebas
    public static void setUpClass() { System.out.println("Primera linea @BeforeClass"); }

    //@Before
    //public void setUp() { "Segunda linea @Before" };


    @Before
    public void setUpPrueba() {
        WebDriverManager.chromedriver().setup();

        //String userProfile = "C:\\Users\\Flores\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("user-data-dir=" + userProfile)
        //driver = new ChromeDriver(options);

        driver =  new ChromeDriver();
        //driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);
        actions = new Actions(driver);
    }

    /**
     * Rigorous Test :-)
     */

    @Test
    @Ignore
    public void testLoginPrueba() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_use");
        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));

        //Validacion
        String url = driver.getCurrentUrl();
        Assert.assertEquals("PRUEBA FALLIDA - El login es fallido porque no hemos accedido a la url indicada en los requisitos",
                "https://www.saucedemo.com/inventory.html", url);
    }

    @Test
    @Ignore
    public void testLoginIncorrectoPrueba() throws  InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();

        //Validacion
        boolean isMenssageErrorVisible;
        try{
            /**wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                    By.xpath("//div[@class='error-message-container error']"))));**/

            isMenssageErrorVisible = driver.findElement(
                    By.xpath("//div[@class='error-message-container error']")).isDisplayed();

        } catch (NoSuchElementException find){
            isMenssageErrorVisible = false;
        }

        Assert.assertTrue("PRUEBA FALLIDA - El elemento error no aparece", isMenssageErrorVisible);
    }

    @Test
    @Ignore
    public void testArrayEqualsTrue() throws InterruptedException {
        String[] nombresEsperados = {"Manuel", "Manolo"};
        String[] nombresActuales = {"Manuel", "Manolo"};

        System.out.println("Primer test");

        Assert.assertArrayEquals("Fallo - No son los mismos nombres", nombresEsperados, nombresActuales);
    }

    @Test
    @Ignore
    public void testArrayEqualsFalse() throws InterruptedException {
        String[] nombresEsperados = {"Manuel", "M"};
        String[] nombresActuales = {"Manuel", "Manolo"};

        Assert.assertArrayEquals("Fallo - No son los mismos nombres", nombresEsperados, nombresActuales);
    }

    @Test
    @Ignore
    public void testEqualsTrue() throws InterruptedException {
        Assert.assertEquals("Fallo - No son los mismos valores", (1 + 1), 2);
    }

    @Test
    @Ignore
    public void testEqualsFalse() throws InterruptedException {
        Assert.assertEquals("Fallo - No son los mismos valores", (1 + 1), 3);
    }

    @Test
    @Ignore
    public void testFalse() throws InterruptedException {
        boolean input = false;
        Assert.assertFalse("Fallo - No son los mismos valores", input);
    }

    @Test
    @Ignore
    public void testTrue() throws InterruptedException {
        boolean input = true;
        Assert.assertTrue("Fallo - No son los mismos valores", input);
    }

    @Test
    @Ignore
    public void aceptarPopUp() throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");
        driver.findElement(By.xpath("//h4[@class='card-title']/a[@href='prod.html?idp_=1']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@onclick='addToCart(1)']"))));
        driver.findElement(By.xpath("//a[@onclick='addToCart(1)']")).click();

        wait.until((ExpectedConditions.alertIsPresent()));
        Alert alert = driver.switchTo().alert();

        String text = alert.getText();
        System.out.println(text);

        alert.accept();
    }

    @Test
    @Ignore
    public void clicDerecho() throws InterruptedException {
        driver.get("https://www.the-internet.herokuapp.com/context_menu");

        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@onclick='addToCart(1)']"))));
        driver.findElement(By.xpath("//a[@onclick='addToCart(1)']")).click();

        wait.until((ExpectedConditions.alertIsPresent()));
        Alert alert = driver.switchTo().alert();

        String text = alert.getText();
        System.out.println(text);

        alert.accept();
    }

    @Test
    @Ignore
    public void dobleClic() throws InterruptedException {
        driver.get("https://demoqa.com/buttons/");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("doubleClickBtn"))));
        actions.contextClick(driver.findElement(By.id("doubleClickBtn"))).perform();
    }

    @Test
    @Ignore
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demoqa.com/droppable/");

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("draggable"))));

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(draggable, droppable).perform();

    }

    @After
    public void tearDown() {
        driver.close();
    }
}
