package parameterisationdemo;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DemoTestParameterisation {
    AndroidDriver driver;

    @BeforeSuite
    @Parameters({"packagename", "activityname", "devicename", "inputdata"})
// how many parameter you have givene in the xml same number should be here
    public void start(String packagename, String activityname, String devicename, String data) throws MalformedURLException, InterruptedException {
        System.out.println("this is the before method");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName(devicename);// mentioned here
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage(packagename);
        options.setAppActivity(activityname);
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        System.out.println("data from suite level" + data);

    }

    @AfterSuite
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("this is the after method");
        driver.quit();

    }

    @BeforeClass
    @Parameters({"inputdata2"})
    public void demo(String data) {
        System.out.println("this from the before class : " + data);

    }


    @Test
    @Parameters({"inputdata"})
    public void testcase1(String valuetiinput) throws InterruptedException {
        System.out.println("this is the first case 1");
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
        Thread.sleep(5000);
//     WebElement item =  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"TextFields\"]"));
        // this can only do a vertical scroll
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"TextFields\").instance(0))")).click();
        Thread.sleep(5000);
        System.out.println("the value form xml : " + valuetiinput);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='io.appium.android.apis:id/edit1']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='io.appium.android.apis:id/edit1']")).sendKeys(valuetiinput);

    }

    @Test
    @Parameters({"inputdata2"})
    public void testcase2(String valuetiinput) throws InterruptedException {
        System.out.println("this is the first case 2");
        System.out.println("the value form xml : " + valuetiinput);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='io.appium.android.apis:id/edit1']")).clear();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='io.appium.android.apis:id/edit1']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='io.appium.android.apis:id/edit1']")).sendKeys(valuetiinput);

    }


}
