package testnglistener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class DemoRetryCheck implements IRetryAnalyzer {

    public int countretry = 0;
    public int maximumretry =2;

    public boolean retry(ITestResult result){
        // we are forcefully running it 2 times whether ti has been passed or failed it doesnt matter
        System.out.println("-------->"+result.getStatus());
        //result.getStatus() == 2 this represents the status as failure
//        if(result.getStatus() == 2) {
            if (countretry < maximumretry) {
                System.out.println("I am re-running");
                countretry++;
                return true;
            }
//        }else{
//            System.out.println("the testcase has passed");
//        }
        return false;
    }

}
