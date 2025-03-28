package mobiletestpack;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MobileApplicationTesting {
//    public static void main(String[] args) {
//        System.out.println("test");
//    }

//    @Test
    public void testAndroid() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));
//        options.setAppPackage("io.appium.android.apis");
//        options.setAppActivity("io.appium.android.apis.ApiDemos");

//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        // calling the andorid driver to run the app
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        // dont use By class in andoird will not identify instead use AppiumBy
        // driver.findElement(AppiumBy.accessibilityId("Access'ibility")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Access'ibility\"]\n")).click();
//        driver.findElement(AppiumBy.cssSelector("")).click();
    }

//    @Test
    public void testIos() throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iphone15");
        options.setAutoWebview(true);
        options.setAppPushTimeout(Duration.ofMillis(50000));
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/ios-app.zip");
        options.setBundleId("com.moataz.dailycheck");
        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

        // static sleeper it will wait till the time is over
//        Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"plus.circle\"]\n"));
        // expected condition wait - it will wait till the elements inside the app/web is gettingloaded
        // it does not wait till the time is gettingcompleted instead it check whether the condition is satisfied with
        // the time interval
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2500));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"plus.circle\"]\n")).click();
//        driver.findElement(By.cssSelector("")).click();

    }

}
