package framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverManager {

    public static AppiumDriver getDriver(AppiumDriverLocalService service) {
        if (BaseClass.driver == null) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

            BaseClass.driver = new AndroidDriver(service.getUrl(), caps);
        }
        return BaseClass.driver;
    }

    public static void quitDriver() {
        if (BaseClass.driver != null) {
            BaseClass.driver.quit();
            BaseClass.driver = null;
        }
    }
}
