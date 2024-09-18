package extentreportdemo;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class UtilityScreenshot {

    public String takeScreenshot(AndroidDriver driver, String screenshotname) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir")+"/src/test/resources/screenshot/"+screenshotname+".png";
        File finaldestination = new File(destination);
        FileUtils.copyFile(source, finaldestination);
        return destination;

    }
}
