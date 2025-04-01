package startappiumcode;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class HandlingCodeWayToStartAppium {

    public static void main(String[] args) throws MalformedURLException {

        String ipaddress = "127.0.0.1";
        int port = 4723;


        // using code level to start appium
        // where the appium main.js the ip address and the port number incwhich it runs
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        // windows users
//        serviceBuilder.withAppiumJS(new File("C:\\Users\\aravi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//                .withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(120))
//                .build().start();
        //mac users
        serviceBuilder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress(ipaddress).usingPort(port).withTimeout(Duration.ofSeconds(120))
                .build().start();


        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
//        options.setAppPackage("com.saucelabs.mydemoapp.rn");
//        options.setAppActivity("com.saucelabs.mydemoapp.rn.MainActivity");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");

//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

        // calling the andorid driver to run the app̵
        AndroidDriver driver = null;
        try {
             driver = new AndroidDriver(new URL("http://"+ipaddress+":"+String.valueOf(port)), options);

//        WebElement element = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView"));
            WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]\n"));
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            //Scroll/swipe action
            Dimension dim = driver.manage().window().getSize();
            int start1 = dim.getWidth() / 2;
            int start2 = dim.getHeight() / 2;

            int end1 = (int) ((int) dim.getHeight() * 0.25);
            int end2 = start1;

            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "touch1");
            Sequence seq = new Sequence(finger1, 1)
                    .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start1, start2))
                    .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(new Pause(finger1, Duration.ofMillis(500)))
                    .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), end2, end1))
                    .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList(seq));
            System.out.println("-----Swipe Ended-----");
        }catch (Exception e){

        }finally {
            System.out.println("inside  finally block");
            driver.quit();
            System.out.println("cehcking whether the service is up : " + serviceBuilder.build().isRunning());
            serviceBuilder.build().stop();
        }


    }
}
