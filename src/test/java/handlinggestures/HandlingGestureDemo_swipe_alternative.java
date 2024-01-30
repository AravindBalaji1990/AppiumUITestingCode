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
import java.util.Collections;
import java.util.HashMap;

public class HandlingGestureDemo_swipe_alternative {

    public static void main(String[] args) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
//        options.setAppPackage("com.saucelabs.mydemoapp.rn");
//        options.setAppActivity("com.saucelabs.mydemoapp.rn.MainActivity");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));

        // calling the andorid driver to run the app̵
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);


        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Views']"));
        element.click();

        // alternative1
//        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"WebView\").instance(0))")).click();


        // alternative2
        WebElement elementtoscroll = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"WebView\"]"));
        HashMap<String , Object> scrolldemo = new HashMap<>();
        scrolldemo.put("elementtoscroll",elementtoscroll.getText());
        scrolldemo.put("direction", "down");
        scrolldemo.put("percent", 1);
        driver.executeScript("mobile: scrollGesture", scrolldemo);

    }
}
