package bacancy.qa.gorest.tests;

import bacancy.qa.gorest.base.BaseTest;
import org.testng.annotations.Test;

public class ReqResAPITest extends BaseTest {
    @Test
    public void getReqResest() {

        restClient.get("/api/users/2",false,true)
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
