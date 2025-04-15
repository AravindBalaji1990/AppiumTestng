package testngparallelwithTest;

import io.appium.java_client.AppiumBy;
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
import waittimeAppium.WaitUtility;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ParallelTestingTestsios {
    IOSDriver driver;

    @BeforeTest
    public void start() throws MalformedURLException {
        System.out.println("this is starts");
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformVersion("18.4");
        options.setDeviceName("iPhone 16");
        options.setUdid("5C03BC31-8D66-45E2-B899-4BEBC456A0A7");
        options.setApp("/Users/aravindbalaji/Documents/Appium/SampleApp/ios-app.zip");
//        options.setBundleId("com.saucelabs.mydemoapp.rn");
//        options.setUseNewWDA(false);
//        options.setAutoWebview(true);
//        options.setAppPushTimeout(Duration.ofMillis(50000));

//        options.setBundleId("com.moataz.dailycheck");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

    }

    @AfterTest
    public void end() {
        System.out.println("this is end");
        driver.quit();
    }


    @Test
    public void testcase1() {
        System.out.println("this is  my testcase");
//        WaitUtility.waitforElement(driver,60,By.xpath("//XCUIElementTypeButton[@name=\"plus.circle\"]") );
        Assert.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"plus.circle\"]")).isDisplayed());
    }
}
