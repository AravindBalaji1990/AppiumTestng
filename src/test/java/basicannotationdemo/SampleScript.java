package basicannotationdemo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SampleScript {
    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;

    @BeforeSuite
    public void startAppium() {
        System.out.println("----starting appium---");
        // the below code will check for the path of the default appium,sdk,ios
        service = AppiumDriverLocalService.buildDefaultService();
        // then start the appium server
        service.start();
    }

    @BeforeTest
    public void initialiseAndroid() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setUdid("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @Test
    public void verifyViewButton() {
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
        Assert.assertTrue(element.isDisplayed(), "element is not displayed on the page");
    }

    @AfterTest
    public void closeAndroid() {
        driver.quit();
    }

    @AfterSuite
    public void stopAppium() {
        service.stop();
    }


}
