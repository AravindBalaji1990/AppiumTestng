package testngassertion;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class HardAssertionDemo {

    AndroidDriver driver;
    @BeforeMethod
    public  void start() throws MalformedURLException, InterruptedException {
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

    @AfterMethod
    public  void teardown(){
        System.out.println("this is the after");
        driver.quit();
    }

    @Test
    public void testcase1() throws Exception {
        boolean status = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).isDisplayed();
        Assert.assertTrue(status, "the data is available");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
    }

    @Test(enabled = true)
    public void testcase2(){
        SoftAssert sf = new SoftAssert();
//        Assert.assertFalse(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).isDisplayed(), "the data is available");

        sf.assertFalse(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).isDisplayed(), "the data is available");
        sf.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Text\"]")).isDisplayed(), "the data is not available");

        // we need to provide this as amandatory to validate the result set
        sf.assertAll();

    }

    @Test(enabled = true)
    public void testcase3(){
        String datatext = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).getText();

        Assert.assertEquals(datatext,"Views","there is a mismatch between actula and expected");
    }
}