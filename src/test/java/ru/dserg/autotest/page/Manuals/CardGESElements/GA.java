package ru.dserg.autotest.page.Manuals.CardGESElements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 02.11.2016.
 */
public class GA {
    SelenideTable table = new SelenideTable($("#tab-ga-tab").$(By.tagName("table")));
    @Step("Проверяем есть ли в таблице данные")
    public void rowsExist() throws Exception {
        table.choiceTr(0,0).shouldBe(Condition.visible);
    }
}
