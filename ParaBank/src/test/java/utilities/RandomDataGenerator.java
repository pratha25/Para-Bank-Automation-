package utilities;

import java.util.Random;

public class RandomDataGenerator {

    public static String getUsername() {

        return "user" +
               System.currentTimeMillis();
    }

    public static String getPassword() {

        return "Test123";
    }

    public static String getPhone() {

        Random random = new Random();

        return "98" +
                (10000000 + random.nextInt(9999999));
    }
}