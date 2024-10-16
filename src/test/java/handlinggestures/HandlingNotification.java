package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandlingNotification {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("com.flipkart.android");
        options.setAppActivity("com.flipkart.android.activity.HomeFragmentHolderActivity");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));

        // calling the andorid driver to run the app
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);


        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.flipkart.android:id/iv_checkbox\"])[4]")).click();
        Thread.sleep(5000);

//        driver.findElement(AppiumBy.xpath("(//android.widget.Button[@text='CONTINUE']")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"CONTINUE\")")).click();
        Thread.sleep(5000);

//        driver.findElement(AppiumBy.xpath("(//android.widget.EditText[@content-desc=\"Phone Number\"]")).sendKeys("8939624446");
//        driver.findElement(AppiumBy.accessibilityId("Phone Number")).click();
       WebElement ph =  driver.findElement(AppiumBy.accessibilityId("Phone Number"));
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
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));
        // in certain instance the sendkeys will not work
//        inputphonenumber.sendKeys("8939624446");
        // in Mobile automation the javascript executor will not work
//        driver.executeScript("arguments[0].value='8939624446';", ph);

        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.flipkart.android:id/button\"]")).click();


        // openNotificaitons -> its inbuilt function
        driver.openNotifications();
        Thread.sleep(10000);

//        System.out.println("data : " +driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.android.systemui:id/keyguard_message_area_container\"]\n")).getText());
        String otpmessage = driver.findElement(AppiumBy.xpath("//*[contains(@text,'OTP')]")).getText();
        System.out.println("the complete otp message : " + otpmessage);
        // we use a regex to validate or extract  the pattern related to otp
        Pattern pattern  = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(otpmessage);
        String smsotp = null;
        while(matcher.find()) {
            System.out.println("data from sms: " +matcher.toString());
            if(matcher.group().toString().length() == 6) {
                String otpextract = matcher.group();
                System.out.println("extracted data from sms : " +matcher.group());
                smsotp = matcher.group();
            }
        }

        // if the otp field is not auto populating then we can use the otp elements to iterate throught the text box and fill the data
//        char[] data = smsotp.toCharArray();
//        for (int i=0 ; i< data.length; i++){
//            driver.findElement(AppiumBy.xpath("")).sendKeys(String.valueOf(data[i]));
//        }

        // to clos e the notificaiotn dn ago back to the app
        Dimension size = driver.manage().window().getSize();
        int startx = size.width/2;
        int starty = (int) (size.height*0.8);
        int endy = (int) (size.height*0.2);

        PointerInput touchaction1 = new PointerInput(PointerInput.Kind.TOUCH,"swipe");
        Sequence seq = new Sequence(touchaction1, 1)
                //this simulates the tap
                .addAction(touchaction1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),startx,starty))
//                .addAction(touchaction1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),500,1000))
                // this simulates the tap onthe element
                .addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                // this simulates the tap duration
                .addAction(new Pause(touchaction1,Duration.ofMillis(500)))
                .addAction(touchaction1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),startx,endy))

                // this simulates the relase of tap/finger on the element
                .addAction(touchaction1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // this will perfomr the series of actions
        driver.perform(Arrays.asList(seq));


        Thread.sleep(5000);
        driver.quit();
    }
}
