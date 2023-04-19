
import framework.AppiumDriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"cucumber.stepdefinitions"},
        tags = "@ValidateFirstNews",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class AppiumTestRunner {
    private static AppiumDriverLocalService service;

    @BeforeClass
    public static void startAppiumServerAndDriver() {

        // Set the Appium server options
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withArgument(GeneralServerFlag.LOG_LEVEL, "error");

        // Start the Appium server
        service = builder.build();
        service.start();

        AppiumDriverManager.getDriver(service);
    }

    @AfterClass
    public static void stopAppiumServerAndDriver() {
        // Quit the Appium driver
        AppiumDriverManager.quitDriver();

        // Stop the Appium server
        if (service != null) {
            service.stop();
        }
    }
}
