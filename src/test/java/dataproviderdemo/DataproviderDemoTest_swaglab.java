package dataproviderdemo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DataproviderDemoTest_swaglab {

    AndroidDriver driver;
    boolean result = false;// global variable declared where the result afetr running hte data will be updated
    int resultcolumn = 2;// cell in the column where the result should be updated
    int j = 0; // this will iterate through the rows and update the result

    @BeforeMethod
    public void start() throws MalformedURLException, InterruptedException {
        System.out.println("this is the before");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppWaitForLaunch(true);
        options.setAppWaitDuration(Duration.ofMillis(50000));
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

    }

    @AfterMethod
    public void teardown() {
        System.out.println("this is the after");
        driver.quit();

    }

    @DataProvider(name = "AuthenticationDatafromexcel")
    public Object[][] credentials() throws Exception {
        Object[][] datafromexcel = ExcelUtilReadWrite.getTableArray(System.getProperty("user.dir")+"/src/test/resources/configproperties/TestData_Swaglab_Data.xlsx", "Credentials");
        System.out.println("data form Excel :" + datafromexcel);
        return datafromexcel;
    }


    @Test(dataProvider = "AuthenticationDatafromexcel")
    public void testcase1(String sUsername, String sPassword) throws Exception {
        System.out.println("username : " + sUsername);
        System.out.println("password : " + sPassword);
        Thread.sleep(5000);
//            int j = 0;

        try {
            j++;
           driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]")).sendKeys(sUsername);
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys(sPassword);

            Thread.sleep(10000);
            driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")).click();
            Thread.sleep(10000);
            try {
                if (driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]")).isDisplayed()) {
                    // once the login is successfull the global varibale is marked true
                    result = true;
                    // we set the data over to the variable temporarily and which can be reused
                    System.setProperty("result", String.valueOf(result));
                }
            }catch (Exception e){
                result = false;
                // we set the data over to the variable temporarily and which can be reused
                System.setProperty("result", String.valueOf(result));
            }
        } catch (Exception e) {

        } finally {
            if (result == true && System.getProperty("result").equalsIgnoreCase("true")) {
                ExcelUtilReadWrite.setCellData("Pass", j, resultcolumn, "Credentials", System.getProperty("user.dir")+"/src/test/resources/configproperties/TestData_Swaglab_Data.xlsx");
//        j++;
            } else {
                ExcelUtilReadWrite.setCellData("Fail", j, resultcolumn, "Credentials", System.getProperty("user.dir")+"/src/test/resources/configproperties/TestData_Swaglab_Data.xlsx");
//        j++;
            }

        }


    }
}
