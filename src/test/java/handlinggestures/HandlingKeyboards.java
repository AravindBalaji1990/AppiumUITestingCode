package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
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
import java.util.Random;

public class HandlingKeyboards {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setUdid("27139D21-EB13-48EE-9C88-C786E92AB0E0");
        options.setPlatformName(AutomationName.IOS_XCUI_TEST);
        options.setBundleId("com.moataz.dailycheck");
        options.setUseNewWDA(false);

        // calling the andorid driver to run the app
        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);


        Thread.sleep(5000);

        WebElement element = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"plus.circle\"]"));
        singleTap(element,driver);
        Thread.sleep(5000);

        if (driver.isKeyboardShown()) {
            System.out.println("keyboard is shown");
        }
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField[@value=\"Title\"]")).sendKeys("test");

        Thread.sleep(5000);

        if (driver.isKeyboardShown()) {
            System.out.println("keyboard is shown");
            try {
                driver.hideKeyboard();
            }catch (Exception e){
                WebElement retunr = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Return\"]"));
                retunr.click();
            }
        }

        Thread.sleep(5000);

        driver.quit();
    }

    public static void singleTap(WebElement element, IOSDriver driver) {
        // Point function to identify the lement location
        Point location = element.getLocation();
        System.out.println("the location the element " + location);

        // get the width and height of the element onthe screen
        Dimension size = element.getSize();
        System.out.println("the size the element " + size);

        // get the center point of the element
        Point centerofelement = getCenterElement(location, size);
        System.out.println("center of the element : " + centerofelement);

        // we need to perform a touch action
        //w3c Actions  - this is avialabel from 2.x Appium
        PointerInput touchaction1 = new PointerInput(PointerInput.Kind.TOUCH, "fingertouch1");
        // we will perform the series of actions on the element
        Sequence seq = new Sequence(touchaction1, 1)
                //this simulates the tap
                .addAction(touchaction1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerofelement))
//                // this simulates the tap onthe element
                .addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
//                // this simulates the tap duration
                .addAction(new Pause(touchaction1, Duration.ofMillis(500)))
//                // this simulates the relase of tap/finger on the element
                .addAction(touchaction1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

//
//        // this will perfomr the series of actions
        driver.perform(Collections.singletonList(seq));
    }


    public static Point getCenterElement(Point location, Dimension dim) {
        return new Point(location.getX() + dim.getWidth() / 2, location.getY() + dim.getHeight() / 2);

    }
}
