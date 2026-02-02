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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SimplePOM_IOS {
    static IOSDriver driver;
    // identification of element
    //identify both andorid and ios
//    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
//    static WebElement txt_username;
//    @AndroidFindBy(id="")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    static WebElement txt_username;

    // identify only andorid
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    static WebElement txt_password;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Login\"]")
    static WebElement btn_login;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"tab bar option menu\"]")
    static WebElement btn_menu;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"menu item log in\"`]")
    static WebElement btn_logindata;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Product Name\" and @label=\"Sauce Labs Backpack - Black\"]/preceding-sibling::XCUIElementTypeImage")
    static WebElement btn_blackbag;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"AddToCart\"]")
    static WebElement btn_addtocart;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cart-tab-item\"]")
    static WebElement btn_cartitem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ProceedToCheckout\"]")
    static WebElement btn_checkout;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"bob@example.com\"]")
    static WebElement btn_username;
    // identify only ios
//    @iOSXCUITFindBy(xpath = "")
//    static WebElement name;

    @BeforeMethod
    public void startIOS() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setUdid("4B733329-44E4-4712-9AD2-8EC4E24CF059");
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
        options.setApp("/Users/aravindbalaji/Documents/Appium/SampleApp/My_Demo_App_IOS_Simulator.zip");
//        options.setBundleId("com.saucelabs.mydemoapp.rn");
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


        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(btn_blackbag)).click();

        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(btn_addtocart)).click();

        btn_cartitem.click();

        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(btn_checkout)).click();


        Thread.sleep(5000);
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(btn_username)).click();

//        if (txt_username.isDisplayed()) {
//            txt_username.sendKeys("bob@example.com");
//        }
//        if (txt_password.isDisplayed()) {
//            txt_password.sendKeys("10203040");
//        }

        Thread.sleep(4000);
        btn_login.click();
    }

}
