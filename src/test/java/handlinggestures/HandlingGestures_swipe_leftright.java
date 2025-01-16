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
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        // capability to allow the location based permission or any default permission
//        options.autoGrantPermissions();
//        options.setAppWaitForLaunch(true);
//        options.setAppWaitDuration(Duration.ofMillis(50000));
        options.setAppPackage("co.motovolt.motovoltapp");
        options.setAppActivity("co.motovolt.motovoltapp.MainActivity");


        // calling the andorid driver to run the app̵
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        //        WebElement element = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView"));
//        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]\n"));
//        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(element));
//        element.click();
        Thread.sleep(5000);
        //Scroll/swipe action
        WebElement ele = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup/following-sibling::android.widget.TextView[@text='Drive Less, e-Cycle More!']/preceding-sibling::android.view.ViewGroup/android.widget.ImageView"));

        swipeLeft(driver, ele);
        Thread.sleep(5000);
//        WebElement ele2 = driver.findElement(AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView"));
//        swipeRight(driver, ele2);

        Thread.sleep(5000);
        driver.quit();
//        Point midpoint = new Point((int)(size.width*0.5), (int)(size.height*0.5));
//
//        int left = midpoint.x - (int)(midpoint.x *0.75);
//        int right = midpoint.x + (int)(midpoint.x *0.75);
//
//        Point start = new Point(right, midpoint.y);
//        Point end = new Point(left, midpoint.y);
        //Starting x location set to 5% of the width (near left)
//        int startx = (int) (size.width * 0.05);
//        //y position set to mid-screen vertically
//        int starty = size.height / 2;
//        //Ending x location set to 95% of the width (near right)
//        int endx = (int) (size.width * 0.95);
//        int endy = starty;



    }


    public static void swipeLeft(AndroidDriver driver , WebElement ele){
        int startX = ele.getRect().x + (ele.getSize().width * 3 / 4);
        int startY = ele.getRect().y + (ele.getSize().height / 2);
        int endX = ele.getRect().x + (ele.getSize().width / 4);
        int endY = ele.getRect().y + (ele.getSize().height / 2);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "touch1");
        Sequence seq = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(500)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(seq));
        System.out.println("-----Swipe Ended-----");
    }


    public static void swipeRight(AndroidDriver driver , WebElement ele){
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
        System.out.println("-----Swipe Ended-----");
    }
}
