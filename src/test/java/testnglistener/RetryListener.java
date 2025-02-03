package testnglistener;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer {

    public void transform(ITestAnnotation annotation, Class testclass, Constructor testConstructor, Method testMethod){
        annotation.setRetryAnalyzer(DemoRetryCheck.class);
    }
}
