import locators.RegisterPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage {
    private WebDriver driver;

    RegisterPageConstants pageConstants = new RegisterPageConstants();

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getRecaptcha(){
        return driver.findElements(pageConstants.recaptcha);
    }
    public String testEmail = System.currentTimeMillis() + "@gmail.com";
    public void testErrorMessage(){
        driver.findElement(By.className("form-error"));
    }
    public void testCredentialsValid(){
        driver.findElement(pageConstants.input_first_name).sendKeys("name_test");
        driver.findElement(pageConstants.input_last_name).sendKeys("last_name_test");
        driver.findElement(pageConstants.input_email).sendKeys(testEmail);
        driver.findElement(pageConstants.input_password).sendKeys("password_test", Keys.ENTER);
    }

    public void testCredentialsInNonMentionedEmail(){
        driver.findElement(pageConstants.input_first_name).sendKeys("name_test");
        driver.findElement(pageConstants.input_last_name).sendKeys("last_name_test");
        driver.findElement(pageConstants.input_email).sendKeys("");
        driver.findElement(pageConstants.input_password).sendKeys("password_test", Keys.ENTER);
    }
    public void testCredentialsInNonMentionedPassword(){
        driver.findElement(pageConstants.input_first_name).sendKeys("name_test");
        driver.findElement(pageConstants.input_last_name).sendKeys("last_name_test");
        driver.findElement(pageConstants.input_email).sendKeys(testEmail);
        driver.findElement(pageConstants.input_password).sendKeys("", Keys.ENTER);
    }
    public void testCredentialsIsShortPassword(){
        driver.findElement(pageConstants.input_first_name).sendKeys("name_test");
        driver.findElement(pageConstants.input_last_name).sendKeys("last_name_test");
        driver.findElement(pageConstants.input_email).sendKeys(testEmail);
        driver.findElement(pageConstants.input_password).sendKeys("123", Keys.ENTER);
    }
    public void testCredentialsIsLongPassword(){
        driver.findElement(pageConstants.input_first_name).sendKeys("name_test");
        driver.findElement(pageConstants.input_last_name).sendKeys("last_name_test");
        driver.findElement(pageConstants.input_email).sendKeys(testEmail);
        driver.findElement(pageConstants.input_password).sendKeys("123456798123456789123456789123456789123456789123456789", Keys.ENTER);
    }
    public void testCredentialsNoUsername(){
        driver.findElement(pageConstants.input_first_name).sendKeys("");
        driver.findElement(pageConstants.input_last_name).sendKeys("last_name_test");
        driver.findElement(pageConstants.input_email).sendKeys(testEmail);
        driver.findElement(pageConstants.input_password).sendKeys("12345", Keys.ENTER);
    }

}
