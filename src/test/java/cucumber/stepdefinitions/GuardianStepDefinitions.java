package cucumber.stepdefinitions;

import framework.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import pageobjects.GooglePage;
import pageobjects.GuardianHomePage;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static framework.BaseClass.driver;

public class GuardianStepDefinitions {

    private final GuardianHomePage guardianHomePage;
    private final GooglePage googleHomePage;

    public String article;

    public GuardianStepDefinitions() {
        guardianHomePage = new GuardianHomePage(driver);
        googleHomePage = new GooglePage(driver);
    }


    @Given("I launch the Guardian new url")
    public void launchUrlAndNavigateToSection() {
        driver.get(" https://www.theguardian.com/tone/news");
    }

    @When("I select the first news in the guardians portal")
    public void selectFirstNews() {
//        guardianHomePage.clickYesImHappy();
         article = guardianHomePage.getFirstArticleText();
    }

    @When("Search in google with the first news")
    public void searchInGoogle() {
        driver.executeScript("window.open()");

        // Switch to new tab
        String currentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        driver.get("https://www.google.com");

        // Click on the "Read More" button until the "Privacy" element is visible
        googleHomePage.clickReadMoreButton();
        googleHomePage.clickReadMoreButton();

        googleHomePage.clickAcceptAllButton();
        googleHomePage.searchNews(article);

    }

    @Then("I should see two or more article on same topic getting displayed")
    public void assertArticlesDisplayed() {
        googleHomePage.aasertNewsIsValid();
    }

}
