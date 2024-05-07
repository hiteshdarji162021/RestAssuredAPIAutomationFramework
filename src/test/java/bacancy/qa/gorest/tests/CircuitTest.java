package bacancy.qa.gorest.tests;

import bacancy.qa.gorest.base.BaseTest;
import org.testng.annotations.Test;

public class CircuitTest extends BaseTest {
    @Test
    public void getCircuitTest() {

        restClient.get("/api/f1/2017/circuits.json",false,true)
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
