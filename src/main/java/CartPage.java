import dev.failsafe.internal.util.Assert;
import locators.CartPageConstants;
import locators.ProductPageConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CartPage {
    private WebDriver driver;

    CartPageConstants pageConstants = new CartPageConstants();

    public CartPage(WebDriver driver){
        this.driver = driver;
    }


    public void CheckAddFunctionality(String searchVal){
        String text = driver.findElement(pageConstants.addedProduct).getText();
        assert(text.toLowerCase().contains(searchVal));
    }

    public void pressPlus(){
        WebElement plus = driver.findElement(pageConstants.plusButton);
        plus.click();
    }
}
