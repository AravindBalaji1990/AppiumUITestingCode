package HandlingNativeToWebview;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class NativetoWebview1 {

//    public static AndroidDriver driver;
    public  static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/Android-MyDemoAppRN.1.3.0.build-244.apk");

//        options.setAppWaitDuration(Duration.ofMillis(50000));
//        options.setAppPackage("com.saucelabs.mydemoapp.rn");
//        options.setAppActivity("com.saucelabs.mydemoapp.rn.MainActivity");
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
//        System.out.println("where i am " +driver.getContext());
//        System.out.println("where i am " +driver.getContextHandles());
        driver.getContext();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"WebView\").instance(0))")).click();


        //check the current context
//        driver.getContext();
        //check for any other webview available
//        driver.getContextHandles();
//        Thread.sleep(5000);
//        Set<String> handles = driver.getContextHandles();

//        String webpage = new ArrayList<String>(handles).get(1);
//        Thread.sleep(5000);
//        driver.context(webpage);

//        Thread.sleep(5000);
        System.out.println(driver.getPageSource());

        //Webview to native
        driver.context("NATIVE_APP");
    }

    public static Point getCenterElement(Point location, Dimension dim) {
        return new Point(location.getX() + dim.getWidth() / 2, location.getY() + dim.getHeight() / 2);

    }
}
