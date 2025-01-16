package handlingBasicValidations;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class HandlingElementsBasics_Android {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
//        options.setDeviceName("29221JEGR00379"); // this cannot differnetiate between simulator and real device if multiple devices are connected
        options.setUdid("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppPackage("io.appium.android.apis");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        Thread.sleep(5000);

        WebElement accessibilitybutton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Accessibility']"));

        System.out.println(accessibilitybutton.isDisplayed());
        System.out.println(accessibilitybutton.isEnabled());
        System.out.println(accessibilitybutton.getText());
        System.out.println(accessibilitybutton.getAttribute("resource-id"));

        Thread.sleep(5000);
        driver.quit();



    }
}
