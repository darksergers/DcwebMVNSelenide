package ru.dserg.autotest.page.Manuals;

import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 02.11.2016.
 */
public class DataDirectoryGES {
    SelenideTable table = new SelenideTable($(By.className("table")));
    @Step("Переход в волжскую гэс")
    public CardGES volges() throws Exception {
        table.choiceTr(11,0).$(By.tagName("a")).click();
        return new CardGES();
    }
}
