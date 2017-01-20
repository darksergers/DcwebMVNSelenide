package ru.dserg.autotest.page.Reports;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.dserg.autotest.Utils.Util;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 23.12.2016.
 */
public class ShortTermRegimeControl {
    @Step("Нажатие на кнопку применить")
    public void show(){
        $("#show-table").click();
        try {
            $("#maket-table").$(By.tagName("table")).waitUntil(Condition.visible,60000);

        }finally {
            Util.findError();
        }

    }
    @Step("Проверка таблицы на наличие значений")
    public boolean ok() throws Exception {
        SelenideTable table = new SelenideTable($("#maket-table").$(By.tagName("table")));
        for (int i=0;i<$("#maket-table").$(By.tagName("tbody")).$$(By.tagName("tr")).size();i++) {
            for (int j = 1; j <$("#maket-table").$(By.tagName("tbody")).$(By.tagName("tr")).$$(By.tagName("td")).size(); j++) {
                if(Float.parseFloat(table.choiceTr(i,j).getText().replace(',','.'))>0){
                    return true;

                }

            }
        }
        return  false;
    }
}
