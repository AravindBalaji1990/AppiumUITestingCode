package handlingcapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.bidi.Connection;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CapabilitiesCheck_Android {

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

    }
}
