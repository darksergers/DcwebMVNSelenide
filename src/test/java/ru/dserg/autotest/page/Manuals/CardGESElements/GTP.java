package ru.dserg.autotest.page.Manuals.CardGESElements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 02.11.2016.
 */
public class GTP {
    SelenideTable table = new SelenideTable($("#tab-gtp-tab").$(By.tagName("table")));
    public void rowsExist(){
        table.choiceTr(0,0).shouldBe(Condition.visible);
    }
}
