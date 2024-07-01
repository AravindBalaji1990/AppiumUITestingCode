package handlinggestures;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import io.appium.java_client.android.connection.*;
import org.openqa.selenium.devtools.Connection;

public class WifiBluetoothOption {

    public static void main(String[] args) throws MalformedURLException {
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
        // cehck for the conneciton of wifi and bluetooth
//        ConnectionState con = driver.getConnection();
//        System.out.println(con.isWiFiEnabled());
//        System.out.println(con.isDataEnabled());
//        System.out.println(con.isAirplaneModeEnabled());

        //enable wifi

//        ConnectionState con = new ConnectionStateBuilder().withWiFiEnabled().build();
//        driver.setConnection(con);

        //disable wifi
//        ConnectionState con = new ConnectionStateBuilder().withWiFiDisabled().build();
//        driver.setConnection(con);





    }
}
