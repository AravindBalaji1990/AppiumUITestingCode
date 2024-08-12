package testngassertion;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AssertionDemo {
    @Test
    public void testcaseAssertionEquals() throws InterruptedException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setCapability("PlatformVersion", "12");

//        options.setPlatformVersion("12");
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));


        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        Thread.sleep(5000);

        String textvalue = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"NFC\"]")).getText();

        Assert.assertEquals(textvalue,"NFC","The match has failed");
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"NFC\"]")).isDisplayed(),"The webelemet is not available");
        Assert.assertFalse(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"NFC\"]")).isDisplayed(),"The webelemet is not available");
    }
}
