package pageobjects;

import framework.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    @AndroidFindBy(id = "username_field")
    private WebElement usernameField;

    @AndroidFindBy(id = "password_field")
    private WebElement passwordField;

    @AndroidFindBy(id = "login_button")
    private WebElement loginButton;

    public LoginPage(AppiumDriver driver) {
        super.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}

