package testngparallelwithTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import waittimeAppium.WaitUtility;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ParallelTestingTests {
static AndroidDriver driver;

    @BeforeTest
    public void start() throws MalformedURLException {
        System.out.println("this is starts");
        System.out.println("this is the before");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setUdid("29221JEGR00379");
//        options.setCapability("systemPort",8202);

        options.setAutoGrantPermissions(true);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/SampleApp/android-app.apk");

        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
//        options.setAppWaitForLaunch(true);
//        options.setAppWaitDuration(Duration.ofMillis(50000));
        options.setNewCommandTimeout(Duration.ofSeconds(60));
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

    }

    @AfterTest
    public void end(){
        System.out.println("this is end");
        driver.quit();
    }


    @Test
    public void testcase1(){
        System.out.println("this is  my testcase");
//        WaitUtility.waitforElement(driver,60,AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView") );
//        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView"));
//        Assert.assertTrue(ele.isDisplayed());
    Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).isDisplayed());
    }
}
