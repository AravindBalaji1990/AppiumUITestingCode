package handlingappiumwithsaucelab;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SaucelabAppiumIntegration {

    public AndroidDriver driver;
    String jobStatus = "failed"; // or "failed"

    @BeforeTest
    public void start() throws MalformedURLException, InterruptedException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=android-app.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "15.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "2.11.0");
        sauceOptions.setCapability("username", "oauth-aravindbalajiv3-62cfb");
        sauceOptions.setCapability("accessKey", "af5f396c-7a4f-456b-9fd3-70debfff4981");
        sauceOptions.setCapability("build", "Virtual DEvice from sauce lab");
        sauceOptions.setCapability("name", "API DEMOs Check");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

// Start the session
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new AndroidDriver(url, caps);


    }

    @Test
    public void testcase() throws InterruptedException {

        System.out.println("this is inside the @test");
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Views\").instance(0))"));
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Views']"));
        element.click();
        jobStatus = "passed";
        if (jobStatus == "passed") {
            driver.executeScript("sauce:job-result=" + jobStatus);
        } else {
            driver.executeScript("sauce:job-result=" + jobStatus);
        }

    }

    @AfterTest
    public void teardown() throws InterruptedException {

// end the session
        driver.quit();
    }
}
