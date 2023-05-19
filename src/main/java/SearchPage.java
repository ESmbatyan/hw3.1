import locators.SearchPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {
    private WebDriver driver;

    SearchPageConstants pageConstants = new SearchPageConstants();


    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getResults(){
        return driver.findElements(pageConstants.item_name);
    }

    public ProductPage goToProduct(){
        WebElement first_results = driver.findElements(pageConstants.item_icon).get(0);
        first_results.click();
        return new ProductPage(driver);
    }
}
