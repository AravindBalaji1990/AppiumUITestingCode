package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HandlingGestureWeatherApplication {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setUdid("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        // capability to allow the location based permission or any default permission
        options.setAutoGrantPermissions(true);
        options.setAppPackage("com.google.android.apps.weather");
        options.setAppActivity("com.google.android.apps.weather.home.HomeActivity");


        // calling the andorid driver to run the app̵
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        Thread.sleep(10000);

        driver.findElement(AppiumBy.xpath("//androidx.cardview.widget.CardView[@resource-id=\"com.google.android.apps.weather:id/location_card_view\"]/android.view.ViewGroup/android.widget.TextView[@text='Mesaieed']")).click();

        Thread.sleep(3000);

//        List<WebElement> weatheritem = driver.findElements(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.google.android.apps.weather:id/hourly_entry\"])"));
        List<WebElement> weatheritem = driver.findElements(AppiumBy.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.apps.weather:id/hourly_forecast_block_recycler_view\"]/android.view.ViewGroup"));

        WebElement widgetwaether = driver.findElement(AppiumBy.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.apps.weather:id/hourly_forecast_block_recycler_view\"]"));
        int indexweather = weatheritem.size();
        for (int i = 0; i < weatheritem.size(); i++) {
            swipeElementRightToLeft(driver, weatheritem.get(i));
        }
        Thread.sleep(3000);
        driver.quit();


    }

    public static void swipeLeft(AndroidDriver driver, WebElement ele) {
        int startX = ele.getRect().x + (ele.getSize().width * 3 / 4);
        int startY = ele.getRect().y + (ele.getSize().height / 2);
        int endX = ele.getRect().x + (ele.getSize().width / 4);
        int endY = ele.getRect().y + (ele.getSize().height / 2);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "touch1");
        Sequence seq = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(500)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(seq));
        System.out.println("-----Swipe Ended-----");
    }

    public static void swipeElementRightToLeft(AndroidDriver driver, WebElement element) {

        int startX = element.getLocation().getX() + element.getSize().getWidth() - 10;
        int endX = element.getLocation().getX() + 10;
        int y = element.getLocation().getY() + (element.getSize().getHeight() / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public static void swipeRightToLeft(AndroidDriver driver) {
        int startX = (int) (driver.manage().window().getSize().width * 0.9);
        int endX = (int) (driver.manage().window().getSize().width * 0.1);
        int y = (int) (driver.manage().window().getSize().height * 0.5);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public static void swipeElement(AndroidDriver driver, WebElement element, boolean leftToRight) {
        int startX = leftToRight ? element.getLocation().getX() + 10
                : element.getLocation().getX() + element.getSize().getWidth() - 10;
        int endX = leftToRight ? element.getLocation().getX() + element.getSize().getWidth() - 10
                : element.getLocation().getX() + 10;
        int y = element.getLocation().getY() + (element.getSize().getHeight() / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }
}
