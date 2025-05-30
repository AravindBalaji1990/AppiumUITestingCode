package saucelablogin;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SaucelabsDemoRUn_AND {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Samsung.*");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "latest");
        sauceOptions.setCapability("username", "oauth-aravindsessionaravindbalaji-f3c16");
        sauceOptions.setCapability("accessKey", "b4b7bb95-f54d-49a9-8729-acb52cefe998");
        sauceOptions.setCapability("build", "appium-build-BKK4A");
        sauceOptions.setCapability("name", "Swag lab app testing");
        caps.setCapability("sauce:options", sauceOptions);

// Start the session
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).sendKeys("standard_user");
        Thread.sleep(3000);

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys("secret_sauce");
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")).click();
        Thread.sleep(3000);
// replace with commands and assertions
        Thread.sleep(5000);
        String jobStatus = "passed"; // or "failed"

// end the session
        driver.executeScript("sauce:job-result=" + jobStatus);
        driver.quit();
    }
}
