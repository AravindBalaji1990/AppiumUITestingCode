package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class HandlingGestureDemo_DragandDrop_Alternative {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
//        options.setAppPackage("com.saucelabs.mydemoapp.rn");
//        options.setAppActivity("com.saucelabs.mydemoapp.rn.MainActivity");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");

//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        // calling the andorid driver to run the app̵
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);


        WebElement elementViews = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Views']"));
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(elementViews));
        elementViews.click();


        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")));
        WebElement elementDragandDrop = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Drag and Drop']"));
        elementDragandDrop.click();


        WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement destination = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));


        //Drag and drop alternative - only for web not on mobile
//        Actions act = new Actions(driver);
//        act.clickAndHold(source).moveToElement(destination).release(destination).build().perform();

        // alternative approach but within the same Actions class
//        act.dragAndDrop(source, destination).build().perform();

        System.out.println(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dropped!']")).isDisplayed());

        Thread.sleep(3000);
        driver.quit();

    }
}
