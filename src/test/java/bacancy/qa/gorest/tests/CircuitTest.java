package bacancy.qa.gorest.tests;

import bacancy.qa.gorest.base.BaseTest;
import bacancy.qa.gorest.client.RestClient;
import bacancy.qa.gorest.constants.APIHttpStatus;
import bacancy.qa.gorest.utils.JsonPathValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class CircuitTest extends BaseTest {

    @BeforeMethod
    public void createUserSetup() {
        restClient = new RestClient(properties, baseURI);
    }

    @DataProvider
    public Object[][] getUserTestData() {
        return new Object[][]{
                {2017},
                {2018},
                {2019}
        };
    }

    @Test(dataProvider = "getUserTestData")
    public void getCircuitTest(int year) {

        Response circuitresponse = restClient.get(CIRCUIT_ENDPOINT + "/" + year + "/circuits.json", false, true);

        //1st way for validate Status code
        circuitresponse
                .then()
                .assertThat()
                .statusCode(APIHttpStatus.OK_200.getCode());

        //2nd Way for validate status code
        int statusCode = circuitresponse.statusCode();
        Assert.assertEquals(statusCode, APIHttpStatus.OK_200.getCode());

        JsonPathValidator js = new JsonPathValidator();
        List<String> countryList = js.readList(circuitresponse, "$.MRData.CircuitTable.Circuits[?(@.circuitId=='shanghai')].Location.country");
        System.out.println(countryList);
        Assert.assertTrue(countryList.contains("China"));
    }
}