package tests;

import org.junit.jupiter.api.Test;
import pages.CheckFormPage;


public class CheckFormWithPageObjectsTest extends TestBase {
    CheckFormPage checkFormPage = new CheckFormPage();
    TestData testData = new TestData();

        @Test
        void succsessfulCheckFormTest() {
            checkFormPage.openPage()
                    .removeBanner()
                    .setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setEmail(testData.email)
                    .setGender(testData.gender)
                    .setUserNumber(testData.phoneNumber)
                    .setDateOfBirth(testData.day, testData.month, testData.year)
                    .selectSubjects(testData.subjects)
                    .selectHobbies(testData.hobbies)
                    .choosePicture(testData.picture)
                    .setCurrentAddress(testData.currentAddress)
                    .setStateAndCity(testData.state, testData.city)
                    .sendForm()
            .checkResult("Student Name", testData.firstName)
                    .checkResult("Student Name", testData.lastName)
                    .checkResult("Student Email", testData.email)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.phoneNumber)
                    .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                    .checkResult("Subjects", testData.subjects)
                    .checkResult("Hobbies", testData.hobbies)
                    .checkResult("Address", testData.currentAddress)
                    .checkResult("State and City", testData.state + " " +testData.city);
            checkFormPage.closeModalWidow();
        }

        @Test
        void minimumDataFillFormTest() {
            checkFormPage.openPage()
                    .removeBanner()
                    .setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setGender(testData.gender)
                    .setUserNumber(testData.phoneNumber)
                    .sendForm()
                    .checkResult("Student Name", testData.firstName)
                    .checkResult("Student Name", testData.lastName)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.phoneNumber);
            checkFormPage.closeModalWidow();
        }

        @Test
        void invalidEmailTest() {
            checkFormPage.openPage()
                    .removeBanner()
                    .setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setGender(testData.gender)
                    .setEmail(testData.invalidEmail)
                    .setUserNumber(testData.phoneNumber)
                    .sendForm()
                    .checkEmail("border-color", "rgb(220, 53, 69)");
        }
}








