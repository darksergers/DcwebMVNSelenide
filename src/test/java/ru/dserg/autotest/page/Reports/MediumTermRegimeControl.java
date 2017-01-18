package ru.dserg.autotest.page.Reports;

import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 23.12.2016.
 */
public class MediumTermRegimeControl {

    @Step("Выбор Волжско-Камский каскад")
    public void  selectStation(){

        $("#filter-form").$(By.tagName("select")).selectOption("Волжско-Камский каскад");
}
    @Step("Нажатие применить")
    public void clickShowTable(){
        $("#show-table").click();
    }
    @Step("Проверка таблицы на наличие значений")
    public boolean checkTable() throws Exception {
        boolean b = false;
        SelenideTable table = new SelenideTable($("#maket-table").$(By.tagName("tbody")));
        label:for (int i=0;i<=$("#maket-table").$(By.tagName("tbody")).$$(By.tagName("tr")).size();i++) {
            for (int j = 1; j <=$("#maket-table").$(By.tagName("tbody")).$(By.tagName("tr")).$$(By.tagName("td")).size(); j++) {
                if(Float.parseFloat(table.choiceTr(i,j).getText().replace(',','.'))>0){
                    b = true;
                    break label;

                }

            }
        }
        if(b)return true;
        else return false;
    }
}
