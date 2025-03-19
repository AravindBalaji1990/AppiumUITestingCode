package handlingMiscellaneousItems;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class BluetoothIOS_lockunlock {

    //Only for real device not in Simulator
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("IOS");
        options.setDeviceName("iPhone 16 Plus");
        options.setPlatformVersion("18.2");
        options.setUdid("9C4CF5F8-F6CD-44FC-AC73-5B595592AD1B");
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
        options.setBundleId("com.apple.Preferences");
        options.setWaitForIdleTimeout(Duration.ofSeconds(30));
        options.setUseNewWDA(false);

        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

//        driver.lockDevice(Duration.ofSeconds(15));
        driver.lockDevice();
        Thread.sleep(3000);
        driver.unlockDevice();

        // htis will simulate the behaviour of clicking the home button
        // this below command works only with real device
//        driver.executeScript("mobile : pressButton", Map.of("name", "home"));

        Thread.sleep(3000);
        driver.quit();


    }
}
