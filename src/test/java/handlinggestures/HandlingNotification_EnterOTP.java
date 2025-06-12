package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlingNotification_EnterOTP {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setUdid("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("com.flipkart.android");
        options.setAppActivity("com.flipkart.android.activity.HomeFragmentHolderActivity");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));
        options.setAutoGrantPermissions(true);

        // calling the andorid driver to run the app
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // this will clear the content of the notifications
        Thread.sleep(5000);
//        driver.openNotifications();// open the notificaiton panel
//        try {
//            driver.findElement(AppiumBy.xpath("//*[@text=\"Clear all\"]")).click();
//        } catch (Exception e) {
//            System.out.println("no clear button visible");
//            swipeUp(driver);
//        }
//
//        Thread.sleep(5000);

//        driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.flipkart.android:id/iv_checkbox\"])[4]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.flipkart.android:id/tv_text\" and @text=\"English\"]/following-sibling::android.widget.ImageView")).click();
        Thread.sleep(10000);


        // clicking the link use email id
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Use Email-ID']")).click();

        Thread.sleep(5000);
        //send the email id to the text field
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Email ID\"]")).sendKeys("aravind_sparrow@yahoo.com");

        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.flipkart.android:id/button\"]")).click();

        Thread.sleep(5000);

//enter the otp

        // if keyboard available and sendkesy works
//        if(driver.isKeyboardShown()){
//            System.out.println("keyboard is shown");
//            driver.hideKeyboard();
//        }
//        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.flipkart.android:id/otp_view\"]")).sendKeys("111111");

        // if sendkeys doesnt work
        if (driver.isKeyboardShown()) {
            System.out.println("keyboard is shown");
//            driver.hideKeyboard();
        }
        // this is specific to andoird where the keyboard simulation is replicated by the below code
        // if keyboard isnot enabled by default and sendkeys doesnt work
//        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.flipkart.android:id/otp_view\"]")).click();
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));

        Thread.sleep(5000);
        driver.quit();
    }


    public static void swipeUp(AndroidDriver driver) {
        // this does not focus on th element to swipe up but instead on the entire screen size / view port
        // Get screen size
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();

        // Calculate start and end points for swipe
        int startX = screenWidth / 2;// width of the screen no use in swipe up
        int startY = (int) (screenHeight * 0.8); // Start near the bottom
        int endY = (int) (screenHeight * 0.2);   // End near the top

        // Define PointerInput for touch interaction
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        // Create a sequence for swipe-up action
        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY)); // Move to start point
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())); // Press down
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startX, endY)); // Move to end point
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); // Release

        // Perform the action
        driver.perform(Arrays.asList(swipe));
    }
}
