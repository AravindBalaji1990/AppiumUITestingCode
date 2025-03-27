package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
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
import java.util.Arrays;
import java.util.Collections;

public class HandlingGestureDemo_Zoom {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setUdid("08BBF8F2-37A6-42E0-AB9F-65C5E6AEC31B");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/ios-app.zip");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/SampleApp/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");
//        options.setAutoWebview(true);

        options.setForceAppLaunch(true);
//        options.setPermissions();


//        options.setBundleId("com.moataz.dailycheck");
        options.setBundleId("com.saucelabs.mydemoapp.rn");


        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(5000);

        System.out.println(driver.getLocation());
//        driver.setLocation();

        Actions act = new Actions(driver);
        WebElement element1 = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"tab bar option menu\"]"));
        act.click(element1).build().perform();
        Thread.sleep(10000);

        WebElement element2 = driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name=\"menu item drawing\"]"));
        act.click(element2).build().perform();


        Thread.sleep(10000);

        WebElement element3 = driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='Signature Pad demo']"));

        Point centerofelememnt = getCenterElement(element3.getLocation(), element3.getSize());

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "touch1");
        Sequence seq1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerofelememnt))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), centerofelememnt.getX() + 1000, centerofelememnt.getY() - 100))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "touch2");
        Sequence seq2 = new Sequence(finger2, 1)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerofelememnt))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger2.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), centerofelememnt.getX() - 150, centerofelememnt.getY() + 1500))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(seq1, seq2));

        Thread.sleep(5000);
        driver.quit();
    }

    public static Point getCenterElement(Point location, Dimension dim) {
        return new Point(location.getX() + dim.getWidth() / 2, location.getY() + dim.getHeight() / 2);

    }


    //Screen level zoom in - this can be used in maps if there is no element to mention and zoom
    public static void zoomFunction(AndroidDriver driver) {
        Dimension dim = driver.manage().window().getSize();
        int centerX = dim.getWidth() / 2;
        int centerY = dim.getHeight() / 2;

// Finger 1 starts near the center
        int startX1 = centerX;
        int startY1 = centerY;

// Finger 2 starts near the center
        int startX2 = centerX;
        int startY2 = centerY;

// Finger 1 moves outward towards the top-left
        int endX1 = (int) (centerX * 0.5);
        int endY1 = (int) (centerY * 0.5);

// Finger 2 moves outward towards the bottom-right
        int endX2 = (int) (centerX * 1.5);
        int endY2 = (int) (centerY * 1.5);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence zoomInFinger1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX1, startY1))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX1, endY1))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Sequence zoomInFinger2 = new Sequence(finger2, 1)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX2, startY2))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger2, Duration.ofMillis(100)))
                .addAction(finger2.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX2, endY2))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(zoomInFinger1, zoomInFinger2));

    }
}
