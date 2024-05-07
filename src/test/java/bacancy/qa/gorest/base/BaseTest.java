package bacancy.qa.gorest.base;

import bacancy.qa.gorest.client.RestClient;
import bacancy.qa.gorest.configration.ConfigrationManager;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {
protected ConfigrationManager configrationManager;
protected  Properties properties;
protected RestClient restClient;
    @Parameters({"baseURI"})
    @BeforeTest
    public void setUp(String baseURI) {
        RestAssured.filters(new AllureRestAssured());
        configrationManager = new ConfigrationManager();
        properties = configrationManager.initProp();
        restClient = new RestClient(properties,baseURI);
    }
}
