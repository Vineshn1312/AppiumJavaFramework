package pageobjects;

import framework.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static framework.BaseClass.driver;

public class GooglePage {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = ".g .r a")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//div[text()='Weitere Informationen' or text()='Read more']")
    private WebElement readMoreButton;


    @FindBy(xpath = "//div[text()='Alle akzeptieren' or text()='Accept all']")
    private WebElement acceptAllButton;

    public void searchNews(String article) {
        searchBox.sendKeys("Similar news to " + article);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void aasertNewsIsValid() {
        if (searchResults.size() >= 2) {
            System.out.println("News is valid");
        } else {
            System.out.println("News is not valid");
        }
    }

    public boolean isAcceptAllButtonVisible() {
        try {
            WebElement acceptAllButton = driver.findElement(By.xpath("//div[text()='Alle akzeptieren' or text()='Accept all']"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(acceptAllButton));
            return acceptAllButton.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public void clickReadMoreButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", readMoreButton);
    }

    public void clickAcceptAllButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", acceptAllButton);
    }

    public GooglePage(AppiumDriver driver) {
        BaseClass.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
