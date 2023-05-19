package locators;

import org.openqa.selenium.By;

public class CartPageConstants {
    public By addedProduct = By.xpath("//*[@id=\"ajaxifyCart\"]/form/div[1]/div/div[1]/div/div[2]");
    public By plusButton = By.xpath("\"//*[@id=\\\"ajaxifyCart\\\"]/form/div[1]/div/div[2]/div/div[1]/div/span[1]\"");
    public By minusButton = By.className("ajaxifyCart--qty-adjuster ajaxifyCart--minus");
}
