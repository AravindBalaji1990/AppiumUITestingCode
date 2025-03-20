package FirstScriptAndorid;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleCode2_IOS {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        XCUITestOptions activity1 = new XCUITestOptions();
        activity1.setPlatformName("IOS");
        activity1.setAutomationName((AutomationName.IOS_XCUI_TEST));
        activity1.setUdid("08BBF8F2-37A6-42E0-AB9F-65C5E6AEC31B");
        activity1.setBundleId("com.moataz.dailycheck");


        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), activity1);





        System.out.println(driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"8:00 PM Click the plus button to add a scheduled task.\"]")).getText());
        System.out.println(driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"8:00 PM Click the plus button to add a scheduled task.\"]")).getAttribute("name"));
        System.out.println(driver.findElement(AppiumBy.xpath("(//XCUIElementTypeButton[@name=\"circle\"])[1]")).isDisplayed());
        System.out.println(driver.findElement(AppiumBy.xpath("(//XCUIElementTypeButton[@name=\"circle\"])[1]")).isEnabled());
        System.out.println(driver.findElement(AppiumBy.xpath("(//XCUIElementTypeButton[@name=\"circle\"])[1]")).isSelected());

        if(driver.findElement(AppiumBy.xpath("(//XCUIElementTypeButton[@name=\"circle\"])[1]")).isSelected()){
            System.out.println("the condition is true");
        }else{
            driver.findElement(AppiumBy.xpath("(//XCUIElementTypeButton[@name=\"circle\"])[1]")).click();
            System.out.println(driver.findElement(AppiumBy.xpath("(//XCUIElementTypeButton[contains(@name,\"circle\")])[1]")).isSelected());
        }
        Thread.sleep(3000);
        driver.quit();

    }
}
