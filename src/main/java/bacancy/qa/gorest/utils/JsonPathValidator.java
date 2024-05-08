package bacancy.qa.gorest.utils;

import bacancy.qa.gorest.frameworkexception.ApiFrameworkException;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class JsonPathValidator {

    private String getJsonResponseAsString(Response response) {
        return response.getBody().asString();
    }

    //we can also write Object return type instead of <T> T both are fine
    public <T> T read(Response response, String jsonPath) {
        String jsonResponse = getJsonResponseAsString(response);
        try {
            return JsonPath.read(jsonResponse, jsonPath);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiFrameworkException(jsonPath + "is not found");

        }
    }

    public <T> List<T> readList(Response response, String jsonPath) {
        String jsonResponse = getJsonResponseAsString(response);
        try {
            return JsonPath.read(jsonResponse, jsonPath);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiFrameworkException(jsonPath + "is not found");

        }
    }

    public <T> List<Map<String, T>> readListOfMap(Response response, String jsonPath) {
        String jsonResponse = getJsonResponseAsString(response);
        try {
            return JsonPath.read(jsonResponse, jsonPath);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiFrameworkException(jsonPath + "is not found");

        }
    }
}