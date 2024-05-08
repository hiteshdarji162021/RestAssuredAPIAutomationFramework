package bacancy.qa.gorest.utils;

public class StringUtil {
    public static String getRandomEmail() {
        return  "automation" + System.currentTimeMillis() + "@api.com";
    }
}