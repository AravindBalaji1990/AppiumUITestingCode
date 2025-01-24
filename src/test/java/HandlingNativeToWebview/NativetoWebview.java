package HandlingNativeToWebview;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class NativetoWebview {

    //    public static AndroidDriver driver;
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.autoWebview();
//        options.autoGrantPermissions();
//        options.setAutoWebview(true);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/SampleApp/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
//        options.setAppWaitDuration(Duration.ofMillis(50000));
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        // login
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).sendKeys("standard_user");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys("secret_sauce");
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")).click();

        //click on side menu
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")).click();

        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-WEBVIEW\"]")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-enter a https url here...\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-enter a https url here...\"]")).sendKeys("https://www.google.com");
        Thread.sleep(5000);

        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-GO TO SITE\"]")).click();
        Thread.sleep(5000);

        //check the current context
        System.out.println("where i am " + driver.getContext());

        //check for any other webview available
        System.out.println("where i am " + driver.getContextHandles());

        //check for any other webview available
        driver.getContextHandles();// 1 native view and 1 webview
        Thread.sleep(5000);
        Set<String> handles = driver.getContextHandles();
        for (String webviewcontent : handles) {
            if (webviewcontent.equalsIgnoreCase("WEBVIEW")) {
                driver.context("WEBVIEW_com.swaglabsmobileapp");
                System.out.println(driver.getPageSource());
                break;
            }
        }

        // 0 will be native_app and 1 will be webview
//        String webpage = new ArrayList<String>(handles).get(1);
        Thread.sleep(5000);


        //Webview to native
        driver.context("NATIVE_APP");
        Thread.sleep(3000);
        driver.navigate().back();

        Thread.sleep(5000);
        driver.quit();
    }

    public static Point getCenterElement(Point location, Dimension dim) {
        return new Point(location.getX() + dim.getWidth() / 2, location.getY() + dim.getHeight() / 2);

    }
}
