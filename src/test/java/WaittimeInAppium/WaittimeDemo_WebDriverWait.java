package WaittimeInAppium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class WaittimeDemo_WebDriverWait {

    public static void main(String[] args) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
        options.setAutoGrantPermissions(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Views']"));

//        System.out.println(checkElementVisibility(driver, element, 30));
        System.out.println(checkElementSize(driver, AppiumBy.xpath("//android.widget.TextView[@content-desc='Views']"),30, 1));


        driver.quit();
    }


    public static boolean checkElementPresense(AppiumDriver driver, WebElement element, long seconds) {
        boolean data = false;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement dataelement = wait.until(ExpectedConditions.visibilityOf(element));
        if (dataelement != null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkElementPresense(AppiumDriver driver, By element, long seconds) {
        boolean data = false;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement dataelement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
        if (dataelement != null) {
            return true;
        } else {
            return false;
        }
    }

    public static int checkElementSize(AppiumDriver driver, By element, long seconds, int num) {
        boolean data = false;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        List<WebElement> dataelement = wait.until(ExpectedConditions.numberOfElementsToBe(element,num ));
        return dataelement.size();
    }

    public static int checkElementSizeLessThan(AppiumDriver driver, By element, long seconds, int num) {
        boolean data = false;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        List<WebElement> dataelement = wait.until(ExpectedConditions.numberOfElementsToBeLessThan(element,num ));
        return dataelement.size();
    }
}
