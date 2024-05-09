package bacancy.qa.gorest.tests;

import bacancy.qa.gorest.base.BaseTest;
import bacancy.qa.gorest.client.RestClient;
import bacancy.qa.gorest.constants.APIConstants;
import bacancy.qa.gorest.constants.APIHttpStatus;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class AmadeusAPITest extends BaseTest {

    private String accessToken;

    @Parameters({"baseURI", "grantType", "clientId", "clientSecret"})
    @BeforeMethod
    public void createUserSetup(String baseURI, String grantType, String clientId, String clientSecret) {
        restClient = new RestClient(properties, baseURI);
        accessToken = restClient.getAccessToken(AMUDESUS_TOKEN_ENDPOINT, grantType, clientId, clientSecret);
    }

    @Test
    public void getFightInfoTest() {
        RestClient restClientFlight = new RestClient(properties, baseURI);
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Authorization", "Bearer " + accessToken);

        Map<String, Object> queryParams = new HashMap<String, Object>();
        queryParams.put("origin", "PAR");
        queryParams.put("maxPrice", APIHttpStatus.OK_200.getCode());

        Response flightDataResponse = restClientFlight.get(AMUDESUS_FLIGHTBOOKING_ENDPOINT, headerMap, queryParams, false, false)
                .then().log().all()
                .assertThat()
                .statusCode(APIHttpStatus.OK_200.getCode())
                .and()
                .extract()
                .response();
        JsonPath js = flightDataResponse.jsonPath();
        String type = js.get("data[0].type");
        System.out.println("type is-->"+type);
        Assert.assertEquals(type, APIConstants.AMADEUS_FLIGHT_TYPE);
    }
}