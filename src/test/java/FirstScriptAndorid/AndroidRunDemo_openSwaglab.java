package FirstScriptAndorid;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;
public class AndroidRunDemo_openSwaglab {

    public static void main(String[] args) throws MalformedURLException, InterruptedException{
        // opne the app via main activity and package name
        //this is configuration only for Android
        UiAutomator2Options obj_andorid = new UiAutomator2Options();
        obj_andorid.setPlatformName("Android");
        obj_andorid.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        obj_andorid.setUdid("29221JEGR00379");

//        obj_andorid.setApp("path of the apk"); // if we need to install the application
//        obj_andorid.setAppPackage("com.swaglabsmobileapp");
//        obj_andorid.setAppActivity("com.swaglabsmobileapp.MainActivity");
//        obj_andorid.setAppActivity("com.flipkart.youtubeview.activity.YouTubeActivity - Flipkart");// wrong one
        obj_andorid.setAppPackage("com.flipkart.android");
        obj_andorid.setAppActivity("com.flipkart.android.activity.HomeFragmentHolderActivity");// wrong one

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),obj_andorid);

        Thread.sleep(3000);

        driver.quit();
    }
}
