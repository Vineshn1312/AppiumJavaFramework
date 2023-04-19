package cucumber.stepdefinitions;

import framework.AppiumDriverManager;
import framework.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;

public class MyStepDefinitions {

    private LoginPage loginPage;

    public MyStepDefinitions() {
        loginPage = new LoginPage(BaseClass.driver);
    }


    @Given("I launch the url and navigate to {string} section")
    public void launchUrlAndNavigateToSection(String section) {
        BaseClass.driver.get("https://www.theguardian.com");
    }

    @When("I select the first news in the guardians portal")
    public void selectFirstNews() {

    }

    @When("Search in google with the first news")
    public void searchInGoogle() {

    }

    @Then("I should see two or more article on same topic getting displayed")
    public void assertArticlesDisplayed() {

    }

}
