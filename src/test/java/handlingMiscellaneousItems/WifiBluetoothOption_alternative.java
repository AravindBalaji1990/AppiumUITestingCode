package handlingMiscellaneousItems;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WifiBluetoothOption_alternative {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.autoGrantPermissions();
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
//        options.setAppPackage("com.saucelabs.mydemoapp.rn");
//        options.setAppActivity("com.saucelabs.mydemoapp.rn.MainActivity");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));
//        options.setAppPackage("io.appium.android.apis");
        options.setAppPackage("co.motovolt.motovoltapp");
//        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppActivity("co.motovolt.motovoltapp.MainActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);


        //enable bluetooth
        driver.executeScript("mobile: device:network", ImmutableMap.of("bluetooth",true));

        Thread.sleep(5000);
        //disable bluetooth
        driver.executeScript("mobile: device:network", ImmutableMap.of("bluetooth",false));

        



    }
}
