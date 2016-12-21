package ru.dserg.autotest.page.Reports;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.dserg.autotest.Utils.Util;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 14.11.2016.
 */
public class ReportEquipmentOperatingRegime {
    @Step("Вод даты начала {0}")
    public void datebegin(String date){

        $("#filter-form").$(By.tagName("input")).sendKeys(Keys.chord(Keys.SHIFT,Keys.HOME,Keys.DELETE)+date);
    }
    @Step("Выбор новосибирской гэс")
    public void selectStation(){
        $("#filter-form").$(By.tagName("select")).selectOption("Новосибирская ГЭС");
    }
    @Step("Выбор всех ГА")
    public void ga(){
        $("#filter-form").$(By.tagName("button")).click();
        $("#filter-form").$(By.tagName("ul")).$(By.tagName("label")).click();
    }
    @Step("Нажатие кнопки Применить")
    public void show() throws Exception {
       $("#show").click();
        Util.findError();
    }
    @Step("Проверка таблицы")
    public boolean ok() throws Exception {
        SelenideTable table = new SelenideTable($("#report-table"));
        $("#report-table").$(By.tagName("tbody")).waitUntil(Condition.visible,30000);

        label:for (int i = 3;i<=$("#report-table").$(By.tagName("tbody")).$$(By.tagName("tr")).size()-2;i++){
            if(Float.parseFloat(table.choiceTr(i,1).getText().replace(',','.'))>0){
            for(int j = 3; j<6;j++){
                if(Float.parseFloat(table.choiceTr(i,j).getText().replace(',','.'))>0) continue  label;

            }
                return  false;
            }else continue ;

        }

        return  true;
    }
    @Step("Выбо источник ОИК")
    public void selectSource(){
        $("#filter-form").$(By.tagName("select"),1).selectOption("ОИК");
    }


}
