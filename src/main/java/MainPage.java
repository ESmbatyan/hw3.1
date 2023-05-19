import locators.MainPageConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import javax.lang.model.element.Element;

public class MainPage {
    private WebDriver driver;
    MainPageConstants pageConstants = new MainPageConstants();


    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public SearchPage search(String searchText){
        driver.findElement(pageConstants.search_field).sendKeys(searchText);
        driver.findElement(pageConstants.search_icon).click();
        return new SearchPage(driver);
    }

    public RegisterPage register(){
        driver.findElement(pageConstants.register_button).click();
        return new RegisterPage(driver);
    }

    public WebElement checkLogout(){
        return driver.findElement(pageConstants.logout_button);
    }
}
