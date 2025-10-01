package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class HandlingGestures_swipe_back_screen {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
//        options.setUdid("29221JEGR00379");
        options.setUdid("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);

        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAutoGrantPermissions(true);// to allow the location to true
//        options.setIgnoreHiddenApiPolicyError(true);// this one will beused when native android application is used - oppo/samsung/vivo
//        options.noReset(); // it will clear the app cache and start it as a fresh


        // calling the andorid driver to run the app̵
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        WebElement ele_animation = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Animation\"]"));
        ele_animation.click();

        Thread.sleep(3000);
        System.out.println("the screen available : " +driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Bouncing Balls\"]")).isDisplayed());
        Thread.sleep(3000);

//        swipeBack(driver);
        //alternative
        driver.navigate().back();

        System.out.println("the screen is back : " +driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Animation\"]")).isDisplayed());


        Thread.sleep(3000);
        driver.quit();
    }


    public static void swipeBack(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();

        // shortlisting to width and height of the mobile screen
        int width = size.getWidth();
        int height = size.getHeight();


        // swipe coordinates right to left
        int startX = (int) (width * 0.90); // 90%  from right

        int endX = (int) (width * 0.10); //10% form the left

        // common screen height
        int endY = (int) (height * 0.70);

//        int endY = height/2;

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, endY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

//        driver.perform(Collections.singletonList(sequence));
        driver.perform(Arrays.asList(sequence));

    }

    // manual way to input the screen size
    public static void swipe(AndroidDriver driver, double startXFraction, double startYFraction, double endXFraction, double endYFraction) {
        // get the screen size
        Dimension size = driver.manage().window().getSize();
        // do the calculation to use the back button as a gesture
        int startX = (int) (size.getWidth() * startXFraction);
        int startY = (int) (size.getHeight() * startYFraction);

        int endX = (int) (size.getWidth() * endXFraction);
        int endY = (int) (startY * endYFraction);

        // aciton for the gesture
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

}
