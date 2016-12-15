package ru.dserg.autotest.page.Reports;

import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.dserg.autotest.Utils.Util;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 11.10.2016.
 */
public class OtchetRashodaGESPage {
    @Step("Выбор станции {0}")
    public void listStation(int choice){
        $("#stationNameSelectedForm").click();
        Util.selectSelelector($("#stationNameSelectedForm"),choice). click();


    }
    @Step("Выбор даты {0}")
    public void date(String date){
        Util.choiceDate("#datepicker",date);
    }
    @Step("Нажатие кнопки получить данные")
    public void clickGetData(){
        $("#get-outcome-data").click();

    }
    @Step("Проверка таблицы на отрицательные значения")
    public boolean isPositive() throws Exception {
        SelenideTable table = new SelenideTable($("#outcomeTable").$(By.tagName("table")));
        for (int i=0;i<24;i++) {
            for (int j = 1; j < 25; j++) {
                if(!(Integer.valueOf(table.choiceTr(0, 1).getText()) >= 0)) return true;

            }
        }
        return false;
    }


}
