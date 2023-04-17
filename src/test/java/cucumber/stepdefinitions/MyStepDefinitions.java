package cucumber.stepdefinitions;

import framework.AppiumDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;

public class MyStepDefinitions {

    private LoginPage loginPage;

    public MyStepDefinitions() {
        loginPage = new LoginPage(AppiumDriverManager.getDriver());
    }


    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() {

    }

    @When("^I enter my username and password$")
    public void iEnterMyUsernameAndPassword() {

    }

    @Then("^I should see the home screen$")
    public void iShouldSeeTheHomeScreen() {

    }

}
