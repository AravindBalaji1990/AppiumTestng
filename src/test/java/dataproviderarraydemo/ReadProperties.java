package dataproviderarraydemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    public Properties datafromProperoties() throws IOException {
        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configproperties/data.properties");
        prop.load(fs);
        return prop;
    }
}
