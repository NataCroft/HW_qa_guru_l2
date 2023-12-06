package tests;

import com.github.javafaker.Faker;

import java.util.*;


    public class TestData extends TestBase {
        private final Faker fakerRU = new Faker(new Locale("ru"));
        private final Faker fakerEN = new Faker(new Locale("en"));


        public String firstName = fakerEN.name().firstName(),
                lastName = fakerEN.name().lastName(),
                email = fakerEN.internet().emailAddress(),
                invalidEmail = fakerRU.internet().emailAddress(),
                phoneNumber = fakerRU.phoneNumber().subscriberNumber(10),
                gender = fakerRU.options().option("Male", "Female", "Other"),
                year = String.valueOf(fakerRU.number().numberBetween(1990, 1995)),
                month = fakerRU.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
                day = String.format("%02d", fakerRU.number().numberBetween(1, 28)),
                subjects = fakerEN.options().option("English", "Maths", "Chemistry"),
                hobbies = fakerEN.options().option("Sports", "Reading", "Music"),
                picture = fakerRU.options().option("111.png"),
                currentAddress = fakerRU.address().fullAddress(),
                state = fakerRU.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
                city = setCity(state);


        public static String setCity(String state) {
            Faker faker = new Faker();
            switch (state) {
                case "NCR":
                    return faker.options().option("Delhi", "Gurgaon", "Noida");
                case "Uttar Pradesh":
                    return faker.options().option("Agra", "Lucknow", "Merrut");
                case "Haryana":
                    return faker.options().option("Karnal", "Panipat");
                case "Rajasthan":
                    return faker.options().option("Jaipur", "Jaiselmer");
                default:
                    throw new IllegalArgumentException("Invalid state: " + state);
            }
        }
    }