package waittimeAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {

    // here we wcheck whether the element is invisible or not
    public static boolean waitforInvisibilityElement(AppiumDriver driver, long seconds, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
       return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public static WebElement waitforElement(AppiumDriver driver, long seconds, WebElement locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    // if we need to do a action after waiting for a element
    public static void waitForElementAndCLick(AndroidDriver driver, long seconds, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    // to count the elements available in the xml dom
    public static int waitForElmentSize(AndroidDriver driver, long seconds, By locator, int num){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.numberOfElementsToBe(locator, num)).size();
    }

    public static void waitForElementFluent(AppiumDriver driver, long seconds, By locator){
        FluentWait wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(5000))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
}
