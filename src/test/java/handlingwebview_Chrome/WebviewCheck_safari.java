package handlingwebview_Chrome;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;

public class WebviewCheck_safari {

    //     AppiumDriver driver;
    // to run from command line appium --allow-insecure chromedriver_autodownload
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("IOS");
        options.setUdid("27139D21-EB13-48EE-9C88-C786E92AB0E0");
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
        // to open chrom browser inside the device below 2 options are mandatory
        options.withBrowserName("Safari");
//        options.setCapability("startIWDP", true);// only for real device - to enabling webview debugging mode


        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        //code for chrome
        driver.get("https://bing.com");
        Thread.sleep(5000);
        System.out.println(driver.getPageSource());
        driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys("appium");
        Thread.sleep(5000);
        driver.quit();

    }

//    public UiAutomator2Options getChrome(){
//        UiAutomator2Options options = new UiAutomator2Options();
//        options.setPlatformName("Android");
//        options.setDeviceName("29221JEGR00379");
//        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.withBrowserName("Chrome");
//        return  options;
//    }
}
