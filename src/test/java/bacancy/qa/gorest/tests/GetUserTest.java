package bacancy.qa.gorest.tests;

import bacancy.qa.gorest.base.BaseTest;
import bacancy.qa.gorest.client.RestClient;
import bacancy.qa.gorest.constants.APIHttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class GetUserTest extends BaseTest {

    @BeforeMethod
    public void getUserSetup() {
        restClient = new RestClient(properties,baseURI);
    }

    @Test
    public void getAllUsersTest() {

        restClient.get(GOREST_ENDPOINT,true,true)
                .then().log().all()
                .assertThat().statusCode(APIHttpStatus.OK_200.getCode());
    }

    @Test
    public void getUserTest() {

        restClient.get(GOREST_ENDPOINT+"/6891922",true,true)
                .then().log().all()
                .assertThat().statusCode(APIHttpStatus.OK_200.getCode())
                .and().body("id",equalTo(6891922));
    }

    @Test
    public void getUserwithQueryParams() {
        Map<String, Object> queryParamas= new HashMap<String, Object>();
        queryParamas.put("name","naveen");
        queryParamas.put("status","active");
        restClient.get(GOREST_ENDPOINT,null,queryParamas,true,false)
                .then().log().all()
                .assertThat().statusCode(APIHttpStatus.OK_200.getCode());
    }
}