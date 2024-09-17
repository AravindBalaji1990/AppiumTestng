package testngassertion;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSimpleAssertion {

    @BeforeMethod
    public void beforemethod(){
        System.out.println("this is before method");
    }

    @AfterMethod
    public void aftermethod(){
        System.out.println("this is after method");
    }

    @Test
    public void testcase01(){
        SoftAssert sf = new SoftAssert();
        sf.assertFalse(true,"this should fail");
        sf.assertEquals(1,2,"this should fail");
        sf.assertAll();
    }
}
