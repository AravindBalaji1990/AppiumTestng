package dataproviderarraydemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    // the below function is reading and storing the data from the properties files as key and value pair
    public Properties datafromProperoties() throws IOException {
        Properties xyz = new Properties();
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/configproperties/Config.properties");
        xyz.load(fs);
        return xyz;
    }
}
