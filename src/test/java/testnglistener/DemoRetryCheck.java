package testnglistener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class DemoRetryCheck implements IRetryAnalyzer {

    public int countretry = 0;
    public int maximumretry =2;

    public boolean retry(ITestResult result){
        System.out.println("-------->"+result.getStatus());
        if(countretry <maximumretry){
            System.out.println("I am re-running");
            countretry++;
            return  true;
        }
        return  false;
    }

}
