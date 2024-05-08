package bacancy.qa.gorest.configration;

import bacancy.qa.gorest.frameworkexception.ApiFrameworkException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigrationManager {
    Properties properties;
    FileInputStream fis;

    public Properties initProp() {
        properties = new Properties();
        String envName = System.getProperty("env");
        System.out.println("Running test cases on Env: " + envName);
        try {
            if (envName == null) {
                System.out.println("no env is passed....Running tests on QA env...");
                fis = new FileInputStream("./src/test/resources/config/qa.properties");
            } else {
                switch (envName.toLowerCase().trim()) {
                    case "dev":
                        fis = new FileInputStream("./src/test/resources/config/dev.properties");
                        System.out.println("dev environment");
                        break;
                    case "qa":
                        fis = new FileInputStream("./src/test/resources/config/qa.properties");
                        System.out.println("dev environment");
                        break;
                    case "prod":
                        fis = new FileInputStream("./src/test/resources/config/prod.properties");
                        System.out.println("prod environment");
                        break;
                    default:
                        System.out.println("....Wrong env is passed....No need to run the test cases....");
                        throw new ApiFrameworkException("WRONG ENV IS PASSED...");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}