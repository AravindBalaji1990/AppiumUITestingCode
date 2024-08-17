package FirstScriptAndorid;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IdentifyLocatorAndorid {
public AndroidDriver driver;
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofSeconds(60));

        // calling the andorid driver to run the app
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(3000);

//        driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@content-desc,'Accessib')]")).click();
//        driver.findElement(AppiumBy.accessibilityId("Accessibility")).click();


//        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\\\"android.widget.ListView\n" +
//                "                \\\").childSelector(new UiSelector().text(\\\"App\\\")")).click();\

        // to check wether the element is displayed or not
        // retunr either true or false
        System.out.println(driver.findElement(AppiumBy.accessibilityId("Accessibility")).isDisplayed());

        // to check wether the element is enabled or not
        // retunr either true or false
        System.out.println(driver.findElement(AppiumBy.accessibilityId("Accessibility")).isEnabled());

        // to check wether the element is selected by default  or not
        // retunr either true or false
        System.out.println(driver.findElement(AppiumBy.accessibilityId("Accessibility")).isSelected());

        // to retrieve the text linked ot the element mostly in appium it will check for the text attribute
        // returns a string
        System.out.println(driver.findElement(AppiumBy.accessibilityId("Accessibility")).getText());

        // to retrive the attribute mentioned in the validation
        // return a string
        System.out.println(driver.findElement(AppiumBy.accessibilityId("Accessibility")).getAttribute("resource-id"));

        //check the position of the lement
        System.out.println(driver.findElement(AppiumBy.accessibilityId("Accessibility")).getLocation());

        //check the size that means the height and width of the elment
        System.out.println(driver.findElement(AppiumBy.accessibilityId("Accessibility")).getSize());

        //to check whether the element is not present onthe screen
        System.out.println(driver.findElements(AppiumBy.accessibilityId("Accessibility")).isEmpty());
        //to get the total number of elements available in the app
        System.out.println(driver.findElements(AppiumBy.accessibilityId("Accessibility")).size());


    }
}
