package helper;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class DataGenerator {

    private static final Faker faker = new Faker();

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static int generateTotalPrice() {
        return faker.number().numberBetween(100, 1000);
    }

    public static boolean generateDepositPaid() {
        return faker.bool().bool();
    }

    public static String generateCheckIn() {
        return LocalDate.now().toString();
    }

    public static String generateCheckOut() {
        return LocalDate.now().plus(3, ChronoUnit.DAYS).toString();
    }

    public static String generateAdditionalNeeds() {
        String[] additionalNeedsList = {"Wifi", "Parking", "Breakfast", "Shuttle service"};
        Random random = new Random();
        String additionalNeeds = additionalNeedsList[random.nextInt(additionalNeedsList.length)];
        return additionalNeeds;
    }
}
