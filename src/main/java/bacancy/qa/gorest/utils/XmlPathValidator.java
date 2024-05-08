package bacancy.qa.gorest.utils;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class XmlPathValidator {
    private XmlPath getXmlPath(Response response) {
        String responseBody = response.body().asString();
        return new XmlPath(responseBody);
    }

    //we can also write Object return type instead of <T> T both are fine
    public <T> T read(Response response, String XmlPathExpression) {
        XmlPath xmlPath = getXmlPath(response);
        return xmlPath.get(XmlPathExpression);
    }

    public <T> List<T> readList(Response response, String XmlPathExpression) {
        XmlPath xmlPath = getXmlPath(response);
        return xmlPath.get(XmlPathExpression);
    }

    public <T> List<Map<String, T>> readListOfMap(Response response, String XmlPathExpression) {
        XmlPath xmlPath = getXmlPath(response);
        return xmlPath.get(XmlPathExpression);
    }
}