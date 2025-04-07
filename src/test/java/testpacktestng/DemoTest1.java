package testpacktestng;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DemoTest1 {
    AndroidDriver driver;
    AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
    String ipaddress = "127.0.0.1";
    int port = 4723;

    @AfterTest
    public void aftertest() {
        System.out.println("this is after test");
        System.out.println("cehcking whether the service is up : " + serviceBuilder.build().isRunning());
        serviceBuilder.build().stop();
    }

    @BeforeTest
    public void beforetest() {
        System.out.println("this is before test");
        serviceBuilder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress(ipaddress).usingPort(port).withTimeout(Duration.ofSeconds(120))
                .build().start();
    }

    @BeforeClass
    public void start() throws MalformedURLException, InterruptedException {
        System.out.println("this is the before class");
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

    @AfterClass
    public void teardown() {
        System.out.println("this is the after class");
        driver.quit();

    }

    // enabled= false -> testcasecan be skipped
    // bu default its true -> noneed to specifically meniton it
    @Test
    public void testcase1() {
        System.out.println("this is the first case 1");
        System.out.println("to chec kthe attribute vbalue :" + driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibiity\"]")).getAttribute("content-desc"));

    }

    @Test(dependsOnMethods = "testcase1")
    public void testcase2() {
        System.out.println("this is the first case 2");
        System.out.println("to check  field is displayed :" + driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]")).isDisplayed());

    }
}
