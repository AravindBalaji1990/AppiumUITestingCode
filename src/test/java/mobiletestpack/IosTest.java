package mobiletestpack;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IosTest {
    public static void main(String[] args) throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/ios-app.zip");
//        options.setAutoWebview(true);
//        options.setAppPushTimeout(Duration.ofMillis(50000));

        options.setBundleId("com.moataz.dailycheck");
        options.setUdid("00008130-0006614921E8001C");

        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

        // static sleeper it will wait till the time is over
//        Thread.sleep(5000);

        boolean checkdisplayed = driver.findElement(By.cssSelector("XCUIElementTypeStaticText[name='Create new task']")).isDisplayed();
        System.out.println("check is displayed: "+ checkdisplayed);
        boolean checkenabled = driver.findElement(By.cssSelector("XCUIElementTypeStaticText[name='Create new task']")).isEnabled();
        System.out.println("check is enabled: "+ checkenabled);

    }
}
