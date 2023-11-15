import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class CheckFormTest {
    @BeforeAll
    static void beforeAll() {
    Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
//    Configuration.holdBrowserOpen = true;
System.setProperty("webdriver.chrome.driver","data/drivers/chromedriver");
    }

    @AfterAll
    static void afterAll() {
        WebDriver driver = WebDriverRunner.getWebDriver();

        driver.close();
        driver.quit();
    }

    public void removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }


    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        $("#firstName").setValue("Natalie");
//        sleep(20000)
        $("#lastName").setValue("Chechetkina");
        $("#userEmail").setValue("nata@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8999123456");
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--007:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").val("Maths").pressEnter();
        $("#subjectsInput").val("English").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/pic/111.png"));
        $("#currentAddress").setValue("Lenina st. 1");
        $("#react-select-3-input").val("Haryana").pressEnter();
        $("#react-select-4-input").val("Karnal").pressEnter();
        removeBanners();
        $("#submit").click();

        $(".table-responsive").shouldHave(
                text("Natalie Chechetkina"),
                text("nata@gmail.com"),
                text("Female"),
                text("8999123456"),
                text("7 December,1990"),
                text("Maths, English"),
                text("Sports, Reading"),
                text("111.png"),
                text("Lenina st. 1"),
                text("Haryana Karnal"));
    }
}
