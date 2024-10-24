package handlingMiscellaneousItems;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.bidi.Connection;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class HandlingWifi {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        // it turn off the wifi if its on
        driver.toggleWifi();

        Thread.sleep(10000);
        driver.toggleWifi();

        Thread.sleep(5000);
       ConnectionState con =  driver.getConnection();
        System.out.println( "state of wifi : " +con.isWiFiEnabled());// to check whter wifi is enabled/disabled

        System.out.println("state of airplanemode : " +con.isAirplaneModeEnabled()); // to check whether the airplane mode is enabled/disabled
        Thread.sleep(5000);

//       if(con.isDataEnabled()){
//           System.out.println("data is enabled");
//       }else {
//           driver.toggleData();
//       }

        // this will turn on the mobile data
        driver.toggleData();
        Thread.sleep(5000);


        driver.quit();

    }
}
