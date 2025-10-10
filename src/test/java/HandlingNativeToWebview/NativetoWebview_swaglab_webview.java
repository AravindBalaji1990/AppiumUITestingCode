package HandlingNativeToWebview;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class NativetoWebview_swaglab_webview {

    //    public static AndroidDriver driver;
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.setAutoGrantPermissions(true);

//        options.withBrowserName("Chrome");
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
//        options.setIgnoreHiddenApiPolicyError(true);
        options.setAppWaitForLaunch(true);
//        options.withBrowserName("Chrome");// if hybriod app is being tested this capability is not required when tetsing hybrid it will result in exception
//        options.setChromedriverExecutable(System.getProperty("user.dir") + "/src/test/resources/browser/chromedriver_141");


//        options.setAutoWebview(true);
//        options.setAutoWebviewTimeout(Duration.ofMillis(5000));
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);


        driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
        driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
        Thread.sleep(4000);


        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")).click();
        Thread.sleep(5000);

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"WEBVIEW\"]")).click();
        Thread.sleep(5000);


        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-enter a https url here...\"]")).sendKeys("https://www.bing.com");
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-GO TO SITE\"]")).click();
        Thread.sleep(5000);

        //switch to the webview content
        // getContextHandles() - will get botht he native and the webview content
        Set<String> contextname = driver.getContextHandles();
        for (String data : contextname) {
            System.out.println("webview content avaiable -> " + data);
        }

        //switch our control to webview
        driver.context("WEBVIEW_com.swaglabsmobileapp");
        Thread.sleep(3000);
        System.out.println(driver.getPageSource());
        System.out.println(driver.getCurrentUrl());
        driver.findElement(AppiumBy.xpath("//textarea[@id='sb_form_q']")).sendKeys("appium");

        //Webview to native app mode
        driver.context("NATIVE_APP");

        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().back();

        // Gesture way of going back to the particular page
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
        driver.quit();

    }
}
