package bacancy.qa.gorest.configration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigrationManager {
    Properties properties;
    FileInputStream fis;

    public Properties initProp() {
        properties = new Properties();
        try {
            fis = new FileInputStream("./src/test/resources/config/config.properties");
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  properties;
    }
}
