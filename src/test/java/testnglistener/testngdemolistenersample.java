package testnglistener;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

//@Listeners(TestNgListenerDemo.class)
public class testngdemolistenersample {

    public static AndroidDriver driver;

    @BeforeSuite
    public void start() throws MalformedURLException {
        System.out.println("this is my before method");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
        options.setAutoGrantPermissions(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @AfterSuite
    public void teardown() {
        System.out.println("this is my after method");
        driver.quit();
    }


    //    @Test(retryAnalyzer = DemoRetryCheck.class)
    @Test(enabled = true)
    public void testcase01() {
        WebElement element_view = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
        if (checkElementPresense(driver, element_view, 60)) {
            Assert.assertTrue(element_view.isDisplayed());
            element_view.click();
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"TextFields\").instance(0))")).click();
        }
    }

    @Test(priority = 1)
    public void testcase02() {
        WebElement element_view = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Text\"]"));
        if (checkElementPresense(driver, element_view, 60)) {
            Assert.assertNotNull(element_view);
            element_view.click();

            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Unicode\").instance(0))")).click();
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
