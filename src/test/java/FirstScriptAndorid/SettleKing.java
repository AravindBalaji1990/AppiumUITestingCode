package FirstScriptAndorid;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SettleKing {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("com.settleking.apps");
        options.setAppActivity("com.settleking.apps.MainActivity");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofSeconds(60));

        // calling the andorid driver to run the app
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(3000);

        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"OR\"]/android.widget.EditText[1]")).click();
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"OR\"]/android.widget.EditText[1]")).sendKeys("ratna27@yopmail.com");

        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"OR\"]/android.widget.EditText[2]")).click();
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"OR\"]/android.widget.EditText[2]")).sendKeys("Ratna@236");

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Sign in\"]")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
