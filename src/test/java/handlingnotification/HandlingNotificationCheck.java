package handlingnotification;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class HandlingNotificationCheck {
    public static void main(String[] args) throws MalformedURLException {


        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.autoWebview();
        options.autoGrantPermissions();
        options.setAutoWebview(true);
        options.setAutoWebviewTimeout(Duration.ofMillis(5000));
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/Android-MyDemoAppRN.1.3.0.build-244.apk");

        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);


    }

    public void openNotificationPanel (AndroidDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        var screenSize = driver.manage().window().getSize();
        var yMargin = 5;
        var xTop = screenSize.width;
        var top = new Point(xTop, yMargin);
        var bottom = new Point(xTop, screenSize.height - yMargin);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(
                finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), top.x, top.y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(
                finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), bottom.x, bottom.y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(swipe));

    }
}