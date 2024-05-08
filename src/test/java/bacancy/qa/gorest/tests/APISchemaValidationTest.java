package bacancy.qa.gorest.tests;

import bacancy.qa.gorest.base.BaseTest;
import bacancy.qa.gorest.client.RestClient;
import bacancy.qa.gorest.constants.APIHttpStatus;
import bacancy.qa.gorest.pojo.User;
import bacancy.qa.gorest.utils.StringUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class APISchemaValidationTest extends BaseTest {

    @BeforeMethod
    public void createUserSetup() {
        restClient = new RestClient(properties, baseURI);
    }

    @Test
    public void createUserAPISchemaTest() {
//1. Post Call
        User user = new User("Hitesh", StringUtil.getRandomEmail(), "male", "active");

        restClient.post(GOREST_ENDPOINT, "json", user, true, true)
                .then().log().all()
                .assertThat().statusCode(APIHttpStatus.CREATED_201.getCode())
                .body(matchesJsonSchemaInClasspath("createuserschema.json"));
    }
}