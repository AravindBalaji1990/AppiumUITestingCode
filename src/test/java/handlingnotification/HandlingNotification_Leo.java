package handlingnotification;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlingNotification_Leo {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("com.leo1_card");
        options.setAppActivity("com.leo1_card.MainActivity");
        options.setAppWaitForLaunch(true);
        options.autoGrantPermissions();
        options.setAppWaitDuration(Duration.ofMillis(50000));

        // calling the andorid driver to run the app
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);


        Thread.sleep(5000);
        WebElement ph = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Registered Mobile number\"]"));
//        WebElement inputphonenumber =  driver.findElement(AppiumBy.accessibilityId("Phone Number"));

        // Keyboard action simulator to enter the phone number
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));

        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//com.horcrux.svg.GroupView/com.horcrux.svg.PathView[1]")).click();

        String otpfromnotification = getOtp(driver);
        swipeUp(driver);
//        otpfromnotification ="1234";

        Thread.sleep(10000);
        List<WebElement> otpbox = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text=\"Verify OTP\"]/parent::android.view.ViewGroup/android.view.ViewGroup[2]//android.widget.TextView[1]"));
        otpbox.get(0).click();
        char[] dataotp = otpfromnotification.toCharArray();
        if(dataotp.equals("1")){
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        } else if (dataotp.equals("2")) {
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));

        }else if (dataotp.equals("3")) {
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));

        }else if (dataotp.equals("4")) {
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));

        }else if (dataotp.equals("5")) {
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));

        }else if (dataotp.equals("6")) {
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));

        }else if (dataotp.equals("7")) {
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));

        }else if (dataotp.equals("8")) {
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));

        }else if (dataotp.equals("9")) {
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));

        }else if (dataotp.equals("0")) {
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));

        }


        Thread.sleep(5000);
        driver.quit();
    }


    public static void swipeUp(AndroidDriver driver) {
        // Get screen size
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();

        // Calculate start and end points for swipe
        int startX = screenWidth / 2;
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

    public static String getOtp(AndroidDriver driver) throws InterruptedException {
        String smsotp = null;
        driver.openNotifications();
        Thread.sleep(10000);
        System.out.println("data : " + driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.android.systemui:id/keyguard_message_area_container\"]\n")).getText());
        String otpmessage = driver.findElement(AppiumBy.xpath("//*[contains(@text,'OTP')]")).getText();
        System.out.println("the complete otp message : " + otpmessage);
        // we use a regex to validate or extract  the pattern related to otp
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(otpmessage);

        while (matcher.find()) {
            System.out.println("data from sms: " + matcher.toString());
            if (matcher.group().toString().length() == 6) {
                String otpextract = matcher.group();
                System.out.println("extracted data from sms : " + matcher.group());
                smsotp = matcher.group();
            }
        }

        return smsotp.trim();
    }
}
