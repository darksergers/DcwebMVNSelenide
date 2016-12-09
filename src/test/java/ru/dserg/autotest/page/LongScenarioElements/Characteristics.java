package ru.dserg.autotest.page.LongScenarioElements;

import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.dserg.autotest.page.LongModel;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 09.08.2016.
 */
public class Characteristics {

    public void back(LongModel model){//вернуться на основную страницу
        $("#back-to-cascade").click();
        model.setTab();
    }
    private enum Tab{

        KrivieVB,KrivieNB,VbWinter,NbWinter,PoteriNapora,HidroVB,Filtration,IceLosses,SteamLosses,
        PropuskVodosbrosa,RashodCharacteristics,RashodSelfNeed,Dispgraph,SeasonCorrecting
    }
    private Tab tab= Tab.KrivieVB;
    public SelenideTable getTable(int choice){
        switch (tab){
            case KrivieVB: if (choice==0)return new SelenideTable($("#vb-curve-table").$(By.tagName("table")));
                else return new SelenideTable($("#surface-curve-table").$(By.tagName("table")));
            }


        return null;

    }

    public SelenideTable getTable(){//Todo захерачить выборс спецального ексепшена "не та вкладка", хотя nullpointerexception тоже ок(не совсем)
        switch (tab){
            case KrivieNB: return new SelenideTable($("#nb-curve-table").$(By.tagName("table")));
            case VbWinter: return new SelenideTable($("#vb-winter-table") .$(By.tagName("table")));
            case NbWinter: return new SelenideTable($("#nb-winter-table") .$(By.tagName("table")));
            case PoteriNapora: return new SelenideTable($("#h-losses-table").$(By.tagName("table")));
            case HidroVB: return new SelenideTable($("#vb-curve-table").$(By.tagName("table")));
            case Filtration: return new SelenideTable($("#filtration-table").$(By.tagName("table")));
            case IceLosses: return new SelenideTable($("#ice-losses-table").$(By.tagName("table")));
            case SteamLosses: return new SelenideTable($("#steam-losses-table").$(By.tagName("table")));
            case PropuskVodosbrosa: return new SelenideTable($("#spillways-table").$(By.tagName("table")));
            case RashodSelfNeed: return new SelenideTable($("#ownExpensesLosses").$(By.tagName("table")));
            case Dispgraph: return new SelenideTable($("#dg-table").$(By.tagName("table")));
            case SeasonCorrecting: return new SelenideTable($("#season-correcting-coef").$(By.tagName("table")));
        }

        return null;
    }

    /**
     * кнопка сохранить
     */
    public void save(){
       $("#save-characteristics-button").click();
    }

    /**
     * кнопка импорт
     */

    public void importCharacteristics(){
        $("#import-chars-dialog-button").click();
    }

    /**
     * переключает на вкладку Киривые вб и вносит значение в тамблицу
     * @param choiceTable
     * @param str
     * @param rows
     * @param number
     */

    public void vbCurves(int choiceTable,int str,int rows,String number) throws Exception {
        vbCurves(choiceTable).typeInTable(str,rows,(choiceTable==0)?"#vb-curve-table":"#surface-curve-table"+
                " > div.handsontableInputHolder > textarea",number);
    }

    /**
     * переключает на вкладку Киривые вб и возвращает таблицу
     * @param choiceTable
     * @return
     */
    public SelenideTable vbCurves(int choiceTable){
        $("#vbCurves").click();
        tab = Tab.KrivieVB;
        return getTable(choiceTable);
    }
    public SelenideTable vbCurves(){
        return vbCurves(0);
    }


    public void nbCurves(int str,int rows,String number) throws Exception {
        nbCurves().typeInTable(str,rows,"#nb-curve-table > div.handsontableInputHolder > textarea",number);
    }
    public SelenideTable nbCurves() {
        $("#hydroNbCurve").click();
        tab = Tab.KrivieNB;
        return getTable();
    }
    public void nbWinter(int str,int rows,String number) throws Exception {
        nbWinter().typeInTable(str,rows,"#nb-winter-table > div.handsontableInputHolder > textarea",number);

    }
    public SelenideTable nbWinter(){
        $("#nbWinter").click();
        tab = Tab.NbWinter;
        return getTable();
    }
    public void poteriNapora(int str,int rows,String number) throws Exception {
        poteriNapora().typeInTable(str,rows,"#h-losses-table > div.handsontableInputHolder > textarea",number);
    }
    public SelenideTable poteriNapora(){
        $("#dhCurves").click();
        tab = Tab.PoteriNapora;
        return getTable();
    }

    public void hidroVB(int str,int rows,String number) throws Exception {
        hidroVB().typeInTable(str,rows,"#vb-curve-table > div.handsontableInputHolder > textarea",number);
    }
    public SelenideTable hidroVB(){
        $("#hydroVbCurve").click();
        tab = Tab.HidroVB;
        return getTable();
    }
    public void spillwayCapacity(int str,int rows,String number) throws Exception {
        spillwayCapacity().typeInTable(str,rows,"#spillways-table > div.handsontableInputHolder > textarea",number);
    }
    public SelenideTable spillwayCapacity(){
        $("#spillwayCapacity").click();
        tab = Tab.PropuskVodosbrosa;
        return getTable();
    }
    public void expenseChars(int str,int rows,String number) throws Exception {
        expenseChars().typeInTable(str,rows,"#outflow-chars-table > div.handsontableInputHolder > textarea", number);
    }
    public SelenideTable expenseChars(){
        $("#outflowChars").click();
        tab = Tab.RashodCharacteristics;
        return getTable();
    }
    public void ownExpensesLosses(int str,int rows,String number) throws Exception {
        ownExpensesLosses().typeInTable(str,rows,"#ownExpensesLosses > div.handsontableInputHolder > textarea",number);
    }
    public SelenideTable ownExpensesLosses(){
        $("#ownExpensesLosses").click();
        tab = Tab.RashodSelfNeed;
        return getTable();
    }



}
