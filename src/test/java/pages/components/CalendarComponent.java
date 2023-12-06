package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final static SelenideElement setYear = $(".react-datepicker__year-select"),
            setMonth = $(".react-datepicker__month-select");

    public void setDate(String day, String month, String year) {
        setMonth.selectOption(month);
        setYear.selectOption(year);
        $(".react-datepicker__day--0"+ day +":not(.react-datepicker__day--outside-month)").click();
    }
}
