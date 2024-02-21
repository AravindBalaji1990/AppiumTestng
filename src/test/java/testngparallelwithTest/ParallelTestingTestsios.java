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

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ParallelTestingTestsios {
 IOSDriver driver;

    @BeforeTest
    public void start() throws MalformedURLException {
        System.out.println("this is starts");
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15");
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/ios-app.zip");
//        options.setAutoWebview(true);
//        options.setAppPushTimeout(Duration.ofMillis(50000));

        options.setBundleId("com.moataz.dailycheck");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

    }

    @AfterTest
    public void end(){
        System.out.println("this is end");
    }


    @Test
    public void testcase1(){
        System.out.println("this is  my testcase");
    Assert.assertTrue(        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"plus.circle\"]")).isDisplayed());
    }
}
