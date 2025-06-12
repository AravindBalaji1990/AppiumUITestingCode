package handlingcapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CapabilitiesCheck_Android_Motovolt {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setUdid("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);

        options.setAppActivity("co.motovolt.motovoltapp.MainActivity");
        options.setAppPackage("co.motovolt.motovoltapp");

//        options.withBrowserName("chrome"); // hybrid applicaiton where we need to choose the browser on which the web app will be loaded

//        options.autoGrantPermissions();// no popup to select the location
        options.setAutoGrantPermissions(false);// grant permission - true or false

//        options.setFullReset(true); // if true cache willbe cleared if false it will not be cleared
        options.fullReset();// app cache clearing
        options.noReset();// app cache clearing will nto be done
        options.setAppWaitForLaunch(true); // wait till the app launches and does not go to the next command
        options.setAppWaitDuration(Duration.ofSeconds(60)); // wait for the app for 60 seconds


        options.ignoreHiddenApiPolicyError();// most custom skin os if any security policy fo rhte device neds to be ignored we can use this
//        options.doesIgnoreHiddenApiPolicyError()
//        options.setIgnoreHiddenApiPolicyError(true);




        // calling the andorid driver to run the app̵
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        Thread.sleep(5000);

        driver.quit();

    }
}
