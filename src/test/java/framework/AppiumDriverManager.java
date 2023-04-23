package framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class AppiumDriverManager {

    public static AppiumDriver getDriver(AppiumDriverLocalService service) {
        if (BaseClass.driver == null) {


            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

            BaseClass.driver = new AndroidDriver(service.getUrl(), caps);
            BaseClass. driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        }
        return BaseClass.driver;
    }

    public static void quitDriver() {
        if (BaseClass.driver != null) {
            BaseClass.driver.close();
            BaseClass.driver = null;
        }
    }
}
