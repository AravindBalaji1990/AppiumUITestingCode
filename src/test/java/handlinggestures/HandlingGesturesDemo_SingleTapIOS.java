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

public class HandlingGesturesDemo_SingleTapIOS {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 16 Plus");
        options.setUdid("A332C391-A85E-4B1E-8F55-63695EB04AED");
        options.setForceAppLaunch(true);
//        options.setPlatformVersion("17.5");
//        options.setUdid("62622A19-BE5E-45CE-AF31-EDE73B855E60");
        options.setUseNewWDA(false);
        options.setPlatformName(AutomationName.IOS_XCUI_TEST);

        options.setBundleId("com.moataz.dailycheck");


        // calling the andorid driver to run the app
        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);


//        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView")).click();
//        System.out.println("to chec kthe attribute vbalue :" +driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='open menu']")).getAttribute("content-desc"));
//        WebElement element = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView"));
        ;

        // alternative way
//        element.click();

        //alternative way
//        Actions act = new Actions(driver);
//        act.click(element).build().perform();
//
//        act.doubleClick().build().perform();


        //Perform a tap action

        //we are trying to identify the element position
        // to do a tap
        WebElement element = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"plus.circle\"]"));
        // normal selenium click this shoukld also work
//        element.click();

//        Actions action = new Actions(driver);
//        action.click(element).build().perform();
        //locaiton of the lementi n the app to perform touch action
        Point location = element.getLocation();
        System.out.println("the location the element "+ location);
        Dimension size = element.getSize();
        System.out.println("the size the element "+ size);
        Point centerofelement = getCenterElement(location, size);

        // we need to perform a touch action
        PointerInput touchaction1 = new PointerInput(PointerInput.Kind.TOUCH, "fingertouch1");
        Sequence seq = new Sequence(touchaction1, 1)
                //this simulates the tap
                .addAction(touchaction1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),centerofelement))
                // this simulates the tap onthe element
                .addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                // this simulates the tap duration
                .addAction(new Pause(touchaction1,Duration.ofMillis(500)))
                // this simulates the relase of tap/finger on the element
                .addAction(touchaction1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // this will perfomr the series of actions
        driver.perform(Collections.singletonList(seq));


        Thread.sleep(5000);
        driver.quit();
    }


    // to get the center of the element
    public static Point getCenterElement(Point location, Dimension dim) {
        return new Point(location.getX() + dim.getWidth() / 2, location.getY() + dim.getHeight() / 2);

    }
}
