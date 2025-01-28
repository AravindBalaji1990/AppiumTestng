package basicannotationdemo;

import org.testng.annotations.*;

public class TestAnnotation1 {


    @Test(description = "test description1",priority = 0)
    public void testNameA() {
        System.out.println("testcase1 from Test annotation1A");

    }
    @Test(description = "test description2",priority = 2, enabled = false)
    public void testNameB() {
        System.out.println("testcase2 from Test annotation1B");
    }
    @Test(description = "test description2",priority = 1)
    public void testNameC() {
        System.out.println("testcase2 from Test annotation1C");
    }
    @Test(description = "test description2",priority = 3)
    public void testNameD() {
        System.out.println("testcase2 from Test annotation1D");
    }
}
