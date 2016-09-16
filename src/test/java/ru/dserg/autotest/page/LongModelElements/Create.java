package ru.dserg.autotest.page.LongModelElements;

import ru.dserg.autotest.Utils.Util;
import ru.dserg.autotest.page.LongScenario;

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
    public void name(String s){
        Util.typeText($("#scenarioName"),s);

    }


    /**
     *  дата начало расчета полезного притока
     */
    public void  beginDatePritok(String date){
        Util.choiseDate("#params-begin-date",date);
    }

    /**
     * дата начало имитационого расчета
     */
    public void beginDateCalculation(String date){
        Util.choiseDate("#params-calc-date",date);

    }
    /**
     * конечная дата расчета
     */
    public void endDateCalculation(String date){
        Util.choiseDate("#params-end-date",date);
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
    public LongScenario create(){
        $("#edit-scenario-button").click();
        return new LongScenario();
    }

}
