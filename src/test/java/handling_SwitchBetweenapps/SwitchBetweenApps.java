package handling_SwitchBetweenapps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SwitchBetweenApps {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
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
//        driver.runAppInBackground(Duration.ofSeconds(60));


        // switching to new app
        //driver.activateApp("bubdle id  or the package id") this will help to activate the app from the device
        driver.activateApp("com.flipkart.android");
        System.out.println("the new app ----> " + driver.getCurrentPackage());

        Thread.sleep(5000);
        // swtiching back to old app
        driver.activateApp("io.appium.android.apis");
        System.out.println(driver.getCurrentPackage());
        WebElement element2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Animation']"));
        System.out.println("the app is switched : " + element2.isDisplayed());
        element2.click();

        Thread.sleep(5000);
        driver.quit();



    }
}
