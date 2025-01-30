package dataproviderarraydemo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DataproviderArrayTestDemo {

    AndroidDriver driver;
    ReadProperties obj = new ReadProperties();

    @BeforeMethod
    public  void start() throws IOException, InterruptedException {
        System.out.println("this is the before");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName((String) obj.datafromProperoties().get("devicename"));
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

    }

    @AfterMethod
    public  void teardown(){
        System.out.println("this is the after");
        driver.quit();

    }

    @DataProvider(name = "AuthenticationData")
    public Object[][] credentials() {
        return new Object[][] { { "testuser_1", "Test@123" ,""},{ "testuser_2", "Test@123","test" },{ "testuser_3", "Test@123","" } };
    }

    @DataProvider(name = "authentication")
    public Object[][] authData() {
        return new Object[][] { { "testuser_1", "Test@123" }};
    }

    @DataProvider(name = "authenticationwithpropertiesfile")
    public Object[][] propertiesData() throws IOException {
        return new Object[][] { { obj.datafromProperoties().getProperty("username"), obj.datafromProperoties().getProperty("password")}};
    }


    @Test(dataProvider = "authenticationwithpropertiesfile")
    public void testcase1(String sUsername, String sPassword) throws InterruptedException {
        String[] data = null;
        if(sUsername.contains("#")) {
            data = sUsername.split("#");
            System.out.println("username : " + data[0] );
        }else{
            System.out.println("username : " + sUsername);
        }
        System.out.println("password : "+sPassword);
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
        Thread.sleep(5000);
//     WebElement item =  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"TextFields\"]"));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"TextFields\").instance(0))")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit1\"]")).clear();
        if(data[0] !=null && !(data[0].isEmpty()) ) {
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit1\"]")).sendKeys(data[0]);
        }else{
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit1\"]")).sendKeys(data);
        }

    }

//    @Test(dataProvider = "AuthenticationData")
//    public void testcase02(String sUsername, String sPassword, String data) throws InterruptedException {
//        System.out.println("username : "+sUsername);
//        System.out.println("password : "+sPassword);
//        System.out.println("extra data : "+data);
//        Thread.sleep(5000);
//        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
//        Thread.sleep(5000);
////     WebElement item =  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"TextFields\"]"));
//        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"TextFields\").instance(0))")).click();
//        Thread.sleep(5000);
//        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit1\"]")).clear();
//        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit1\"]")).sendKeys(sUsername);
//    }
}
