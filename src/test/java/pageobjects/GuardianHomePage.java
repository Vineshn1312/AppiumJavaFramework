package pageobjects;

import framework.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GuardianHomePage {

    public GuardianHomePage(AppiumDriver driver) {
        BaseClass.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//button[contains(@title, 'm happy')]")
    private WebElement yesImHappyButton;

    @FindBy(id = "//*[@id='top']/div[13]//div/div/section/section/div/div[1]/div/div/button/svg")
    private WebElement closePopUp;

    @FindBy(xpath = "//a[contains(@class,'js-headline-text')]")
    private WebElement firstArticle;

    public void clickYesImHappy() {
        try {
            yesImHappyButton.click();
        } catch (NoSuchElementException ex) {
            JavascriptExecutor executor = BaseClass.driver;
            executor.executeScript("arguments[0].click();", yesImHappyButton);
        }
    }

    public String getFirstArticleText() {
        return firstArticle.getText();
    }

}

