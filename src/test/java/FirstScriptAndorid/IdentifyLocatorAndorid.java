package FirstScriptAndorid;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IdentifyLocatorAndorid {
public AndroidDriver driver;
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofSeconds(60));

        // calling the andorid driver to run the app
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(3000);

//        driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@content-desc,'Accessib')]")).click();
//        driver.findElement(AppiumBy.accessibilityId("Accessibility")).click();x


        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\\\"android.widget.ListView\n" +
                "                \\\").childSelector(new UiSelector().text(\\\"App\\\")")).click();
    }
}
