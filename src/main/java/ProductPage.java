import locators.ProductPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;

    ProductPageConstants pageConstants = new ProductPageConstants();

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void addToCart(){
        driver.findElement(pageConstants.add_button).click();
    }


}
