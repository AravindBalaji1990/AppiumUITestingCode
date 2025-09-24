package handlingelementvalidation;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LocatorCheckAndroid {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("H0C9FI1LV01B0300012");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
//        options.setAppWaitForLaunch(true);
//        options.setAppWaitDuration(Duration.ofSeconds(60));

        // calling the andorid driver to run the app
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(3000);

        WebElement txt_username = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]"));
        LocatorCheckAndroid obj = new LocatorCheckAndroid();
        if (obj.validateElement(driver, txt_username)) {
            System.out.println("my case is passed");
        } else {
            throw new RuntimeException();
        }


        Thread.sleep(3000);
        driver.quit();
    }


    public boolean validateElement(AndroidDriver driver, WebElement element) {
        if (element.isDisplayed() && element.isEnabled()) {
            System.out.println(element.isDisplayed());
            element.sendKeys("standard_user");
            System.out.println("get the attribute of the element : " + element.getAttribute("content-desc"));
            return true;
        } else {
            return false;
        }

    }
}
