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
import java.util.Collections;
import java.util.List;

public class HandlingGestureDemo_swipe_ToTopForAElement {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");

//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        // calling the andorid driver to run the app̵
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

//        WebElement element = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView"));
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]\n"));
//        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        Thread.sleep(5000);

        int n =10;
        for (int i =0 ; i< n;i++) {
            swipeDown(driver);
            List<WebElement> item = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"TextFields\"]"));
            if(item.size()>0){
                System.out.println("the element is visible");
                item.get(0).click();
                break;
            }
        }

        //Scroll/swipe action - swipe  up
//        Dimension size = driver.manage().window().getSize();
//        int startX = 500;
//        int startY = 1000;
//
//        int endX = 500;
//        int endY = 2000;
//        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
//        Sequence sequence = new Sequence(finger1, 1)
//                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
//                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
////                .addAction(new Pause(finger1, Duration.ofMillis(200)))
//                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
//                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//        driver.perform(Collections.singletonList(sequence));


        Thread.sleep(3000);
        driver.quit();
    }

    public static void swipeDown(AndroidDriver driver){
        // to get the dimention of the screen
        Dimension dim = driver.manage().window().getSize();
        System.out.println("the dimenion of the screen : " + dim);
        // from where till where i need to swipe i am checking it
        // by getting the x and y dimention of the screen
        int start1 = dim.getWidth()/2;// if we do vertical scroll based on gestute the x axis is not chnaging
        int start2 = dim.getHeight()/2;

        // since we are doing a swipe down the end1 will be calculated
        int end1 = (int) ((int) dim.getHeight() * 0.25);
        int end2 = start1;

        // the pointer input usually represents a input
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "touch1");

        // sequence represents the sequence of action we are going to do
        Sequence seq = new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),start1,start2))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(500)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100),PointerInput.Origin.viewport(), end2, end1))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(seq));
        System.out.println("-----Swipe Ended-----");
    }


    public static void swipeUp(AndroidDriver driver){
        Dimension dim = driver.manage().window().getSize();
        int start1 = dim.getWidth() / 2;
        int start2 = (int) (dim.getHeight() * 0.25);  // Start higher up at 25% of the screen height

        int end1 = dim.getHeight() / 2;  // End at the center of the screen
        int end2 = start1;

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "touch1");
        Sequence seq = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start1, start2))  // Start at higher position
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(500)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), end2, end1))  // Move downward
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(seq));

    }
}
