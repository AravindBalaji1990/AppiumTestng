package basicpommodel;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SimplePOM_IOS {
    static IOSDriver driver;
    // identification of element
    //identify both andorid and ios
//    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
//    static WebElement txt_username;
    @iOSXCUITFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    static WebElement txt_username;

    // identify only andorid
    @iOSXCUITFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    static WebElement txt_password;

    @iOSXCUITFindBy(xpath = "//android.widget.TextView[@text=\"LOGIN\"]")
    static WebElement btn_login;
    // identify only ios
//    @iOSXCUITFindBy(xpath = "")
//    static WebElement name;

    @Test
    public void testcase() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("IOS");
        options.setUdid("3E37AF3C-67ED-4E85-AE25-059E835101B7");
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
        options.setAppPackage("");
        options.setAppActivity("");
        options.setAppWaitForLaunch(true);
        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(3000);

        // this - it represents the class in which it is declared
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        if (txt_username.isDisplayed()) {
            txt_username.sendKeys("standard_user");
        }

        if (txt_password.isDisplayed()) {
            txt_password.sendKeys("secret_sauce");
        }
        btn_login.click();

        Thread.sleep(3000);
        driver.quit();

    }

}
