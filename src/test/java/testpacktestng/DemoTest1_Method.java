package testpacktestng;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DemoTest1_Method {
    AndroidDriver driver;

    @BeforeMethod
    public  void start() throws MalformedURLException, InterruptedException {
        System.out.println("this is the before method");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));
         driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

    }

    @AfterMethod
    public  void teardown(){
        System.out.println("this is the after method");
        driver.quit();

    }


    @Test(priority = 2)
    public void testcase1(){
    System.out.println("this is the first case 1");
    System.out.println("to chec kthe attribute vbalue :" +driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]")).getAttribute("content-desc"));

    }

    @Test(priority = 1,enabled = false)
    public void testcase2(){
        System.out.println("this is the first case 2");
        System.out.println("to check  field is displayed :" +driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]")).isDisplayed());

    }
}
