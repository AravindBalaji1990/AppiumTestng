package extentreportdemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestngExtentReport extends ReporterExtent {

    UtilityScreenshot obj = new UtilityScreenshot();
    AndroidDriver driver;

    @BeforeMethod
    public void beforemethod() throws MalformedURLException {
        System.out.println("this is the before");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @Test
    public void testcase1() throws IOException {

        test = extent.createTest("test fail");
        test.log(Status.INFO, "test info - just started the test");
        ExtentTest launchapp = test.createNode("User has launched the app");

        launchapp.log(Status.INFO,"the app is started");
        try {
            launchapp.log(Status.INFO,"trying to validate the element");
            Assert.assertFalse(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).isDisplayed());

        }catch (AssertionError e) {
//            test.log(Status.FAIL, "Test failed" + e.getMessage());
            launchapp.log(Status.FAIL,e.getMessage());

        }
        finally {
            launchapp.log(Status.FAIL,"taking screenshot");

            test.addScreenCaptureFromPath(obj.takeScreenshot(driver, "sample1"));
        }

    }
    @Test(enabled = false)
    public void testcase2(){

        test = extent.createTest("test pass");
        test.log(Status.INFO, "test info from pass");
        Assert.assertFalse(false);
        test.log(Status.PASS,"Test Pass");

    }


}
