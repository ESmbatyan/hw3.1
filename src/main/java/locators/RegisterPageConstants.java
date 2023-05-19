package locators;

import org.openqa.selenium.By;

public class RegisterPageConstants {
    public By input_first_name = By.id("first_name");
    public By input_last_name = By.id("last_name");
    public By input_email = By.id("email");
    public By input_password = By.id("create_password");

    public By error_message = By.className("form-error");
    public By recaptcha = By.className("g-recaptcha");
}
