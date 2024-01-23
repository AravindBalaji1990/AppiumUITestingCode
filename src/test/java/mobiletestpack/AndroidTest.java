package mobiletestpack;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");

//        options.setAppWaitDuration(Duration.ofMillis(50000));
        options.setAppPackage("com.saucelabs.mydemoapp.rn");
        options.setAppActivity("com.saucelabs.mydemoapp.rn.MainActivity");
        options.setAppWaitForLaunch(true);

//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        // calling the andorid driver to run the app
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(3000);
        System.out.println("is displayed check : " + driver.findElement(AppiumBy.cssSelector("android.widget.TextView[text='Sauce Labs Backpack']")).isDisplayed());
        Thread.sleep(3000);
        System.out.println("is enabled check : " + driver.findElement(AppiumBy.cssSelector("android.widget.TextView[text='Sauce Labs Backpack'][content-desc='store item text']")).isEnabled());

        Thread.sleep(5000);

        System.out.println("check the display :"+ driver.findElement(AppiumBy.cssSelector("android.view.ViewGroup[content-desc='store item'] android.widget.TextView[text='Sauce Labs Backpack']")).isDisplayed());
        System.out.println("check the display :"+ driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='store item']//android.widget.TextView[@text='Sauce Labs Backpack']")).isDisplayed());

    }
}
