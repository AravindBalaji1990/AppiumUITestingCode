package handling_SwitchBetweenapps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class RunAppinBackground {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setUdid("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));


        // calling the andorid driver to run the app̵
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Views']"));
        element.click();

        //it makes the app to keep running in background
//        driver.runAppInBackground(Duration.ofSeconds(10));// till 10 seocnds the app will be running in background

        //after 10 seconds
        // activateApp - to open any application
        driver.activateApp("com.flipkart.android");
        System.out.println("the new app opened : " + driver.getCurrentPackage());
        Thread.sleep(3000);
        driver.terminateApp("com.flipkart.android");

        Thread.sleep(5000);
        driver.activateApp("io.appium.android.apis");
        WebElement element2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Animation']"));
        element2.click();

        Thread.sleep(5000);
        driver.quit();
    }
}
