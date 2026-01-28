package dataproviderarraydemo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class DataproviderArrayTestDemo_Basic {

    AndroidDriver driver;
    public static AppiumDriverLocalService service;

    @BeforeSuite(alwaysRun = true)
    public void startAppium() {
        System.out.println("----starting appium---");
        // the below code will check for the path of the default appium,sdk,ios
        service = AppiumDriverLocalService.buildDefaultService();
        // then start the appium server - as we start in terminal
        service.start();
    }
    @AfterSuite(alwaysRun = true)
    public void stopAppium() {
        service.stop();

    }

    @BeforeMethod
    public void startMethod() throws IOException, InterruptedException {
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
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("this is the after");
        driver.quit();

    }

    // each @Dataprovider is represented by unique names
    // these unique name should be used in a @test to be referred
    // we can have n number of data providers
    @DataProvider(name = "AuthenticationData")
    public Object[][] credentials() {
        return new Object[][]{{"standard_user", "secret_sauce"}, {"locked_out_user", "secret_sauce"}, {"problem_user", "secret_sauce"}};
    }

    @DataProvider(name = "authentication_valid_user")
    public Object[][] authData() {
        return new Object[][]{{"standard_user", "secret_sauce"}};
    }

    @DataProvider(name = "lockeduser")
    public Object[][] lockeddata() {
        return new Object[][]{{"locked_out_user", "secret_sauce"}};
    }

    //Inside the @test we can refere the dataprovider as below -dataprovider = "name"
    @Test(dataProvider = "AuthenticationData")
    public void testcase02(String sUsername, String sPassword) throws InterruptedException {

        System.out.println("username from data provider : " + sUsername);
        System.out.println("password from data provider: " + sPassword);

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).sendKeys(sUsername);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys(sPassword);
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")).click();
        if(sUsername.equalsIgnoreCase("locked_out_user")){
            Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Sorry, this user has been locked out.\"]")).isDisplayed());
        }
    }
}
