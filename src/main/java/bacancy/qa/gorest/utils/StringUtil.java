package bacancy.qa.gorest.utils;

import java.util.Random;

public class StringUtil {
    public static String getRandomEmail() {
        return  "automation" + System.currentTimeMillis() + "@api.com";
    }
}
