package FirstScriptAndorid;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IdentifyLocatorIos {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("IOS");
        options.setUdid("62622A19-BE5E-45CE-AF31-EDE73B855E60");
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
        options.setBundleId("com.moataz.dailycheck");
        options.setWaitForIdleTimeout(Duration.ofSeconds(30));

        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"),options);


        boolean elementdisplay = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Edit']")).isDisplayed();

        System.out.println("the element is displayed : " +elementdisplay);
        Thread.sleep(5000);
//        driver.findElement(AppiumBy.accessibilityId("Edit")).click();


//        Thread.sleep(5000);
//        System.out.println("the minus is visible : " + driver.findElement(AppiumBy.xpath(("//XCUIElementTypeImage[@name='minus.circle.fill'])[1]"))).isDisplayed());
//        System.out.println("the minus is visible : " + driver.findElement(AppiumBy.xpath(("//XCUIElementTypeButton[@name='Remove Create new task, 8:00 PM Click the plus button to add a scheduled task.']/child::XCUIElementTypeImage[@name='minus.circle.fill']"))).isDisplayed());
        Thread.sleep(5000);


        // iosNsPredicateString is not only for label but any property we can use ot to identify the element
        System.out.println("check wether the element is dispalyed: " + driver.findElement(AppiumBy.iOSNsPredicateString("label == '8:00 PM Click the plus button to add a scheduled task.'")).isDisplayed());
        System.out.println("check wether the element is dispalyed: " + driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Update your task'")).isDisplayed());


        // iosclasschain
        System.out.println("cehck wether is enabled : "+ driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell/**/XCUIElementTypeButton[`name=='circle'`]")).isEnabled());
        driver.quit();
    }
}
