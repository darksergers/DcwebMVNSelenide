package ru.dserg.autotest.page.MediumTerm.LongScenarioElements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 11.08.2016.
 */
public class Remont {
    private SelenideTable table =
            new SelenideTable($("#RepairsTable").$(By.tagName("table")));

    public  void loadFromREO(){
        $("#loadFromREO").click();

    }
    public void loadFromDB(){
        $("#loadFromDB").click();

    }
    public void removeRepairs(){
        $("#removeRepairs").click();
    }
    @Step("Нажать кнопку сохранить")
    public void save(){
        $("#saveRepairs").click();
    }
    @Step("Вводим в таблицу в строку {0} в столбец {1} число = {2}")
    public void typeInTable(int str,int row,String number) throws Exception {//внести значение в ячейку пргнз подпора
        $("#RepairsTable").waitUntil(Condition.visible,30000);
        table.typeInTable(str, row,"#RepairsTable > div.handsontableInputHolder > textarea",number);
    }


}
