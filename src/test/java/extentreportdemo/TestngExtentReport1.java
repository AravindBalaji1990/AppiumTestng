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

public class TestngExtentReport1 extends  ReporterExtent {



    @Test
    public void testcase1(){

        test = extent.createTest("test Pass");
        test.log(Status.INFO, "test info");

            Assert.assertTrue(true);


    }



}
