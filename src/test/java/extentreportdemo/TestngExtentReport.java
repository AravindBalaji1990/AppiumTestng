package extentreportdemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestngExtentReport extends ReporterExtent {



    @Test
    public void testcase1(){

        test = extent.createTest("test fail");
        test.log(Status.INFO, "test info");
        try {
            Assert.assertFalse(true);
        }catch (AssertionError e) {
            test.log(Status.FAIL, "Test failed" + e.getMessage());
        }

    }
    @Test
    public void testcase2(){

        test = extent.createTest("test pass");
        test.log(Status.INFO, "test info from pass");
        Assert.assertFalse(false);
        test.log(Status.PASS,"Test Pass");

    }


}
