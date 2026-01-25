package basicannotationdemo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestIOS {
    public static IOSDriver driver;

    @BeforeSuite
    public void before() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("IOS");
        options.setUdid("4B733329-44E4-4712-9AD2-8EC4E24CF059");
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
        options.setBundleId("com.apple.reminders");
        options.setForceAppLaunch(true);

        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
    }


    @AfterSuite
    public void after() {
        driver.quit();

    }

    @Test(priority = 1)
    public void testcase01() {

        WebElement element_view = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"New Reminder\"]"));
        if (checkElementPresense(driver, element_view, 60)) {
            element_view.click();

            new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Quick Entry Title Field\"]")));
            driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"Quick Entry Title Field\"]")).sendKeys("Demo example");

            new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Done\"]"))).click();
        }
    }

    @Test(priority = 0, enabled = false)
    public void testcase02() {

        WebElement element_view = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Today, 0 reminders, 25 January\"]"));
        if (checkElementPresense(driver, element_view, 60)) {
            Assert.assertTrue(element_view.isEnabled(),"the button is not available in the screen");
        }
    }


    public static boolean checkElementPresense(AppiumDriver driver, WebElement element, long seconds) {
        boolean data = false;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement dataelement = wait.until(ExpectedConditions.visibilityOf(element));
        if (dataelement != null) {
            return true;
        } else {
            return false;
        }
    }
}
