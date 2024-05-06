package bacancy.qa.gorest.tests;

import bacancy.qa.gorest.client.RestClient;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class GetUserTest {
    RestClient restClient;
    @Test
    public void getAllUsersTest() {
        restClient = new RestClient();
        restClient.get("/public/v2/users",true)
                .then().log().all()
                .assertThat().statusCode(200);
    }
    @Test
    public void getUserTest() {
        RestClient   restClient1 = new RestClient();
        restClient1.get("/public/v2/users/6891922",true)
                .then().log().all()
                .assertThat().statusCode(200)
                .and().body("id",equalTo(6891922));
    }
    @Test
    public void getUserwithQueryParams() {
        RestClient  restClient2 = new RestClient();
        Map<String,String> queryParamas= new HashMap<String, String>();
        queryParamas.put("name","naveen");
        queryParamas.put("status","active");
        restClient2.get("/public/v2/users",null,queryParamas,false)
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
