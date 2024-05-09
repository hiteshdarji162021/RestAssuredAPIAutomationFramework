package bacancy.qa.gorest.client;

import bacancy.qa.gorest.frameworkexception.ApiFrameworkException;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class RestClient {
    private static RequestSpecBuilder requestSpecBuilder;
    private Properties properties;
    private String baseURI;
    private boolean isAuthorizationHeaderAdded;

    public RestClient(Properties properties, String baseURI) {
        requestSpecBuilder = new RequestSpecBuilder();
        this.properties = properties;
        this.baseURI = baseURI;
    }

    public void addAuthorizationHeader() {
        if (!isAuthorizationHeaderAdded) {
            requestSpecBuilder.addHeader("Authorization", "Bearer " + properties.getProperty("tokenId"));
            isAuthorizationHeaderAdded = true;
        }
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

    private RequestSpecification creatRequestSpec(boolean includeAuth) {
        requestSpecBuilder.setBaseUri(baseURI);
        if (includeAuth) {
            addAuthorizationHeader();
        }
        return requestSpecBuilder.build();
    }

    private RequestSpecification creatRequestSpec(Map<String, String> headermap, boolean includeAuth) {
        requestSpecBuilder.setBaseUri(baseURI);
        if (includeAuth) {
            addAuthorizationHeader();
        }
        if (headermap != null) {
            requestSpecBuilder.addHeaders(headermap);
        }
        return requestSpecBuilder.build();
    }

    private RequestSpecification creatRequestSpec(Map<String, String> headermap, Map<String, Object> queryparamas, boolean includeAuth) {
        requestSpecBuilder.setBaseUri(baseURI);
        if (includeAuth) {
            addAuthorizationHeader();
        }
        if (headermap != null) {
            requestSpecBuilder.addHeaders(headermap);
        }
        if (queryparamas != null) {
            requestSpecBuilder.addQueryParams(queryparamas);
        }
        return requestSpecBuilder.build();
    }

    private RequestSpecification creatRequestSpec(Object requestBody, String contentType, boolean includeAuth) {
        requestSpecBuilder.setBaseUri(baseURI);
        if (includeAuth) {
            addAuthorizationHeader();
        }
        setRequestContentType(contentType);
        if (requestBody != null) {
            requestSpecBuilder.setBody(requestBody);
        }
        return requestSpecBuilder.build();
    }

    private RequestSpecification creatRequestSpec(Object requestBody, String contentType, Map<String, String> headermap, boolean includeAuth) {
        requestSpecBuilder.setBaseUri(baseURI);
        if (includeAuth) {
            addAuthorizationHeader();
        }
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
    public Response get(String serviceUrl, boolean includeAuth, boolean log) {
        if (log) {
            return given(creatRequestSpec(includeAuth)).log().all()
                    .when()
                    .get(serviceUrl);
        }
        return given(creatRequestSpec(includeAuth))
                .when()
                .get(serviceUrl);
    }

    public Response get(String serviceUrl, Map<String, String> headersMap, boolean includeAuth, boolean log) {
        if (log) {
            return given(creatRequestSpec(headersMap, includeAuth)).log().all()
                    .when()
                    .get(serviceUrl);
        }
        return given(creatRequestSpec(headersMap, includeAuth))
                .when()
                .get(serviceUrl);
    }

    public Response get(String serviceUrl, Map<String, String> headersMap, Map<String, Object> queryparams, boolean includeAuth, boolean log) {
        if (log) {
            return given(creatRequestSpec(headersMap, queryparams, includeAuth)).log().all()
                    .when()
                    .get(serviceUrl);
        }
        return given(creatRequestSpec(headersMap, queryparams, includeAuth))
                .when()
                .get(serviceUrl);
    }

    public Response post(String serviceUrl, String contentType, Object requestBody, Map<String, String> headermap, boolean includeAuth, boolean log) {
        if (log) {
            return given(creatRequestSpec(requestBody, contentType, headermap, includeAuth)).log().all()
                    .when()
                    .post(serviceUrl);
        }
        return given(creatRequestSpec(requestBody, contentType, headermap, includeAuth))
                .when()
                .post(serviceUrl);
    }

    public Response post(String serviceUrl, String contentType, Object requestBody, boolean includeAuth, boolean log) {
        if (log) {
            return given(creatRequestSpec(requestBody, contentType, includeAuth)).log().all()
                    .when()
                    .post(serviceUrl);
        }
        return given(creatRequestSpec(requestBody, contentType, includeAuth))
                .when()
                .post(serviceUrl);
    }

    public Response put(String serviceUrl, String contentType, Object requestBody, Map<String, String> headermap, boolean includeAuth, boolean log) {
        if (log) {
            return given(creatRequestSpec(requestBody, contentType, headermap, includeAuth)).log().all()
                    .when()
                    .put(serviceUrl);
        }
        return given(creatRequestSpec(requestBody, contentType, headermap, includeAuth))
                .when()
                .put(serviceUrl);
    }

    public Response put(String serviceUrl, String contentType, Object requestBody, boolean includeAuth, boolean log) {
        if (log) {
            return given(creatRequestSpec(requestBody, contentType, includeAuth)).log().all()
                    .when()
                    .put(serviceUrl);
        }
        return given(creatRequestSpec(requestBody, contentType, includeAuth))
                .when()
                .put(serviceUrl);
    }

    public Response patch(String serviceUrl, String contentType, Object requestBody, Map<String, String> headermap, boolean includeAuth, boolean log) {
        if (log) {
            return given(creatRequestSpec(requestBody, contentType, headermap, includeAuth)).log().all()
                    .when()
                    .patch(serviceUrl);
        }
        return given(creatRequestSpec(requestBody, contentType, headermap, includeAuth))
                .when()
                .patch(serviceUrl);
    }

    public Response patch(String serviceUrl, String contentType, Object requestBody, boolean includeAuth, boolean log) {
        if (log) {
            return given(creatRequestSpec(requestBody, contentType, includeAuth)).log().all()
                    .when()
                    .patch(serviceUrl);
        }
        return given(creatRequestSpec(requestBody, contentType, includeAuth))
                .when()
                .patch(serviceUrl);
    }

    public Response delete(String serviceUrl, boolean includeAuth, boolean log) {
        if (log) {
            return given(creatRequestSpec(includeAuth)).log().all()
                    .when()
                    .delete(serviceUrl);
        }
        return given(creatRequestSpec(includeAuth))
                .when()
                .delete(serviceUrl);
    }

    //Auth 2.0 method
    public String getAccessToken(String serviceURL, String grantType, String clientId, String clientSecret) {
        RestAssured.baseURI = "https://test.api.amadeus.com";
        String accessToken = given().log().all()
                .contentType(ContentType.URLENC)
                .formParam("grant_type", grantType)
                .formParam("client_id", clientId)
                .formParam("client_secret", clientSecret)
                .when()
                .post(serviceURL)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract().path("access_token");
        System.out.println("access token==>" + accessToken);
        return accessToken;
    }
}