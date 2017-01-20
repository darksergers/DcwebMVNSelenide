package ru.dserg.autotest.page.Manuals;

import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 18.01.2017.
 */
public class VolumeCurves {

    @Step("Выбираем станцию Воткинская ГЭС")
    public void selectStation(){
        $("#station-form").$(By.tagName("select")).selectOption("Воткинская ГЭС");

    }
    @Step("Проверяем таблицу")
    public boolean ok(){

        SelenideTable table= new SelenideTable($("#table").$(By.tagName("table")));

        for(int i=0;i<table.getElement().$(By.tagName("tbody")).$$(By.tagName("tr")).size();i++ ){
            for (int j=0;j<2;j++){
                String d=table.getElement().$(By.tagName("tbody")).$(By.tagName("tr"),i).$(By.tagName("td"),j).getText().replace(',','.');
                if (Float.parseFloat(d)>0) return true;
            }
        }
        return false;
    }

}
