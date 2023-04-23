import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest {

    public static final String WEBDRIVER = "webdriver.chrome.driver";
    public static final String DRIVER_PATH = "C:\\Users\\Asus\\IdeaProjects\\hw3.1\\src\\main\\java\\org\\example\\drivers\\chromedriver.exe";
    public static final String baseURL = "https://github.com/login";

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty(WEBDRIVER, DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void submitButtonTest() {
        driver.get(baseURL);
        WebElement submit = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        submit.click();
        String expectedUrl = "https://github.com/session";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    //It seems it is working ok but is not reading the right link
    @Test
    public void testCreateNewAccount() {
        driver.get(baseURL);
        WebElement submit = driver.findElement(By.cssSelector("a[data-ga-click=\"Sign in, switch to sign up\"]"));
        submit.click();
        String newUrl = "https://github.com/signup?return_to=https%3A%2F%2Fgithub.com%2Flogin&source=login";
        Assert.assertEquals(newUrl, driver.getCurrentUrl());
    }

    @Test
    public void testForgotPassword() {
        driver.get(baseURL);
        WebElement submit = driver.findElement(By.cssSelector("a.label-link.position-absolute.top-0.right-0[href=\"/password_reset\"]\n"));
        submit.click();
        String newUrl = "https://github.com/password_reset";
        Assert.assertEquals(newUrl, driver.getCurrentUrl());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
