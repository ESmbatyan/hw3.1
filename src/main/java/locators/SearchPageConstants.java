package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPageConstants {
    public By item_name = By.xpath("//div[@class='product-grid-image']/following-sibling::p");
    public By item_icon = By.className("product-grid-item");
}
