package bacancy.qa.gorest.tests;

import bacancy.qa.gorest.base.BaseTest;
import bacancy.qa.gorest.client.RestClient;
import bacancy.qa.gorest.constants.APIConstants;
import bacancy.qa.gorest.constants.APIHttpStatus;
import bacancy.qa.gorest.pojo.User;
import bacancy.qa.gorest.utils.ExelUtil;
import bacancy.qa.gorest.utils.StringUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class PostUserTest extends BaseTest {

    @BeforeMethod
    public void createUserSetup() {
        restClient = new RestClient(properties, baseURI);
    }

    @DataProvider
    public Object[][] getUserTestData() {
        return new Object[][]{
                {"Hitesh", "male", "active"},
                {"Karina", "female", "inactive"},
                {"Ronak", "male", "active"}
        };
    }

    @DataProvider
    public Object[][] getUserTestSheetData() {
        return ExelUtil.getTestData(APIConstants.GOREST_USER_SHEET_NAME);
    }
//we can use any Data provider either go with 1st one or excel sheet data provider.
// we can prefer 1st option as not needed any 3rd party dependnecy like apache poi.

    @Test(dataProvider = "getUserTestData")
    public void createUserTest(String name, String gender, String status) {
//1. Post Call
        User user = new User(name, StringUtil.getRandomEmail(), gender, status);

        Integer userId = restClient.post(GOREST_ENDPOINT, "json", user, true, true)
                .then().log().all()
                .assertThat().statusCode(APIHttpStatus.CREATED_201.getCode())
                .extract().path("id");

//2.Get Call
        RestClient clientGet = new RestClient(properties, baseURI);
        clientGet.get(GOREST_ENDPOINT + "/" + userId, true, true)
                .then().log().all()
                .assertThat().statusCode(APIHttpStatus.OK_200.getCode())
                .assertThat().body("id", equalTo(userId));
    }
}