package WaittimeInAppium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WaittimeDemo_Implicit {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("55ZTINFYRW5T6DNR");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("com.swaglabsmobileapp");
//        options.setAppPackage("io.appium.android.apis");
//        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
//        options.setAppWaitForLaunch(true);
        options.setAutoGrantPermissions(true);
//        options.setAppWaitDuration(Duration.ofMillis(50000));

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        //IMplicit wait
        // it willwait till allthe DOM structure / resources in the background to be populated completely within the stipulated period of time
        // if the resources are available before the stipulated period of time then the rest of the time will be ignored
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(6000);

//        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Views']"));
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]"));
        System.out.println(element.isDisplayed());


        driver.quit();
    }
}
