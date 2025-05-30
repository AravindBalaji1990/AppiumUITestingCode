package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class HandlingClickAndSendkeys_IOS {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setUdid("27139D21-EB13-48EE-9C88-C786E92AB0E0");
        options.setPlatformName(AutomationName.IOS_XCUI_TEST);
        options.setBundleId("com.saucelabs.mydemoapp.rn");

        // calling the andorid driver to run the app
        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"tab bar option menu\"]")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name=\"menu item log in\"]")).click();
        Thread.sleep(5000);


        driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Username input field\"]")).sendKeys("bob@example.com");
        Thread.sleep(5000);

        driver.findElement(AppiumBy.xpath("//XCUIElementTypeSecureTextField[@name=\"Password input field\"]")).sendKeys("10203040");
        Thread.sleep(5000);

        driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name=\"Login button\"]")).click();
        Thread.sleep(5000);

        driver.quit();
    }

}
