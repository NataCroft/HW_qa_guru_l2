package pages.components;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    private static SelenideElement table = $(".table-responsive");

    public static void checkResult (String key, String value) {
        table.$(byText(key)).parent().lastChild().shouldHave(text(value));
    }
}
