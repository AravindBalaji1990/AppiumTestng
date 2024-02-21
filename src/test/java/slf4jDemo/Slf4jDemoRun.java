package slf4jDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class Slf4jDemoRun {
    private static final Logger log = LoggerFactory.getLogger(Slf4jDemoRun.class);
    @Test
    public void testcase1(){
        log.info("this is a informaiton message from slf4j");
    }

    @Test
    public void testcase2(){
        log.error("this is a error message from slf4j");
    }
}
