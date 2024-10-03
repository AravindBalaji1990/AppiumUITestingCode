package FirstScriptAndorid;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LocatorCheckIos {

    public static void main(String[] args) throws IOException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("IOS");
        options.setDeviceName("iPhone 16 Plus");
        options.setUdid("A332C391-A85E-4B1E-8F55-63695EB04AED");
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
        options.setBundleId("com.moataz.dailycheck");
        options.setWaitForIdleTimeout(Duration.ofSeconds(30));
        options.setUseNewWDA(false);

        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"),options);


        Thread.sleep(5000);
        System.out.println(driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name ='Create new task' and @value='Create new task']")).isDisplayed());

        File fs = new File("/Users/aravindbalaji/IdeaProjects/AppiumDemo/src/test/resources/pagesource/ios_pagesource.txt");
        try{
            FileWriter fw = new FileWriter(fs);
            fw.write(String.valueOf(driver.getPageSource()));

        }catch (Exception e){
            e.getStackTrace();
        }




        Thread.sleep(4000);
        driver.quit();
    }
}
