package basicannotationdemo;

import org.testng.annotations.*;

public class DemoRun1 {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("this is beforeSuite");

    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("this is afterSuite");

    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("this is beforeTest");

    }
    @AfterTest
    public void afterTest(){
        System.out.println("this is afterTest");

    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("this is beforeClass");

    }
    @AfterClass
    public void afterClass(){
        System.out.println("this is afterClass");

    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("this is beforeMethod");

    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("this is afterMethod");

    }

    // @Test will excute for thetestcaseswe have - it canbe multiple
    @Test
    public void testcase01(){
        System.out.println("this is testcase01");
    }

    @Test
    public void testcase02(){
        System.out.println("this is testcase02");
    }
}
