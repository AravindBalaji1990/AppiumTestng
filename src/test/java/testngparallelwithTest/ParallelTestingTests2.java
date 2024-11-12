package testngparallelwithTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ParallelTestingTests2 {
static AndroidDriver driver;

    @BeforeTest
    public void start() throws MalformedURLException {
        System.out.println("this is starts");
        System.out.println("this is the before");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
//        options.setDeviceName("emulator-5554");
        options.setDeviceName("29221JEGR00379");
        options.setAutoGrantPermissions(true);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
//        options.setAppPackage("co.motovolt.motovoltapp");
//        options.setAppActivity("co.motovolt.motovoltapp.MainActivity");
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

    @Test
    public void testcase2(){
        System.out.println("this is  my testcase");
//        WaitUtility.waitforElement(driver,60,AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView") );
//        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView"));
//        Assert.assertTrue(ele.isDisplayed());
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Text\"]")).isDisplayed());
    }

    @Test
    public void testcase3(){
        System.out.println("this is  my testcase");
//        WaitUtility.waitforElement(driver,60,AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView") );
//        WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView"));
//        Assert.assertTrue(ele.isDisplayed());
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"App\"]")).isDisplayed());
    }
}
