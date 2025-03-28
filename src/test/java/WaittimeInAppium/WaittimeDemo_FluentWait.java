package WaittimeInAppium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.function.Function;

public class WaittimeDemo_FluentWait {

    public static void main(String[] args) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
        options.setAutoGrantPermissions(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

//        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Views']"));
//        System.out.println(element.isDisplayed());

        FluentWait<AndroidDriver> waittime = new FluentWait<>(driver);
        waittime.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        WebElement element = waittime.until(new Function<AndroidDriver, WebElement>() {
            @Override
            public WebElement apply(AndroidDriver driver) {
                return driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Views']"));
            }
        });

        element.click();


        driver.quit();
    }

    public static void fluentwaitdemo(AndroidDriver driver, WebElement element){
        FluentWait<AndroidDriver> waittime = new FluentWait<>(driver);
        waittime.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(Exception.class)
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
