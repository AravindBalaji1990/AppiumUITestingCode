package handlingappiumwithsaucelab;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabDemoRun {
    IOSDriver driver;
    @BeforeSuite
    public void startTest() throws MalformedURLException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:app", "storage:filename=iOS.RealDevice.SauceLabs.Mobile.Sample.app.2.7.1.ipa");
        caps.setCapability("appium:platformVersion", "17.4.1");// The filename of the mobile app
        caps.setCapability("appium:deviceName", "iPhone_XR_free");
        caps.setCapability("appium:automationName", "XCUITest");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "oauth-aravindbalaji.balaji7-a4059");
        sauceOptions.setCapability("accessKey", "6a47b00e-a763-47fd-a2c1-bcc8e61070a8");
        sauceOptions.setCapability("build", "appium-build-XJJ43");
        sauceOptions.setCapability("name", "Demo Mobile Automation Run");
        sauceOptions.setCapability("appiumVersion", "2.0.0");
        caps.setCapability("sauce:options", sauceOptions);

        // Start the session
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new IOSDriver(url, caps);
    }

    @Test
    public void testcase() throws InterruptedException {
        // replace with commands and assertions
        Thread.sleep(5000);




    }


    @AfterSuite
    public void endTest(){
        // end the session
        String jobStatus = "passed"; // or "failed"
        driver.executeScript("sauce:job-result=" + jobStatus);
        driver.quit();
    }
}
