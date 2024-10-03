package saucelablogin;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class saucelabVirtualDevice {

    public static void main(String[] args) throws MalformedURLException {

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "15.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "2.11.0");
        sauceOptions.setCapability("username", "oauth-aravindbalajiv3-62cfb");
        sauceOptions.setCapability("accessKey", "af5f396c-7a4f-456b-9fd3-70debfff4981");
        sauceOptions.setCapability("build", "<your build id>");
        sauceOptions.setCapability("name", "<your test name>");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

// Start the session
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);

// run commands and assertions
        driver.get("https://www.saucedemo.com");
        String title = driver.getTitle();
        boolean titleIsCorrect = title.contains("Swag Labs");
        String jobStatus = titleIsCorrect ? "passed" : "failed";

// end the session
        driver.executeScript("sauce:job-result=" + jobStatus);
        driver.quit();
    }
}
