package dataproviderdemo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DataproviderDemoTest {

    AndroidDriver driver;
    boolean result = false;
    int resultcolumn = 3;
    int j = 1;

    @BeforeMethod
    public void start() throws MalformedURLException, InterruptedException {
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
    public void teardown() {
        System.out.println("this is the after");
        driver.quit();

    }

    @DataProvider(name = "AuthenticationDatafromexcel")
    public Object[][] credentials() throws Exception {
        Object[][] datafromexcel = ExcelUtilReadWrite.getTableArray(System.getProperty("user.dir")+"/src/test/resources/configproperties/TestData.xlsx", "Credentials");
        System.out.println("data form Excel :" + datafromexcel);
        return datafromexcel;
    }


    @Test(dataProvider = "AuthenticationDatafromexcel")
    public void testcase1(String sUsername, String sPassword, String data) throws Exception {
        System.out.println("username : " + sUsername);
        System.out.println("password : " + sPassword);
        System.out.println("Keyword data : " + data);
        Thread.sleep(5000);
//            int j = 0;

        try {
            j++;
            Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).isDisplayed(), "the data is not available");
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
            Thread.sleep(5000);
//     WebElement item =  driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"TextFields\"]"));
            driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"TextFields\").instance(0))")).click();
            Thread.sleep(5000);
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit1\"]")).clear();
            Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit1\"]")).isDisplayed(), "the data is not available");

            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit1\"]")).sendKeys(sUsername);
            result = true;
            System.setProperty("result", String.valueOf(result));

        } catch (Exception e) {

        } finally {
//            if (result == true) {
//                ExcelUtilReadWrite.setCellData("Pass", j, resultcolumn, "Credentials", "/Users/aravindbalaji/Documents/Appium/ExcelsheetData/TestData.xlsx");
////        j++;
//            } else {
//                ExcelUtilReadWrite.setCellData("Fail", j, resultcolumn, "Credentials", "/Users/aravindbalaji/Documents/Appium/ExcelsheetData/TestData.xlsx");
////        j++;
//            }

        }


    }
}
