package utils;


import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.util.Random;


public class ValueGenerators {

    private ValueGenerators() {
    }

    static LocalDate today = LocalDate.now();
    static DateTimeFormatter standardDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    static DateTimeFormatter standardTimeFormat = DateTimeFormatter.ofPattern("HH:mm");

    //TODO: Possibly move to cmfc util class
    public static String calculateDOB(int age) {
        return LocalDate.now().plusYears(age).format(standardDateFormat);
    }

    public static String currentDate() {
        return today.format(standardDateFormat);
    }

    public static String todayPlusDays(int days) {
        return today.plusDays(days).format(standardDateFormat);
    }

    public static String todayMinusDays(int days) {
        return today.minusDays(days).format(standardDateFormat);
    }

    public static String generateDateTimeStamp() {
        return LocalDate.now().toString() + LocalTime.now().toString();
    }

    public static String generateDateTimeStampUTC() {
        return LocalDate.now().toString() + LocalTime.now(ZoneOffset.UTC).toString();
    }

    public static String currentTime() {
        return LocalTime.now().format(standardTimeFormat);
    }

    public static int numberGenerator(int maxValue) {
        Random r = new Random();
        return r.nextInt(maxValue);
    }
}
