package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class HandlingGesturesDemo_DoubleTapIOS {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 16");
        options.setForceAppLaunch(true);
//        options.setPlatformVersion("17.5");
        options.setUdid("08BBF8F2-37A6-42E0-AB9F-65C5E6AEC31B");
        options.setUseNewWDA(false);
        options.setPlatformName(AutomationName.IOS_XCUI_TEST);

        options.setBundleId("com.moataz.dailycheck");
//        options.setAppPackage("io.appium.android.apis");
//        options.setAppActivity("io.appium.android.apis.ApiDemos");

//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        // calling the andorid driver to run the app
        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

//        WebElement element = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView"));
        WebElement element = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"plus.circle\"]"));

        //Perform a double tap action
        Point location = element.getLocation();
        Dimension size = element.getSize();
        Point centerofelement = getCenterElement(location, size);


        PointerInput touchaction1 = new PointerInput(PointerInput.Kind.TOUCH, "fingertouch1");
        Sequence seq = new Sequence(touchaction1, 1)
                .addAction(touchaction1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerofelement))
                .addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(touchaction1, Duration.ofMillis(5000)))
                .addAction(touchaction1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(touchaction1, Duration.ofMillis(5000)))
                .addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(seq));

        //alternative
//        Actions act = new Actions(driver);
//        act.doubleClick(element).build().perform();

        Thread.sleep(5000);
        driver.quit();
    }

    public static Point getCenterElement(Point location, Dimension dim) {
        return new Point(location.getX() + dim.getWidth() / 2, location.getY() + dim.getHeight() / 2);

    }
}
