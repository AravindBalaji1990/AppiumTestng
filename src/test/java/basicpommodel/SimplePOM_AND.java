package basicpommodel;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SimplePOM_AND {
    static AndroidDriver driver;
    // identification of element
    //identify both andorid and ios
//    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
//    static WebElement txt_username;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    static WebElement txt_username;

    // identify only andorid
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    static WebElement txt_password;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"LOGIN\"]")
    static WebElement btn_login;
    // identify only ios
//    @iOSXCUITFindBy(xpath = "")
//    static WebElement name;

    @Test
    public void testcase() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
        options.setAppWaitForLaunch(true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
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
