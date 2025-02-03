package testngparallelwithTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ParallelTestingTests3 {

//    AppiumDriver driver;

    @AfterTest
    public void end() {
//        driver.quit();
    }


    @Test
    public void testcase1() throws MalformedURLException {
        System.out.println("this is  my testcase");
        System.out.println("this is starts");
        System.out.println("this is the before");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
//        options.setDeviceName("emulator-5554");
        options.setDeviceName("29221JEGR00379");
        options.setAutoGrantPermissions(true);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
//        options.setAppWaitForLaunch(true);
//        options.setAppWaitDuration(Duration.ofMillis(50000));
        options.setNewCommandTimeout(Duration.ofSeconds(60));
       AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
//        WaitUtility.waitforElement(driver,60,AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView") );
//        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView"));
//        Assert.assertTrue(ele.isDisplayed());
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).isDisplayed());
    }

//    //@Test
//    public void testcase2() {
//        System.out.println("this is  my testcase");
////        WaitUtility.waitforElement(driver,60,AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView") );
////        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView"));
////        Assert.assertTrue(ele.isDisplayed());
//        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Text\"]")).isDisplayed());
//    }

    @Test
    public void testcase3() throws MalformedURLException {
        System.out.println("this is starts");
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 16 Plus");
        options.setUdid("9C4CF5F8-F6CD-44FC-AC73-5B595592AD1B");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/SampleApp/ios-app.zip");
        options.setBundleId("com.saucelabs.mydemoapp.rn");
        options.setUseNewWDA(false);
//        options.setAutoWebview(true);
        options.setAppPushTimeout(Duration.ofMillis(50000));

//        options.setBundleId("com.moataz.dailycheck");

      IOSDriver  driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        Assert.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"plus.circle\"]")).isDisplayed());


    }
}
