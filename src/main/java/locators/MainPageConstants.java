package locators;

import org.openqa.selenium.By;

public class MainPageConstants {
    public By search_field = By.name("q");
    public By register_button = By.id("customer_register_link");
    public By search_icon = By.className("icon-search");
    public By logout_button = By.id("customer_logout_link");

    public By input_first_name = By.className("site-header--meta-links");
}
