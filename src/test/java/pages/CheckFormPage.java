package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class CheckFormPage {
    public CalendarComponent calendarComponent = new CalendarComponent();
    public ResultTableComponent resultTableComponent = new ResultTableComponent();
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $( "#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            checkboxHobbies = $("#hobbiesWrapper"),
            inputUploadPicture = $("#uploadPicture"),
            textAreaCurrentAddress = $("#currentAddress"),
            selectState = $("#react-select-3-input"),
            selectCity = $("#react-select-4-input"),
            buttonsendForm = $("#submit"),
            closeModal = $("#closeLargeModal");



    public CheckFormPage openPage(){
        open("/automation-practice-form");
        return this;
    }
    public CheckFormPage removeBanner(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public CheckFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public CheckFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public CheckFormPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public CheckFormPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public CheckFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public CheckFormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public CheckFormPage selectSubjects(String value) {
        subjectsInput.setValue(value);
        subjectsInput.pressEnter();

        return this;
    }
    public CheckFormPage selectHobbies(String hobby) {
        checkboxHobbies.$(byText(hobby)).click();

        return this;
    }
    public CheckFormPage choosePicture(String imgName) {
        inputUploadPicture.uploadFromClasspath(imgName);

        return this;
    }
    public CheckFormPage setCurrentAddress(String address) {
        textAreaCurrentAddress.sendKeys(address);

        return this;
    }
    public CheckFormPage setStateAndCity(String state, String city) {
        selectState.setValue(state).pressEnter();
        selectCity.setValue(city).pressEnter();

        return this;
    }
    public CheckFormPage sendForm() {
        buttonsendForm.scrollIntoView(true);
        buttonsendForm.scrollTo().click();

        return this;
    }
    public CheckFormPage checkResult (String key, String value) {
        resultTableComponent.checkResult(key, value);

        return this;
    }
    public CheckFormPage closeModalWidow() {
        closeModal.scrollTo().click();

        return this;
    }
    public CheckFormPage checkEmail (String key, String value) {
        userEmailInput.shouldHave(cssValue(key, value));

        return this;
    }

}

