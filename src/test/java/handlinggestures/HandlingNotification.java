package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlingNotification {

    public static void main(String[] args) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));

        // calling the andorid driver to run the app
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        // openNotificaitons
        driver.openNotifications();

//        System.out.println("data : " +driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.android.systemui:id/keyguard_message_area_container\"]\n")).getText());
        String otpmessage = driver.findElement(AppiumBy.xpath("//*[contains(@text,'OTP')]")).getText();
//        System.out.println(otpmessage);
        Pattern pattern  = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(otpmessage);
        while(matcher.find()) {
//            System.out.println("data : " +matcher.toString());
            if(matcher.group().toString().length() == 6) {
                String otpextract = matcher.group();
                System.out.println("data : " +matcher.group());
            }

        }

    }
}
