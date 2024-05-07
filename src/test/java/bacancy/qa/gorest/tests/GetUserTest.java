package bacancy.qa.gorest.tests;

import bacancy.qa.gorest.base.BaseTest;
import bacancy.qa.gorest.client.RestClient;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class GetUserTest extends BaseTest {

    @Test
    public void getAllUsersTest() {

        restClient.get("/public/v2/users",true,true)
                .then().log().all()
                .assertThat().statusCode(200);
    }
   /* @Test(enabled = true)
    public void getUserTest() {

        restClient.get("/public/v2/users/6891922",true)
                .then().log().all()
                .assertThat().statusCode(200)
                .and().body("id",equalTo(6891922));
    }*/
  /*  @Test
    public void getUserwithQueryParams() {
        Map<String,String> queryParamas= new HashMap<String, String>();
        queryParamas.put("name","naveen");
        queryParamas.put("status","active");
        restClient.get("/public/v2/users",null,queryParamas,false)
                .then().log().all()
                .assertThat().statusCode(200);
    }*/
}
