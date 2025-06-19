package basicannotationdemo;

import org.testng.Assert;
import org.testng.annotations.*;


public class TestAnnotation {
    @BeforeMethod
    public void beforemethod() {
        System.out.println("Before method");

    }

    @AfterMethod
    public void aftermethod() {
        System.out.println("after method");

    }

    @BeforeSuite
    public void beforesuitetest() {
        System.out.println("Before suite");

    }

    @AfterSuite
    public void aftersuitetest() {
        System.out.println("After suite");

    }

    @BeforeTest
    public void beforetest() {
        System.out.println("Before test");

    }

    @AfterTest
    public void aftertest() {
        System.out.println("after test");

    }

    @BeforeClass
    public void beforeclass() {
        System.out.println("Before class");

    }

    @AfterClass
    public void afterclass() {
        System.out.println("after class");

    }


    @Test(description = "test description")
    public void testName1() {
        System.out.println("testcase1");

    }

    @Test(description = "test description")
    public void testName2() {
        System.out.println("testcase2");

    }
}
