package dataproviderarraydemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    // the below function is reading and storing the data from the properties files as key and value pair
    public Properties datafromProperoties(String filename) throws IOException {
        // declare the object for hte keyword properties
        Properties obj_prop = new Properties();
        // read the data from properties file
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/configproperties/" + filename + ".properties");
        obj_prop.load(fs);// here the data inside the properties file will be stored as key and value pair
        return obj_prop;
    }
}
