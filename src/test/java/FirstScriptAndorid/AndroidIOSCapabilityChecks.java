package FirstScriptAndorid;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;

import java.time.Duration;

public class AndroidIOSCapabilityChecks {

    public static void main(String[] args) {

    }

    public void AndoridCapability(){
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofSeconds(60));
        options.noReset();
        options.fullReset();
        options.setAppWaitActivity("");
        options.autoGrantPermissions(); // any device specific popup it will be handles
        options.setIgnoreHiddenApiPolicyError(true);//device with oppo,vivo
        options.setSkipUnlock(true ); // skips the deivce unlock check
        options.disableWindowAnimation(); // to runthe device faster
    }

    public void IosCapability(){
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("IOS");
        options.setUdid("62622A19-BE5E-45CE-AF31-EDE73B855E60");
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
        options.setBundleId("com.moataz.dailycheck");
        options.setWaitForIdleTimeout(Duration.ofSeconds(30));
        options.noReset(); // the app wil lopen where it last did
        options.fullReset(); // the app will be like re-installed
        options.setAutoAcceptAlerts(true); // any device specific popup it will be handles
        options.reduceMotion(); // runthe tests faster
        options.enablePerformanceLogging(); // help to collect the cpu usage details
        options.setUseNewWDA(true); // webdriver agent where we can uninstall/re-install the webdriver agent
        options.setShowXcodeLog(true);//xcode based logs on the appium server
    }
}
