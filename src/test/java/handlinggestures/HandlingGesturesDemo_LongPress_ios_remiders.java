package handlinggestures;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class HandlingGesturesDemo_LongPress_ios_remiders {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setUdid("27139D21-EB13-48EE-9C88-C786E92AB0E0");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/ios-app.zip");
//        options.setAutoWebview(true);
//        options.setAppPushTimeout(Duration.ofMillis(50000));
        options.setUseNewWDA(false);
        options.setBundleId("com.apple.reminders");

        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

        WebElement elementall = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[contains(@name,\"All,\")]"));
        Actions act = new Actions(driver);
        act.click(elementall).build().perform();

        WebElement elementtitle =   driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Title\"]"));
        elementtitle.click();
//        //long press gesture handling
        Point location = elementtitle.getLocation();
        Dimension size = elementtitle.getSize();
        Point centerofelement = getCenterElement(location, size);


        PointerInput touchaction1 = new PointerInput(PointerInput.Kind.TOUCH, "fingertouch1");
        Sequence seq = new Sequence(touchaction1, 1)
                .addAction(touchaction1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),centerofelement))
                .addAction(touchaction1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(touchaction1,Duration.ofSeconds(3)))
                .addAction(touchaction1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(seq));

        //Alternative way using Actions class
//        Actions action = new Actions(driver);
//        action.clickAndHold(element).pause(Duration.ofSeconds(4)).build().perform();

        Thread.sleep(3000);
        driver.quit();

    }

    public static Point getCenterElement(Point location, Dimension dim) {
        return new Point(location.getX() + dim.getWidth() / 2, location.getY() + dim.getHeight() / 2);

    }

}
