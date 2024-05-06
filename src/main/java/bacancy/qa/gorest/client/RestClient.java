package bacancy.qa.gorest.client;

import bacancy.qa.gorest.frameworkexception.ApiFrameworkException;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestClient {
    private static RequestSpecBuilder requestSpecBuilder;
    private static final String BASE_URI = "https://gorest.co.in";
    private static final String BEARER_TOKEN = "27a41ce83bb7bd9f61b4a202a6c961ce02d56580d538742a2760dfbe3ea9ab5e";

    public RestClient() {
        requestSpecBuilder = new RequestSpecBuilder();
    }



    public void addAuthorizationHeader() {
       requestSpecBuilder.addHeader("Authorization","Bearer " +BEARER_TOKEN);
    }

    private void setRequestContentType(String contentType) {
        switch (contentType.toLowerCase()) {
            case "json":
                requestSpecBuilder.setContentType(ContentType.JSON);
                break;
            case "xml":
                requestSpecBuilder.setContentType(ContentType.XML);
                break;
            case "text":
                requestSpecBuilder.setContentType(ContentType.TEXT);
                break;
            case "multipart":
                requestSpecBuilder.setContentType(ContentType.MULTIPART);
                break;
            default:
                System.out.println("please pass right content type");
                throw new ApiFrameworkException("INVALID CONTENT TYPE");
        }
    }

    private RequestSpecification creatRequestSpec() {
        requestSpecBuilder.setBaseUri(BASE_URI);
        addAuthorizationHeader();
        return requestSpecBuilder.build();
    }

    private RequestSpecification creatRequestSpec(Map<String, String> headermap) {
        requestSpecBuilder.setBaseUri(BASE_URI);
        addAuthorizationHeader();
        if (headermap != null) {
            requestSpecBuilder.addHeaders(headermap);
        }
        return requestSpecBuilder.build();
    }

    private RequestSpecification creatRequestSpec(Map<String, String> headermap, Map<String, String> queryparamas) {
        requestSpecBuilder.setBaseUri(BASE_URI);
        addAuthorizationHeader();
        if (headermap != null) {
            requestSpecBuilder.addHeaders(headermap);
        }
        if (queryparamas != null) {
            requestSpecBuilder.addQueryParams(queryparamas);
        }
        return requestSpecBuilder.build();
    }

    private RequestSpecification creatRequestSpec(Object requestBody, String contentType) {
        requestSpecBuilder.setBaseUri(BASE_URI);
        addAuthorizationHeader();
        setRequestContentType(contentType);
        if (requestBody != null) {
            requestSpecBuilder.setBody(requestBody);
        }
        return requestSpecBuilder.build();
    }

    private RequestSpecification creatRequestSpec(Object requestBody, String contentType, Map<String, String> headermap) {
        requestSpecBuilder.setBaseUri(BASE_URI);
        addAuthorizationHeader();
        setRequestContentType(contentType);
        if (headermap != null) {
            requestSpecBuilder.addHeaders(headermap);
        }
        if (requestBody != null) {
            requestSpecBuilder.setBody(requestBody);
        }
        return requestSpecBuilder.build();
    }

    //Http Method Utils:
    public Response get(String serviceUrl, boolean log) {
        if (log) {
            return RestAssured.given(creatRequestSpec()).log().all()
                    .when()
                    .get(serviceUrl);
        }
        return RestAssured.given(creatRequestSpec())
                .when()
                .get(serviceUrl);
    }

    public Response get(String serviceUrl, Map<String, String> headersMap, boolean log) {
        if (log) {
            return RestAssured.given(creatRequestSpec(headersMap)).log().all()
                    .when()
                    .get(serviceUrl);
        }
        return RestAssured.given(creatRequestSpec(headersMap))
                .when()
                .get(serviceUrl);
    }

    public Response get(String serviceUrl, Map<String, String> headersMap, Map<String, String> queryparams, boolean log) {
        if (log) {
            return RestAssured.given(creatRequestSpec(headersMap, queryparams)).log().all()
                    .when()
                    .get(serviceUrl);
        }
        return RestAssured.given(creatRequestSpec(headersMap, queryparams))
                .when()
                .get(serviceUrl);
    }

    public Response post(String serviceUrl, String contentType, Object requestBody, Map<String, String> headermap, boolean log) {
        if (log) {
            return RestAssured.given(creatRequestSpec(requestBody, contentType, headermap)).log().all()
                    .when()
                    .post(serviceUrl);
        }
        return RestAssured.given(creatRequestSpec(requestBody, contentType, headermap))
                .when()
                .post(serviceUrl);
    }

    public Response post(String serviceUrl, String contentType, Object requestBody, boolean log) {
        if (log) {
            return RestAssured.given(creatRequestSpec(requestBody, contentType)).log().all()
                    .when()
                    .post(serviceUrl);
        }
        return RestAssured.given(creatRequestSpec(requestBody, contentType))
                .when()
                .post(serviceUrl);
    }

    public Response put(String serviceUrl, String contentType, Object requestBody, Map<String, String> headermap, boolean log) {
        if (log) {
            return RestAssured.given(creatRequestSpec(requestBody, contentType, headermap)).log().all()
                    .when()
                    .put(serviceUrl);
        }
        return RestAssured.given(creatRequestSpec(requestBody, contentType, headermap))
                .when()
                .put(serviceUrl);
    }

    public Response put(String serviceUrl, String contentType, Object requestBody, boolean log) {
        if (log) {
            return RestAssured.given(creatRequestSpec(requestBody, contentType)).log().all()
                    .when()
                    .put(serviceUrl);
        }
        return RestAssured.given(creatRequestSpec(requestBody, contentType))
                .when()
                .put(serviceUrl);
    }

    public Response patch(String serviceUrl, String contentType, Object requestBody, Map<String, String> headermap, boolean log) {
        if (log) {
            return RestAssured.given(creatRequestSpec(requestBody, contentType, headermap)).log().all()
                    .when()
                    .patch(serviceUrl);
        }
        return RestAssured.given(creatRequestSpec(requestBody, contentType, headermap))
                .when()
                .patch(serviceUrl);
    }

    public Response patch(String serviceUrl, String contentType, Object requestBody, boolean log) {
        if (log) {
            return RestAssured.given(creatRequestSpec(requestBody, contentType)).log().all()
                    .when()
                    .patch(serviceUrl);
        }
        return RestAssured.given(creatRequestSpec(requestBody, contentType))
                .when()
                .patch(serviceUrl);
    }

    public Response delete(String serviceUrl, boolean log) {
        if (log) {
            return RestAssured.given(creatRequestSpec()).log().all()
                    .when()
                    .delete(serviceUrl);
        }
        return RestAssured.given(creatRequestSpec())
                .when()
                .delete(serviceUrl);
    }
}
