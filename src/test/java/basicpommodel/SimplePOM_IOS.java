package basicpommodel;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SimplePOM_IOS {
    static IOSDriver driver;
    // identification of element
    //identify both andorid and ios
//    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
//    static WebElement txt_username;
//    @AndroidFindBy(id="")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Username input field\"]")
    static WebElement txt_username;

    // identify only andorid
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"Password input field\"]")
    static WebElement txt_password;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Login button\"]")
    static WebElement btn_login;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"tab bar option menu\"]")
    static  WebElement btn_menu;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"menu item log in\"`]")
    static WebElement btn_logindata;
    // identify only ios
//    @iOSXCUITFindBy(xpath = "")
//    static WebElement name;

    @BeforeMethod
    public void startIOS() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("iPhone 16");
        options.setUdid("5C03BC31-8D66-45E2-B899-4BEBC456A0A7");
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
//        options.setApp("/Users/aravindbalaji/IdeaProjects/TestNgWithMaven/src/test/resources/apps/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");
        options.setBundleId("com.saucelabs.mydemoapp.rn");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @AfterMethod
    public void stopIOS() throws InterruptedException {
        Thread.sleep(3000);
//        driver.quit();
    }

    @Test
    public void testcase() throws MalformedURLException, InterruptedException {
        Thread.sleep(3000);
        // this - it represents the class in which it is declared
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        btn_menu.click();
        Thread.sleep(5000);
        btn_logindata.click();

        Thread.sleep(6000);
        if (txt_username.isDisplayed()) {
            txt_username.sendKeys("bob@example.com");
        }
        if (txt_password.isDisplayed()) {
            txt_password.sendKeys("10203040");
        }
        btn_login.click();
    }

}
