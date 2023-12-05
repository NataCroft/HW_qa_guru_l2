package tests;

import org.junit.jupiter.api.Test;
import pages.CheckFormPage;

import static com.codeborne.selenide.Selenide.$;

public class CheckFormWithPageObjectsTest extends TestBase {
    CheckFormPage checkFormPage = new CheckFormPage();
        @Test
        void succsessfulCheckFormTest() {
            checkFormPage.openPage()
                    .removeBanner()
                    .setFirstName("Natalie")
                    .setLastName("Chechetkina")
                    .setEmail("nata@gmail.com")
                    .setGender("Female")
                    .setUserNumber("8999123456")
                    .setDateOfBirth("07", "December", "1990")
                    .selectSubjects("Maths")
                    .selectHobbies("Sports")
                    .choosePicture("111.png")
                    .setCurrentAddress("Lenina st. 1")
                    .setStateAndCity("Haryana", "Karnal")
                    .sendForm()
            .checkResult("Student Name", "Natalie Chechetkina")
                    .checkResult("Student Email", "nata@gmail.com")
                    .checkResult("Gender", "Female")
                    .checkResult("Mobile", "8999123456")
                    .checkResult("Date of Birth", "7 December,1990")
                    .checkResult("Subjects", "Maths")
                    .checkResult("Hobbies", "Sports")
                    .checkResult("Address", "Lenina st. 1")
                    .checkResult("State and City", "Haryana Karnal");
            checkFormPage.closeModalWidow();
        }

        @Test
        void minimumDataFillFormTest() {
            checkFormPage.openPage()
                    .removeBanner()
                    .setFirstName("Natalie")
                    .setLastName("Chechetkina")
                    .setGender("Female")
                    .setUserNumber("8999123456")
                    .sendForm()
                    .checkResult("Student Name", "Natalie Chechetkina")
                    .checkResult("Gender", "Female")
                    .checkResult("Mobile", "8999123456");
            checkFormPage.closeModalWidow();
        }

        @Test
        void invalidEmailTest() {
            checkFormPage.openPage()
                    .removeBanner()
                    .setFirstName("Natalie")
                    .setLastName("Chechetkina")
                    .setEmail("nata.com")
                    .setGender("Female")
                    .setUserNumber("8999123456")
                    .sendForm()
                    .checkEmail("border-color", "rgb(220, 53, 69)");
        }
}








