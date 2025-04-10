package dataproviderarraydemo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class DataproviderArrayTestDemo_Basic {

    AndroidDriver driver;

    @BeforeMethod
    public void start() throws IOException, InterruptedException {
        System.out.println("this is the before");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("this is the after");
        driver.quit();

    }

    @DataProvider(name = "AuthenticationData")
    public Object[][] credentials() {
        return new Object[][]{{"standard_user", "secret_sauce"}, {"locked_out_user", "secret_sauce"}, {"problem_user", "secret_sauce"}};
    }

    @DataProvider(name = "authentication")
    public Object[][] authData() {
        return new Object[][]{{"standard_user", "secret_sauce"}};
    }


    @Test(dataProvider = "AuthenticationData")
    public void testcase02(String sUsername, String sPassword) throws InterruptedException {
        System.out.println("username from data provider : " + sUsername);
        System.out.println("password from data provider: " + sPassword);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).sendKeys(sUsername);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys(sPassword);
    }
}
