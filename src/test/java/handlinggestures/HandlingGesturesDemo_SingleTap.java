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
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");

//        options.autoGrantPermissions();
//        options.setIgnoreHiddenApiPolicyError(true);
//        options.setAppWaitForLaunch(true);
//        options.setAppWaitDuration(Duration.ofMillis(50000));


        // calling the andorid driver to run the app
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        Thread.sleep(5000);
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Views']"));
//        WebElement element = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"Views\"))"));
//        element.click();
//        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView")).click();
//        System.out.println("to chec kthe attribute vbalue :" +driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='open menu']")).getAttribute("content-desc"));
//        WebElement element = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView"));
        ;

        // alternative way - 1
//        element.click();

        //alternative way -2
//        Actions act = new Actions(driver);
//        act.moveToElement(element).click().build().perform();
//        act.click(element).build().perform();

        //Perform a tap action
//        singleTap(element, driver);

        // click with javascript executor  will not work with mobile applciaiton
        // this si not a part of UiAutomator2Options/AndroidDriver
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("argument[0].click();",element);

        Thread.sleep(5000);
        driver.quit();
    }


    // to get the center of the element
    public static Point getCenterElement(Point location, Dimension dim) {
        return new Point(location.getX() + dim.getWidth() / 2, location.getY() + dim.getHeight() / 2);

    }

    public static void singleTap(WebElement element, AndroidDriver driver) {
        Point location = element.getLocation();
        System.out.println("the location the element " + location);
        Dimension size = element.getSize();
        System.out.println("the size the element " + size);
        Point centerofelement = getCenterElement(location, size);
        System.out.println("center of the element : " + centerofelement);

        // we need to perform a touch action
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
//        .addAction(new Pause(touchaction1, Duration.ofMillis(500)))
//                .addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
//                .addAction(new Pause(touchaction1, Duration.ofMillis(500)))
////                // this simulates the relase of tap/finger on the element
//                .addAction(touchaction1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

//
//        // this will perfomr the series of actions
        driver.perform(Collections.singletonList(seq));
    }
}
