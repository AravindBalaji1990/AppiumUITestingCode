package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class HandlingCodeSendkesDemo {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // since we use android we use the AndroidDriver
        AndroidDriver driver;

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        //options.setDeviceName("");// when we do a parallel execution this will nto pickt he device which we have mentioned so we go for udid
        options.setUdid("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");


//        options.setNewCommandTimeout(Duration.ofSeconds(60));
//        options.setAutoGrantPermissions(true);// allow/dont allow/allow while using app
//        options.setAppWaitDuration(Duration.ofSeconds(60));
        options.setCapability("newCommandTimeout", 70); // alternative
//        options.setNoReset(true);
//        options.setIgnoreHiddenApiPolicyError(true);
        // brief,time,raw,process
        options.setLogcatFormat("brief") ;// tag,pid,message
//        options.setAvd("Pixel 8a API 35");
        options.setGpsEnabled(true);



        // calling the andorid driver to run the app̵
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        // click operation
        System.out.println(driver.findElement(AppiumBy.accessibilityId("Views")).isDisplayed());
        System.out.println(driver.findElement(AppiumBy.accessibilityId("Views")).isEnabled());
        System.out.println(driver.findElement(AppiumBy.accessibilityId("Views")).getAttribute("class"));
        System.out.println(driver.findElement(AppiumBy.accessibilityId("Views")).getDomAttribute("enabled"));

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        Thread.sleep(5000);
//        Vertical scroll to the element wheret he action needs to be performed
        // we will be using andoridUIAutomator
        // UIScrollable + scrollintoview - only scrolling - vertical
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"TextFields\").instance(0))")).click();
//        Thread.sleep(5000);

//        driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).click();
//        Thread.sleep(5000);
//
//        driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).sendKeys("TEST CHECK");
        Thread.sleep(5000);

        driver.quit();


    }
}
