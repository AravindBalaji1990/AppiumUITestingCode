package handlingMiscellaneousItems;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class HandlingDeviceSpecific {
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

        Runtime.getRuntime().exec("adb shell settings put secure location_mode 3");
        Thread.sleep(5000);

        System.out.println("get the time of the device : " + driver.getDeviceTime());
        System.out.println("get the location of the device : " + driver.getLocation());
        System.out.println("get the battery info of the device : " + driver.getBatteryInfo().getLevel());
        Thread.sleep(5000);


        driver.quit();

    }
}
