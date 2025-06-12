package handlingcapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CapabilitiesCheck_Ios {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("IOS");
        options.setBundleId("com.saucelabs.mydemoapp.rn"); // you are going to test native app
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/SampleApp/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");

        options.setUdid("27139D21-EB13-48EE-9C88-C786E92AB0E0");
//        options.setAutoAcceptAlerts(true);// any pop up comes
//        options.withBrowserName("Safari"); // you are going to test something on mobile browser
//        options.setAutoWebview(true);
        options.setUseNewWDA(false); // this will not install webdriver agent agiain and again it will try to re-use if the webdriver agent is valid
//        options.setForceAppLaunch(true);// for app to launch
//        options.setNewCommandTimeout(Duration.ofSeconds(40));// any command that will be execute will have default timed out - max time
//        options.setCapability("","");// any custom capability for hte app you can mentionhere

//        options.setDeviceName("");// Not recomended to use instead use setUdid - Andrioid if we do not meniton the udid it might run on any device that is connnect

        options.setFullReset(true);




        // calling the andorid driver to run the app̵
        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

        Thread.sleep(5000);

        driver.quit();

    }
}
