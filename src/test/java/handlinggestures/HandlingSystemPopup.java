package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class HandlingSystemPopup {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.autoGrantPermissions();
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));
        options.setAppPackage("co.motovolt.motovoltapp");
        options.setAppActivity("co.motovolt.motovoltapp.MainActivity");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        Thread.sleep(5000);
        WebElement ele1 = driver.findElement(AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView"));
        System.out.println(ele1.isDisplayed());

// swipe action
        swiperighttoleft(driver, ele1);


        Thread.sleep(2000);
        WebElement ele2 = driver.findElement(AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView"));
        System.out.println(ele2.isDisplayed());

        System.out.println(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"\uF053\"]")).isDisplayed());
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"\uF053\"]")).click();
// swipe action
//        swipelefttoright(driver, ele2);


    }


    public static void swiperighttoleft(AndroidDriver driver, WebElement ele) {
        int startX = ele.getRect().x + (ele.getSize().width * 3 / 4);//from/source
        int startY = ele.getRect().y + (ele.getSize().height / 2);
        int endX = ele.getRect().x + (ele.getSize().width / 4); //to/destination
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


    public static void swipelefttoright(AndroidDriver driver, WebElement ele) {
        Dimension size = driver.manage().window().getSize();
        int endXnoelement =  size.width * 3 / 4;
        int endX = ele.getRect().x + (ele.getSize().width * 3 / 4);
        int startY = ele.getRect().y + (ele.getSize().height / 2);
        int startX = ele.getRect().x + (ele.getSize().width / 4);
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
