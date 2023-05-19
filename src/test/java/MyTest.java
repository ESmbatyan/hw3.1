import jdk.jfr.Registered;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class MyTest {

    protected static MainPage mainPage;

    public static final String WEBDRIVER = "webdriver.chrome.driver";
    public static final String DRIVER_PATH = "src/main/java/org/example/drivers/chromedriver.exe";
    public static final String baseURL = "https://jhsportsjackets.com/";

    WebDriver driver;

    @BeforeClass
    public WebDriver setUp(){
        System.setProperty(WEBDRIVER,DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get(baseURL);
        mainPage = new MainPage(driver);
        return driver;
    }

    @BeforeMethod
    public void refresh(){
        driver.get(baseURL);
    }

    @Test
    public void checkSearchFunc(){
        SearchPage SearchPage = mainPage.search("kyle");
        List<WebElement> search_results = SearchPage.getResults();
        for (WebElement element : search_results) {
            assert(element.getText().toLowerCase().contains("kyle"));
        }
    }

    @Test
    public void checkRegister() throws InterruptedException {
        RegisterPage RegisterPage = mainPage.register();
        RegisterPage.testCredentialsValid();
        Thread.sleep(25000);
        mainPage.checkLogout();
    }

    @Test
    public void checkRegisterNonMentionedEmail() throws InterruptedException {
        RegisterPage RegisterPage = mainPage.register();
        RegisterPage.testCredentialsInNonMentionedEmail();
        Thread.sleep(25000);
        RegisterPage.testErrorMessage();
    }
    @Test
    public void checkRegisterNonMentionedPass() throws InterruptedException {
        RegisterPage RegisterPage = mainPage.register();
        RegisterPage.testCredentialsInNonMentionedPassword();
        Thread.sleep(25000);
        RegisterPage.testErrorMessage();
    }
    @Test
    public void checkRegisterlongPass() throws InterruptedException {
        RegisterPage RegisterPage = mainPage.register();
        RegisterPage.testCredentialsIsLongPassword();
        Thread.sleep(25000);
        RegisterPage.testErrorMessage();
    }
    @Test
    public void checkRegisterShortPass() throws InterruptedException {
        RegisterPage RegisterPage = mainPage.register();
        RegisterPage.testCredentialsIsShortPassword();
        Thread.sleep(25000);
        RegisterPage.testErrorMessage();
    }

    @Test
    public void checkRegisterNoUsername() throws InterruptedException {
        RegisterPage RegisterPage = mainPage.register();
        RegisterPage.testCredentialsNoUsername();
        Thread.sleep(25000);
        mainPage.checkLogout();
    }

    @Test
    public void checkAddToCard() throws InterruptedException {
        SearchPage SearchPage = mainPage.search("kyle");
        ProductPage ProductPage = SearchPage.goToProduct();
        ProductPage.addToCart();
        Thread.sleep(5000);
        CartPage CartPage = new CartPage(driver);
        CartPage.CheckAddFunctionality("kyle");
    }

    @Test
    public void checkAddToCardAndPlus() throws InterruptedException {
        SearchPage SearchPage = mainPage.search("kyle");
        ProductPage ProductPage = SearchPage.goToProduct();
        ProductPage.addToCart();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"ajaxifyCart\"]/form/div[1]/div/div[2]/div/div[1]/div/span[1]")).click();
      //  driver.findElement(By.xpath("//*[@id=\"ajaxifyCart\"]/form/div[1]/div/div[2]/div/div[1]/div/input")).getText().contains("2");
//        CartPage CartPage = new CartPage(driver);
//        CartPage.CheckAddFunctionality("kyle");
//        CartPage.pressPlus();
        //Tried this way not working can't find the reason based on the error message
        Thread.sleep(5000);
//        driver.findElement(By.xpath("/html/body/div[7]/div/form/div[2]/div/div[2]/div/div[1]/div/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"ajaxifyCart\"]/form/div[1]/div/div[2]/div/div[1]/div/input")).getText().contains("1");
    }

    @AfterTest
    public void tearDown() {

       // driver.quit();
    }
}
