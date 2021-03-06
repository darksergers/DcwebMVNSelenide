package ru.dserg.autotest.page.ShortTerm;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.Util;
import ru.yandex.qatools.allure.annotations.Step;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Kalinin.S on 05.08.2016.
 */
public class ShortModel {
    private boolean diologIsOpen;
    @Step("Открытие формы создания краткосрочного сценария")
    public void create() {
        $(By.xpath("//*[@id=\'main-content\']/div/div[1]/div/div[1]/div[1]/button[1]")).click();
        diologIsOpen=!diologIsOpen;
    }
    @Step("Ввод имени краткосрочного сценария")
    public void  typeNameScenario(String text){
        if (diologIsOpen==true){
            $("#scenarioName").setValue(text );
        }
    }
    @Step("Нажатие кнопки создать на форме создания краткосрочного сценария")
    public ShortScenario createScenario() throws Exception {
        $("#createScenario").click();
        Util.findError();
        return new ShortScenario();
    }
    @Step("Ввод датыкраткосрочного сценария")
    public void  time(String date){
        Util.choiceDate("#beginDate",date);
    }
    public  void delete(){
        $("#scenario-list-header").parent().waitUntil(Condition.visible,30000);
        for (SelenideElement element:$$(By.partialLinkText("Autotest") ) ) {
            element.parent().parent().$(By.tagName("input")).click();
        }
        if($$(By.partialLinkText("Autotest")).size()>0){
        $(By.className("delete-button")).click();
        $("#deleteButton").waitUntil(Condition.visible,30000);
        $("#deleteButton").click();

    }
    }
    //*[@id="inflow-table"]/div[1]/div[1]/div/div[1]/table/tbody/tr[1]/td[1]
    //*[@id="inflow-table"]/div[1]/div[1]/div/div[1]/table/tbody/tr[1]/td[2]
}
