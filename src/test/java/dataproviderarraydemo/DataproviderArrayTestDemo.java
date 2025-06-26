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
    ReadProperties obj_readpropoerties = new ReadProperties();

    @BeforeMethod
    public  void start() throws IOException, InterruptedException {
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
    public  void teardown(){
        System.out.println("this is the after");
        driver.quit();

    }

    @DataProvider(name = "authenticationwithpropertiesfilemultipledata")
    public Object[][] propertiesData() throws IOException {
        return new Object[][] { { obj_readpropoerties.datafromProperoties("swaglabconfig").getProperty("username1"), obj_readpropoerties.datafromProperoties("swaglabconfig").getProperty("password")},
                { obj_readpropoerties.datafromProperoties("swaglabconfig").getProperty("username2"), obj_readpropoerties.datafromProperoties("swaglabconfig").getProperty("password")},
                { obj_readpropoerties.datafromProperoties("swaglabconfig").getProperty("username3"), obj_readpropoerties.datafromProperoties("swaglabconfig").getProperty("password")}};
    }

    @DataProvider(name = "authenticationData")
    public Object[][] propertiesDataSingle() throws IOException {
        return new Object[][] { { obj_readpropoerties.datafromProperoties("Config").getProperty("username"), obj_readpropoerties.datafromProperoties("Config").getProperty("password")}};
    }


    @Test(dataProvider = "authenticationwithpropertiesfilemultipledata")
    public void testcase1(String sUsername, String sPassword) throws InterruptedException {
//        String[] data = null;
//        if(sUsername.contains("#")) {
//            data = sUsername.split("#");
//            System.out.println("username : " + data[0] );
//            sUsername = data[0];
//        }else{
//            System.out.println("username : " + sUsername);
//        }
        System.out.println("password : "+sPassword);
        System.out.println("username from data provider : " + sUsername);
        System.out.println("password from data provider: " + sPassword);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).clear();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).sendKeys(sUsername);

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).clear();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys(sPassword);

    }

//    @Test(dataProvider = "authenticationwithpropertiesfilemultipledata")
    public void testcase02(String sUsername, String sPassword) throws InterruptedException {
        System.out.println("username from data provider : " + sUsername);
        System.out.println("password from data provider: " + sPassword);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).sendKeys(sUsername);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys(sPassword);
    }
}
