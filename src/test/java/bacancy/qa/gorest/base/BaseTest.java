package bacancy.qa.gorest.base;

import bacancy.qa.gorest.client.RestClient;
import bacancy.qa.gorest.configration.ConfigrationManager;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {
    //Service URLs
    public static final String GOREST_ENDPOINT = "/public/v2/users";
    public static final String REQRES_ENDPOINT = "/api/users";
    public static final String CIRCUIT_ENDPOINT = "/api/f1";
    public static final String AMUDESUS_TOKEN_ENDPOINT = "/v1/security/oauth2/token";
    public static final String AMUDESUS_FLIGHTBOOKING_ENDPOINT = "/v1/shopping/flight-destinations";

    protected ConfigrationManager configrationManager;
    protected Properties properties;
    protected RestClient restClient;
    protected String baseURI;

    @Parameters({"baseURI"})
    @BeforeTest
    public void setUp(String baseURI) {
        RestAssured.filters(new AllureRestAssured());
        configrationManager = new ConfigrationManager();
        properties = configrationManager.initProp();
        this.baseURI = baseURI;
    }
}