package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));
    }

    public static String generateCity(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.address().city();
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateWrongPhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.numerify("####");
    }

    public static String generateWrongName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName();
    }

    public static String generateWrongCity(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.address().city();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}