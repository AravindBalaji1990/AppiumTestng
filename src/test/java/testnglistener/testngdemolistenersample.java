package testnglistener;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(TestNgListenerDemo.class)
public class testngdemolistenersample {

    @BeforeSuite
    public void start(){
        System.out.println("this is my before method");
    }

    @AfterSuite
    public void teardown(){
        System.out.println("this is my after method");
    }



//    @Test(retryAnalyzer = DemoRetryCheck.class)
    @Test
    public void testcase01(){
        System.out.println("this is my first testcase");
//        Assert.assertFalse(false);
        Assert.assertFalse(true);
    }
    @Test
    public void testcase02(){
        System.out.println("this is my first testcase");
        Assert.assertFalse(false);
//        Assert.assertFalse(true);
    }

}
