package bacancy.qa.gorest.tests;

import bacancy.qa.gorest.base.BaseTest;
import bacancy.qa.gorest.client.RestClient;
import bacancy.qa.gorest.constants.APIHttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReqResAPITest extends BaseTest {

    @BeforeMethod
    public void createUserSetup() {
        restClient = new RestClient(properties,baseURI);
    }

    @Test
    public void getReqResest() {

        restClient.get(REQRES_ENDPOINT+"/2", true, true)
                .then().log().all()
                .assertThat().statusCode(APIHttpStatus.OK_200.getCode());
    }
}