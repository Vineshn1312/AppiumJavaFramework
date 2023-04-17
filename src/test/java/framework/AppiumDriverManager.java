package framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverManager {

    public static AppiumDriver getDriver() {
        if (BaseClass.driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
                caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                BaseClass.driver = new AndroidDriver(url, caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
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
