package ru.dserg.autotest.page.MediumTerm.LongModelElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.dserg.autotest.Utils.Util;
import ru.dserg.autotest.page.MediumTerm.LongScenario;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 11.08.2016.
 *
 *
 * класс ответсвенный за форму создания нового сценария
 *
 */
public class Create {


    /**
     * вводит  названия нового сценария
     */
    @Step("Ввод названия  сценария")
    public void name(String s){
        Util.typeText($("#scenarioName"),s);

    }


    /**
     *  дата начало расчета полезного притока
     */
    @Step("Ввод даты начала расчета полезного притока")
    public void  beginDatePritok(String date){
        Util.choiceDate("#params-begin-date",date);
    }

    /**
     * дата начало имитационого расчета
     */
    @Step("Ввод даты начала имитационого расчета")
    public void beginDateCalculation(String date){
        Util.choiceDate("#params-calc-date",date);

    }
    /**
     * конечная дата расчета
     */
    @Step("Ввод конечной даты расчета")
    public void endDateCalculation(String date){
        Util.choiceDate("#params-end-date",date);
    }
    /**
     * чекбокс использованть нач. уровни из сценария
     */
    public void useSenarioLevels(){
        $("#use-scenario-levels").click();
    }
    /**
     * чекбокс использовать приток
     */
    public void usePritok(){
        $("#use-inflow-for-vb-curve").click();
    }
    /**
     * чекбокс использовать дг
     */
    public void useDG(){
        $("#use-dg-as-regime").click();
    }
    /**
     * чекбокс сценарий доступен только для создателя
     */
    public void privateScenario(){
        $("#private-scenario").click();
    }
    /**
     * кнопка создать
     */
    @Step("Нажатие кнопки создать")
    public LongScenario create() throws Exception {
        $("#edit-scenario-button").click();

        try {
            $("#results-table").waitUntil(Condition.visible,60000);
        }finally {
            Util.findError();

        }

        return new LongScenario();
    }
    @Step("Выбор гранулярности {0}")
    public void granularity(String granularity) throws Exception {//// TODO доделать
        SelenideTable table= new SelenideTable($("#granularity-table").$(By.tagName("table")));

        for (int i=0;i<12;i++) {
            table.choiceTr(i, 1).doubleClick();
            table.choiceTr(i, 1).click();
            JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
            js.executeScript(
                    "var textarea= document.querySelector('#granularity-table > div:nth-child(2) > textarea') ;" +
                            "textarea.value='"+granularity+"';");
            $("#granularity-table > div:nth-child(2) > textarea").click();
            $("#scenarioName").click();
        }



    }

}
