package FirstScriptAndorid;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class RightMove_Demo {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        UiAutomator2Options activity1 = new UiAutomator2Options();
        activity1.setPlatformName("Android");
        activity1.setAutomationName((AutomationName.ANDROID_UIAUTOMATOR2));
        activity1.setUdid("29221JEGR00379");
        activity1.setAppPackage("com.rightmove.android");
        activity1.setAppActivity("com.rightmove.android.modules.splash.SplashPageActivity");
        activity1.setAppWaitForLaunch(true);
        activity1.setNewCommandTimeout(Duration.ofSeconds(60));

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), activity1);
        Thread.sleep(5000);

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Customise preferences\"]")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[4]/android.widget.Button")).click();
        Thread.sleep(3000);

        driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")).click();
        Thread.sleep(3000);

        driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[1]/android.widget.Button")).click();
        Thread.sleep(3000);

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"This area\"]")).click();
        Thread.sleep(3000);


        driver.quit();


    }

    public void scrollToElement(String elementText, AndroidDriver driver) {
        String scrollableContainer = "new UiScrollable(new UiSelector().scrollable(true))";
        String scrollTo = ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"))";
        driver.findElement(AppiumBy.androidUIAutomator(scrollableContainer + scrollTo));
    }
}
