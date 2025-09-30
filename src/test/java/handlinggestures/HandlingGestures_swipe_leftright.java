package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class HandlingGestures_swipe_leftright {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
//        options.setUdid("29221JEGR00379");
        options.setUdid("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);

        options.setAppPackage("co.motovolt.motovoltapp");
        options.setAppActivity("co.motovolt.motovoltapp.MainActivity");
        options.setAutoGrantPermissions(true);// to allow the location to true
//        options.setIgnoreHiddenApiPolicyError(true);// this one will beused when native android application is used - oppo/samsung/vivo
//        options.noReset(); // it will clear the app cache and start it as a fresh


        // calling the andorid driver to run the app̵
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        Thread.sleep(5000);
        //we are going to swipe on a specific element to do swipe gestures
        WebElement ele = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup/following-sibling::android.widget.TextView[@text='Drive Less, e-Cycle More!']/preceding-sibling::android.view.ViewGroup/android.widget.ImageView"));
        // custom function
        swipeLeft(driver, ele);

        Thread.sleep(3000);
//
        WebElement ele2 = driver.findElement(AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView"));
        swipeLeft(driver, ele2);
        Thread.sleep(3000);

        WebElement ele3 = driver.findElement(AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView"));
        swipeLeft(driver, ele3);
        Thread.sleep(3000);

        WebElement ele4 = driver.findElement(AppiumBy.xpath("//android.widget.ImageView"));
        swipeLeft(driver, ele4);
        Thread.sleep(3000);

        System.out.println(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"REGISTER\"]")).isDisplayed());


        Thread.sleep(5000);
        driver.quit();
    }


    public static void swipeLeft(AndroidDriver driver, WebElement ele) {
        int startX = ele.getRect().x + (ele.getSize().width * 3 / 4);// source width
        int startY = ele.getRect().y + (ele.getSize().height / 2);// source height

        System.out.println("the coordinates for start position :" + startX + ", " + startY);

        int endX = ele.getRect().x + (ele.getSize().width / 4);// destination width
        int endY = ele.getRect().y + (ele.getSize().height / 2); // destination height
        System.out.println("the coordinates for end position :" + endX + ", " + endY);


        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "touch1");
        Sequence seq = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(500)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(seq));
        System.out.println("-----Swipe left Ended-----");
    }


    public static void swipeRight(AndroidDriver driver, WebElement ele) {
        int startX = ele.getRect().x + (ele.getSize().width / 4);
        int startY = ele.getRect().y + (ele.getSize().height / 2);
        int endX = ele.getRect().x + (ele.getSize().width * 3 / 4);
        int endY = ele.getRect().y + (ele.getSize().height / 2);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "touch1");
        Sequence seq = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(500)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(seq));
        System.out.println("-----Swipe right Ended-----");
    }
}
