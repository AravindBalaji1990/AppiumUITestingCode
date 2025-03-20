package FirstScriptAndorid;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SampleCode2 {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        UiAutomator2Options activity1 = new UiAutomator2Options();
        activity1.setPlatformName("Android");
        activity1.setAutomationName((AutomationName.ANDROID_UIAUTOMATOR2));
        activity1.setUdid("29221JEGR00379");
        activity1.setAppPackage("com.swaglabsmobileapp");
        activity1.setAppActivity("com.swaglabsmobileapp.MainActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), activity1);
        driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
        driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
        Thread.sleep(4000);

        System.out.println(driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup/android.widget.ImageView")).getText());
        System.out.println(driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup/android.widget.ImageView")).getAttribute("text"));
        System.out.println(driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup/android.widget.ImageView")).isDisplayed());
        System.out.println(driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup/android.widget.ImageView")).isEnabled());
//        System.out.println(driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup/android.widget.ImageView")).isSelected());


        System.out.println(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]")).getText());
        System.out.println(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]")).getAttribute("content-desc"));
        System.out.println(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]")).isDisplayed());
        System.out.println(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]")).isEnabled());
        Thread.sleep(3000);
        driver.quit();

    }
}
