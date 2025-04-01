package HandlingNativeToWebview;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class NativetoWebview1 {

    //    public static AndroidDriver driver;
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("IOS");
        options.setUdid("08BBF8F2-37A6-42E0-AB9F-65C5E6AEC31B");
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
//        options.autoWebview();
//        options.autoGrantPermissions();
//        options.setAutoWebview(true);
//        options.setAutoWebviewTimeout(Duration.ofMillis(5000));
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");
        options.setBundleId("com.saucelabs.mydemoapp.rn");

//        options.setAppWaitDuration(Duration.ofMillis(50000));
//        options.setAppPackage("com.saucelabs.mydemoapp.rn");
//        options.setAppActivity("com.saucelabs.mydemoapp.rn.MainActivity");
//        options.setAppPackage("io.appium.android.apis");
//        options.setAppActivity("io.appium.android.apis.ApiDemos");
//        options.setAppWaitForLaunch(true);
        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

        Thread.sleep(5000);
//        driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"tab bar option menu\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("tab bar option menu")).click();
        Thread.sleep(3000);
//        driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name=\"menu item webview\"]")).click();
        driver.findElement(AppiumBy.accessibilityId("menu item webview")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"URL input field\"]")).clear();
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"URL input field\"]")).sendKeys("https://www.bing.com");
        Thread.sleep(3000);
        //keywboard return
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Return\"]")).click();
        Thread.sleep(5000);
        WebElement btn_gotosite = driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name=\"Go To Site button\"]"));

//        Actions act = new Actions(driver);
//        act.click(driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@name=\"Go To Site button\"]"))).build().perform();
        singleTap(driver, btn_gotosite);

        Thread.sleep(10000);

        Set<String> contextname = driver.getContextHandles();
        for (String data : contextname) {
            System.out.println("webview content avaiable -> " + data);
        }
//        System.out.println("URL of the page " +driver.getCurrentUrl());

        System.out.println("where i am :" + driver.getContext());
        System.out.println("where i am :" + driver.getContextHandles());
        System.out.println(driver.getPageSource());

        //driver.context("NATIVE_APP");
        Thread.sleep(3000);

//        driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextView[@value='Search the web']")).clear();
//        driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextView[@value='Search the web']")).sendKeys("test appium");

//        try{
//            driver.findElement(AppiumBy.accessibilityId("No thanks")).click();
//        }catch (Exception e){

//        }

//        driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[@value=\" \"]")).sendKeys("test appium");

//        driver.getContext();
//        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"WebView\").instance(0))")).click();


//        //check the current context
//        driver.getContext();
//        //check for any other webview available
//        driver.getContextHandles();
////        Thread.sleep(5000);
//        Set<String> handles = driver.getContextHandles();
//
//        String webpage = new ArrayList<String>(handles).get(1);
////        Thread.sleep(5000);
//        driver.context(webpage);
//
////        Thread.sleep(5000);
//        System.out.println(driver.getPageSource());
//
//        //Webview to native
//        driver.context("NATIVE_APP");

        Thread.sleep(5000);
        driver.quit();
    }

    public static void singleTap(IOSDriver driver, WebElement element) {
        Point location = element.getLocation();
        System.out.println("the location the element " + location);
        Dimension size = element.getSize();
        System.out.println("the size the element " + size);
        Point centerofelement = getCenterElement(location, size);

        try {
            // we need to perform a touch action
            PointerInput touchaction1 = new PointerInput(PointerInput.Kind.TOUCH, "fingertouch1");
            Sequence seq = new Sequence(touchaction1, 1)
                    .addAction(touchaction1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerofelement))
                    .addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(touchaction1, Duration.ofMillis(5000)))
                    .addAction(touchaction1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(touchaction1, Duration.ofMillis(5000)))
                    .addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList(seq));

            // this will perfomr the series of actions
            driver.perform(Collections.singletonList(seq));
        } catch (Exception e) {

        }
    }

    public static Point getCenterElement(Point location, Dimension dim) {
        return new Point(location.getX() + dim.getWidth() / 2, location.getY() + dim.getHeight() / 2);

    }

}
