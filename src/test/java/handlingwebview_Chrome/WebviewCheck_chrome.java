package handlingwebview_Chrome;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;

public class WebviewCheck_chrome {

    //     AppiumDriver driver;
    // to run from command line appium --allow-insecure chromedriver_autodownload
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.withBrowserName("Chrome");
        options.setChromedriverExecutable(System.getProperty("user.dir") + "/src/test/resources/browser/chromedriver_mac");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
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
