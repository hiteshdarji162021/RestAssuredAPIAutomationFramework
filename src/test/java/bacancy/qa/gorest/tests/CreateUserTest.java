package bacancy.qa.gorest.tests;

import bacancy.qa.gorest.client.RestClient;
import bacancy.qa.gorest.pojo.User;
import bacancy.qa.gorest.utils.StringUtil;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
public class CreateUserTest {


    /*public void createUserTest() {
//1. Post Call
        User user = new User("Hitesh", StringUtil.getRandomEmail(), "male", "active");
        RestClient restClientPost = new RestClient();
       Integer userId= restClientPost.post("/public/v2/users", "json", user, true)
                .then().log().all()
                .assertThat().statusCode(201)
                .extract().path("id");

        //2.Get Call
        RestClient restClientGet = new RestClient();
        restClientGet.get("/public/v2/users/"+userId,true)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("id",equalTo(userId));

    }*/
}
