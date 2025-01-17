package handlingcapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.bidi.Connection;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CapabilitiesCheck_Android {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setUdid("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.views");
//        options.setAppActivity("io.appium.android.apis.ApiDemos.Media");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/SampleApp/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        options.setAutoGrantPermissions(true);
        options.setAppWaitDuration(Duration.ofSeconds(60));
        options.setNewCommandTimeout(Duration.ofSeconds(40));
        options.setAppWaitForLaunch(true);
        options.setFullReset(true);



        // calling the andorid driver to run the app̵
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        Thread.sleep(5000);

        driver.quit();

    }
}
