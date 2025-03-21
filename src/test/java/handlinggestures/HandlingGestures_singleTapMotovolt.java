package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
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
import java.util.Arrays;
import java.util.Collections;

public class HandlingGestures_singleTapMotovolt {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setUdid("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAutoGrantPermissions(true);// to allow the location
        options.setAppPackage("co.motovolt.motovoltapp");
        options.setAppActivity("co.motovolt.motovoltapp.MainActivity");


        // calling the andorid driver to run the app̵
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        WebElement element_arrow = driver.findElement(AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView"));

        singleTap(driver, element_arrow);

        Thread.sleep(5000);
        driver.quit();
    }


    public static void singleTap(AndroidDriver driver, WebElement element) {

        // to identify the coordinates of the element
        Point location = element.getLocation();
        System.out.println("the location the element " + location);
        Dimension size = element.getSize();
        System.out.println("the size the element " + size);
        // to get the center of the element
        Point centerofelement = getCenterElement(location, size);
        System.out.println("center of the element : " + centerofelement);

        // we need to perform a touch action
        PointerInput touchaction1 = new PointerInput(PointerInput.Kind.TOUCH, "fingertouch1");
        // we will perform the series of actions on the element
        Sequence seq = new Sequence(touchaction1, 1)
                //this simulates the tap
                .addAction(touchaction1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerofelement))
                // this simulates the tap onthe element
                .addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                // this simulates the tap duration
                .addAction(new Pause(touchaction1, Duration.ofMillis(500)))
                // this simulates the relase of tap/finger on the element
                .addAction(touchaction1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

//        driver.perform(Arrays.asList(seq));
        driver.perform(Collections.singletonList(seq));

    }

    public static Point getCenterElement(Point location, Dimension dim) {
        return new Point(location.getX() + dim.getWidth() / 2, location.getY() + dim.getHeight() / 2);
    }
}
