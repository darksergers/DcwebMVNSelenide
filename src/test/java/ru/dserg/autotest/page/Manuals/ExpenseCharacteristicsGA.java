package ru.dserg.autotest.page.Manuals;

import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 03.11.2016.
 */
public class ExpenseCharacteristicsGA {

    SelenideTable table = new SelenideTable($(By.className("table")));
    @Step("Выбор станции жигулевская")
    public  void choice(){
        $("#current-item-name").parent().click();
        $("#select-station").$(By.tagName("ul")).$(By.tagName("a"),14).click();
    }
    @Step("Выбор первой характеристики")
    public void clickCharacteristic(){
       $("#list-table-body").$(By.tagName("a")).click();
    }
    @Step("Проверяем таблицу")
    public boolean ok() throws Exception {
        SelenideTable table = new SelenideTable($("#char-table").$(By.tagName("table")));
        if (Integer.valueOf(table.choiceTr(-1,1).getText().substring(0,2))<= 0) return false;
        if (Integer.valueOf(table.choiceTr(0,0).getText().substring(0,2))<=0) return  false;
        return  true;
    }
}
