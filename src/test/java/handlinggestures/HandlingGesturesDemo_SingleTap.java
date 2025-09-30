package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
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

public class HandlingGesturesDemo_SingleTap {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("H0C9FI1LV01B0300012");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
//        options.nativeWebScreenshot();

//        options.autoGrantPermissions();
//        options.setIgnoreHiddenApiPolicyError(true);
//        options.setAppWaitForLaunch(true);
//        options.setAppWaitDuration(Duration.ofMillis(50000));


        // calling the andorid driver to run the app
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).sendKeys("standard_user");
        Thread.sleep(5000);

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys("secret_sauce");

        WebElement loginbutton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"LOGIN\"]"));
        //Perform a tap action
        Thread.sleep(5000);
//        singleTap(loginbutton, driver);
//        alternative way - 1
//        loginbutton.click();

        // you can try this if the click has any exception
        // then go with a gesture
//        try {
//            loginbutton.click();
//        } catch (Exception e) {
//            singleTap(loginbutton, driver);
//        }

        //alternative way -2
//        Actions act = new Actions(driver);
//        act.moveToElement(loginbutton).click().build().perform();
//        act.click(loginbutton).build().perform();


        Thread.sleep(5000);
        driver.quit();
    }


    // to get the center of the element
    public static Point getCenterElement(Point location, Dimension dim) {
        return new Point(location.getX() + dim.getWidth() / 2, location.getY() + dim.getHeight() / 2);

    }

    public static void singleTap(WebElement element, AndroidDriver driver) {
        // Point function to identify the lement location on device screen
        Point location = element.getLocation();
        System.out.println("the location the element on the deivce " + location);

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

//
//        // this will perfomr the series of actions
        driver.perform(Collections.singletonList(seq));
    }
}
