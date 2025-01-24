package HandlingNativeToWebview;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
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

public class NativetoWebview {

    //    public static AndroidDriver driver;
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.autoWebview();
        options.autoGrantPermissions();
        options.setAutoWebview(true);
        options.setAutoWebviewTimeout(Duration.ofMillis(5000));
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/SampleApp/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

//        options.setAppWaitDuration(Duration.ofMillis(50000));
        options.setAppPackage("com.swaglabsmobileapp");

        options.setAppActivity("com.swaglabsmobileapp.MainActivity");

        options.setAppWaitForLaunch(true);
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@class=\"android.widget.ImageView\"])[1]")).click();
//        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"WebView\").instance(0))")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Products\" and @class=\"android.widget.TextView\"]")).click();
        Thread.sleep(5000);

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"URL input field\"]")).click();
        Thread.sleep(5000);

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"URL input field\"]")).sendKeys("https://www.google.com");
        Thread.sleep(5000);
        ;
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Go To Site button"));
//        element.click();
        //we are trying to identify the element position
        // to do a tap
        Point location = element.getLocation();
        System.out.println("the location the element " + location);
        Dimension size = element.getSize();
        System.out.println("the size the element " + size);
        Point centerofelement = getCenterElement(location, size);
//        System.out.println("where i am " +driver.getContext());
//        System.out.println("where i am " +driver.getContextHandles());
//
//        // we need to perform a touch action
        PointerInput touchaction1 = new PointerInput(PointerInput.Kind.TOUCH, "fingertouch1");
        Sequence seq = new Sequence(touchaction1, 1)
                .addAction(touchaction1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerofelement))
                .addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(touchaction1, Duration.ofMillis(5000)))
                .addAction(touchaction1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(touchaction1, Duration.ofMillis(5000)))
                .addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(seq));
        Thread.sleep(10000);

        PointerInput touchaction2 = new PointerInput(PointerInput.Kind.TOUCH, "fingertouch1");
        Sequence seq2 = new Sequence(touchaction1, 1)
                .addAction(touchaction1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerofelement))
                .addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(touchaction1, Duration.ofMillis(500)))
                .addAction(touchaction1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(seq2));
        Thread.sleep(30000);
        System.out.println("where i am " + driver.getContext());
        System.out.println("where i am " + driver.getContextHandles());
        //check the current context
        driver.getContext();
        //check for any other webview available
        driver.getContextHandles();
        Thread.sleep(5000);
        Set<String> handles = driver.getContextHandles();

        String webpage = new ArrayList<String>(handles).get(1);
        Thread.sleep(5000);
        driver.context(webpage);

        Thread.sleep(5000);
        System.out.println(driver.getPageSource());

        //Webview to native
        driver.context("NATIVE_APP");
    }

    public static Point getCenterElement(Point location, Dimension dim) {
        return new Point(location.getX() + dim.getWidth() / 2, location.getY() + dim.getHeight() / 2);

    }
}
