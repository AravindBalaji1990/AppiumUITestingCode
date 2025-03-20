package FirstScriptAndorid;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SampleCode1 {

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

        // driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Sauce Labs Onesie\")").click();


        List<WebElement> mytext = driver.findElements(AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]/android.view.ViewGroup"));
        System.out.println(mytext.size());

        for (int i = 0; i < mytext.size(); i++) {

            if (mytext.get(i).getText().equalsIgnoreCase("Sauce Labs Onesie")) {
                System.out.println("All Text:" + mytext.get(i).getText());
            }
//            mytext.get(i).click();
            Thread.sleep(3000);
            driver.quit();

        }
    }
}
