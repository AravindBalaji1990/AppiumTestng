package basicpommodel;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import waittimeAppium.WaitUtility;

import java.net.MalformedURLException;
import java.net.URL;

public class TestDemoPom {
    IOSDriver driver;

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"plus.circle\"]")
    static WebElement lbl_circle;

//    @AndroidFindBy(xpath = "")
//    WebElement txt_field;

    @Test
    public void testcase() throws MalformedURLException {
        System.out.println("this is starts");
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 16 Plus");
        options.setUdid("A332C391-A85E-4B1E-8F55-63695EB04AED");
        options.setUseNewWDA(false);
        options.setBundleId("com.moataz.dailycheck");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        // this helps in initialisaiton of all the element sin the page
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        Assert.assertNotNull(WaitUtility.waitforElement(driver,120, lbl_circle));
        Assert.assertTrue(lbl_circle.isDisplayed());
    }
}
