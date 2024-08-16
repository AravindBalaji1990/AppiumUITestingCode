package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
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

public class HandlingGestureDemo_swipe_ios {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/ios-app.zip");
//        options.setAutoWebview(true);
        options.setForceAppLaunch(true);
        options.setPlatformVersion("17.5");
        options.setPlatformName(AutomationName.IOS_XCUI_TEST);

//        options.setBundleId("com.moataz.dailycheck");
        options.setBundleId("com.saucelabs.mydemoapp.rn");

        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);


        Thread.sleep(10000);
//        WebElement element = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView"));
        WebElement element = driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Test.allTheThings() T-Shirt\"]\n"));

        //Scroll/swipe action
        Dimension dim = driver.manage().window().getSize();
        int start1 = dim.getWidth()/2;
        int start2 = dim.getHeight()/2;

        int end1 = (int) ((int) dim.getHeight() * 0.25);
        int end2 = start1;

        Point centerofelememnt = getCenterElement(element.getLocation(),element.getSize());
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "touch1");
        Sequence seq = new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),start1,start2))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(500)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100),PointerInput.Origin.viewport(), end1, end2))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(seq));

    }

    public static Point getCenterElement(Point location, Dimension dim) {
        return new Point(location.getX() + dim.getWidth() / 2, location.getY() + dim.getHeight() / 2);

    }
}
