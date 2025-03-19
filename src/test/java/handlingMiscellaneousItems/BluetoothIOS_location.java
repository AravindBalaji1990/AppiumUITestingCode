package handlingMiscellaneousItems;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class BluetoothIOS_location {

    //Only for real device not in Simulator
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("IOS");
        options.setDeviceName("iPhone 16 Plus");
        options.setPlatformVersion("18.2");
        options.setUdid("9C4CF5F8-F6CD-44FC-AC73-5B595592AD1B");
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
//        options.setBundleId("com.apple.Preferences");
        options.setWaitForIdleTimeout(Duration.ofSeconds(30));
        options.setUseNewWDA(false);

        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"),options);

        // Open Control Center
        System.out.println("the device location :" +driver.getLocation());

        Thread.sleep(3000);
        driver.quit();


    }
}
