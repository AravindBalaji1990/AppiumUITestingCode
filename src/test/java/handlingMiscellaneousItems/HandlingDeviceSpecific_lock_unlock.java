package handlingMiscellaneousItems;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class HandlingDeviceSpecific_lock_unlock {
    public static void main(String[] args) throws IOException, InterruptedException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
        options.setAutoGrantPermissions(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

//        driver.lockDevice();
        driver.lockDevice(Duration.ofSeconds(5));

        // unlock device
        driver.unlockDevice();
        // enter the pin for the device
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        Thread.sleep(5000);


        driver.quit();

    }
}
