package saucelablogin;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SaucelabDEmoProject {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "iOS");//platform
        caps.setCapability("appium:app", "storage:filename=iOS.RealDevice.SauceLabs.Mobile.Sample.app.2.7.1.ipa");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "iPhone.*");
        caps.setCapability("appium:automationName", "XCUITest");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "2.0.0");
        sauceOptions.setCapability("username", "oauth-ravisankararavindbalaji-d7ef4");
        sauceOptions.setCapability("accessKey", "eb87203d-9b8e-4983-a952-10dc01c3ab72");
        sauceOptions.setCapability("build", "appium-build-BKK4A");
        sauceOptions.setCapability("name", "Test Run Batch");
        caps.setCapability("sauce:options", sauceOptions);


        // Start the session
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        IOSDriver driver = new IOSDriver(url, caps);

// replace with commands and assertions
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).sendKeys("standard_user");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys("secret_sauce");
//        String jobStatus = "passed"; // or "failed"
//
//// end the session
//        driver.executeScript("sauce:job-result=" + jobStatus);
        driver.quit();
    }
}
