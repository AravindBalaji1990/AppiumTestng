package testnglistener;

import org.testng.*;

public class TestNgListenerDemo implements ITestListener, ISuiteListener, IInvokedMethodListener {
    // *************ISuiteInvocation Logic Begins*****************
    public void onStart(ISuite arg0) {
//        Reporter.log("message", true);
        Reporter.log("About to begin executing Onstart of Suite (onStart suite)" + arg0.getName(), true);
    }

    // This belongs to ISuiteListener and will execute, once the Suite is
    // finished
    public void onFinish(ISuite arg0) {
        Reporter.log("About to end executing Onfinish of Suite (onFinish suite)" + arg0.getName(), true);
    }
    // *************ISuiteInvocation Logic Ends*****************

    // *************ItestListener Logic begins*****************
    // This belongs to ITestListener and will execute before starting of Test
    // set/batch
    public void onStart(ITestContext arg0) {
        Reporter.log("About to begin executing onstart of Test (onStart Itest)" + arg0.getName(), true);
    }

    // This belongs to ITestListener and will execute, once the Test set/batch
    // is finished

    public void onFinish(ITestContext arg0) {
        Reporter.log("Completed executing onfinish of test (onFinish Itest)" + arg0.getName(), true);
    }

    // This belongs to ITestListener and will execute before the main test start
    // (@Test)
    public void onTestStart(ITestResult arg0) {
        Reporter.log("The execution of the main test starts now (onteststart Itest) : " + arg0.getName(), true);
    }

    // This belongs to ITestListener and will execute only when the test is pass

    public void onTestSuccess(ITestResult arg0) {
        // This is calling the printTestResults method
        printTestResults(arg0);
    }

    // This belongs to ITestListener and will execute only on the event of fail
    // test
    public void onTestFailure(ITestResult arg0) {
        // This is calling the printTestResults method
        printTestResults(arg0);
    }
    // This belongs to ITestListener and will execute only if any of the main
    // test(@Test) get skipped
    public void onTestSkipped(ITestResult arg0) {
        printTestResults(arg0);
    }

    // This is just a piece of shit, ignore this
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }

    // This is the method which will be executed in case of test pass or fail

    // This will provide the information on the test

    private void printTestResults(ITestResult result) {

        Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);

        /*
         * if (result.getParameters().length != 0) { String params = null; for
         * (Object parameter : result.getParameters()) { params +=
         * parameter.toString() + ","; } Reporter.log(
         * "Test Method had the following parameters : " + params, true); }
         */

        String status = null;

        switch (result.getStatus()) {

            case ITestResult.SUCCESS:
                status = "Passed successfully 100%";
                break;

            case ITestResult.FAILURE:
                status = "Failed 100%";
                break;

            case ITestResult.SKIP:
                status = "Skipped the case";
                break;

        }
        Reporter.log("Test Status: " + status, true);
    }

    // *************ITestListener Logic ENds*****************

    // *************IMethodInvocation Logic begins*****************

    // This belongs to IInvokedMethodListener and will execute before every
    // method including @Before @After @Test

    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

        String textMsg = "About to begin executing following beforeinvocation method (beforeInvocation) : "
                + returnMethodName(arg0.getTestMethod());

        Reporter.log(textMsg, true);

    }

    // This belongs to IInvokedMethodListener and will execute after every
    // method including @Before @After @Test

    public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {

        String textMsg = "Completed executing following afterinvocation method (afterInvocation): "
                + returnMethodName(arg0.getTestMethod());

        Reporter.log(textMsg, true);

    }

    // This will return method names to the calling function

    private String returnMethodName(ITestNGMethod method) {

        return "The class called :" + method.getRealClass().getSimpleName() + "-->" + "The method used :"
                + method.getMethodName();

    }
    // *************IMethodInvocation Logic Ends*****************
}
