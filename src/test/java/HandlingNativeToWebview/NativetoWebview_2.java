package HandlingNativeToWebview;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class NativetoWebview_2 {

//    public static AndroidDriver driver;
    public  static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAutoGrantPermissions(true);

//        options.withBrowserName("Chrome");
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
//        options.setAutoWebview(true);
//        options.setAutoWebviewTimeout(Duration.ofMillis(5000));
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
        System.out.println(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).getAttribute("content-desc"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"WebView\").instance(0))")).click();


        //switch to the webview content
        Set<String> contextname = driver.getContextHandles();
        for (String data : contextname){
            System.out.println("webview content avaiable -> " +data);
        }

        //switch our control to webview
        driver.context("WEBVIEW_io.appium.android.apis");
//        System.out.println(driver.getPageSource());
//        System.out.println(driver.findElement(By.xpath("//android.webkit.WebView[@resource-id=\"io.appium.android.apis:id/wv1\"]")).isDisplayed());
//        driver.findElement(By.xpath("//android.webkit.WebView[@resource-id=\"io.appium.android.apis:id/wv1\"]")).clear();
//        driver.findElement(By.xpath("//android.webkit.WebView[@resource-id=\"io.appium.android.apis:id/wv1\"]")).sendKeys("test");
        System.out.println(driver.findElement(By.xpath("//*[text()='i am a link']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[text()='i am a link']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[text()='i am a link']")).getAttribute("class"));


//        int width = driver.manage().window().getSize().width;
//        int height = driver.manage().window().getSize().height;
//        int startX = (int) (width * 0.05);
//        int endX = (int) (width * 0.9);
//        int startY = height / 2;
//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        Sequence swipe = new Sequence(finger, 1);
//        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
//        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, startY));
//        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(Arrays.asList(swipe));

        Thread.sleep(3000);

        //Webview to native
//        driver.context("NATIVE_APP");
//
//        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"TextFields\"]\n")).click();
//
//        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit1\"]\n")).sendKeys("Test");
    }
}
