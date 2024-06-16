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

    AndroidDriver driver;

    @BeforeTest
    public void start() throws MalformedURLException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=android-app.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "12.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "oauth-aravindbalajiv3-ca23c");
        sauceOptions.setCapability("accessKey", "4ab43b01-1139-4a97-9aa0-b5ef04ebb828");
        sauceOptions.setCapability("build", "appium-build-3ETTC");
        sauceOptions.setCapability("name", "<your test name>");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new AndroidDriver(url, caps);
    }

    @Test
    public void testcase() {

        System.out.println("this is inside the @test");
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Views\").instance(0))"));
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Views']"));
        element.click();

    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
