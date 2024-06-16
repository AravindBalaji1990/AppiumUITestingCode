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

        AppiumDriverLocalService service =AppiumDriverLocalService.buildDefaultService();
        service.start();
        System.out.println(service.isRunning());


        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/ios-app.zip");
        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");
//        options.setAutoWebview(true);
        options.setForceAppLaunch(true);

//        options.setBundleId("com.moataz.dailycheck");
//        options.setBundleId("com.saucelabs.mydemoapp.rn");

        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(5000);

        WebElement element1 = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='tab bar option menu']"));
        element1.click();
        WebElement element2 = driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='menu item drawing']"));
        element2.click();

        Thread.sleep(5000);

        WebElement element3 = driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name='Signature Pad demo']"));

        Point centerofelememnt = getCenterElement(element3.getLocation(),element3.getSize());

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "touch1");
        Sequence seq1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerofelememnt))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(),centerofelememnt.getX()+1000, centerofelememnt.getY()-1000))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "touch2");
        Sequence seq2 = new Sequence(finger2, 1)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerofelememnt))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger2.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(),centerofelememnt.getX()-1000, centerofelememnt.getY()+1000))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(seq1,seq2));
    }

    public static Point getCenterElement(Point location, Dimension dim) {
        return new Point(location.getX() + dim.getWidth() / 2, location.getY() + dim.getHeight() / 2);

    }
}
