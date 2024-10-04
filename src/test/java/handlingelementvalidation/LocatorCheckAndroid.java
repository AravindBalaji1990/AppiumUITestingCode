package handlingelementvalidation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LocatorCheckAndroid {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("com.flipkart.android");
        options.setAppActivity("com.flipkart.android.activity.HomeFragmentHolderActivity");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofSeconds(60));

        // calling the andorid driver to run the app
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(3000);


//        System.out.println(driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"com.flipkart.android:id/activity_container\"]/child::android.widget.RelativeLayout")).isDisplayed());
//        System.out.println(driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"com.flipkart.android:id/activity_container\"]/child::android.widget.RelativeLayout")).isDisplayed());
//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.flipkart.android:id/iv_checkbox\").instance(3)")).click();

//        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='English']/parent::android.widget.LinearLayout/parent::android.widget.RelativeLayout/child::android.widget.ImageView[@resource-id='com.flipkart.android:id/iv_checkbox']")).click();

        System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='English']/parent::android.widget.LinearLayout/parent::android.widget.RelativeLayout/child::android.widget.ImageView[@resource-id='com.flipkart.android:id/iv_checkbox']")).isSelected());
        System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='English']/parent::android.widget.LinearLayout/parent::android.widget.RelativeLayout/child::android.widget.ImageView[@resource-id='com.flipkart.android:id/iv_checkbox']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='English']/parent::android.widget.LinearLayout/parent::android.widget.RelativeLayout/child::android.widget.ImageView[@resource-id='com.flipkart.android:id/iv_checkbox']")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='English']/parent::android.widget.LinearLayout/parent::android.widget.RelativeLayout/child::android.widget.ImageView[@resource-id='com.flipkart.android:id/iv_checkbox']")).getText());
        System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='English']/parent::android.widget.LinearLayout/parent::android.widget.RelativeLayout/child::android.widget.ImageView[@resource-id='com.flipkart.android:id/iv_checkbox']")).getAttribute("resource-id"));
        System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='English']/parent::android.widget.LinearLayout/parent::android.widget.RelativeLayout/child::android.widget.ImageView[@resource-id='com.flipkart.android:id/iv_checkbox']")).getAttribute("checked"));
        System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='English']/parent::android.widget.LinearLayout/parent::android.widget.RelativeLayout/child::android.widget.ImageView[@resource-id='com.flipkart.android:id/iv_checkbox']")).getAttribute("displayed"));


        Thread.sleep(3000);
        driver.quit();
    }
}
