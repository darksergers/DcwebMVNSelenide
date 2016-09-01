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

        KrivieVB,KrivieNB,PoteriNapora,HidroVB,PropuskVodosbrosa,RashodCharacteristics,RashodSelfNeed
    }
    private Tab tab= Tab.KrivieVB;
    public SelenideTable getTable(int choice){
        switch (tab){
            case KrivieVB:{
               if (choice==0)
                   return new SelenideTable($(By.xpath("//*[@id='vb-curve-table']/div[1]/div[1]/div/div[1]/table")));
                else
                   return new
                           SelenideTable($(By.xpath("//*[@id='surface-curve-table']/div[1]/div[1]/div/div[1]/table")));
            }
            case RashodCharacteristics:
                switch (choice){
                    case 0:{
                        return new
                                SelenideTable(
                                $(By.xpath("//*[@id='ga-expense-1-table']/div[1]/div[1]/div/div[1]/table")));
                    }
                    case 1:{
                        return new
                                SelenideTable(
                                $(By.xpath("//*[@id='ga-expense-2-table']/div[1]/div[1]/div/div[1]/table")));
                    }
                    case 2:{
                        return new
                                SelenideTable(
                                $(By.xpath("//*[@id='ga-expense-3-table']/div[1]/div[1]/div/div[1]/table")));
                    }
                    case 3:{
                        return new
                                SelenideTable(
                                $(By.xpath("//*[@id='ga-expense-4-table']/div[1]/div[1]/div/div[1]/table")));
                    }
                    case 4:{
                        return new
                                SelenideTable(
                                $(By.xpath("//*[@id='ga-expense-5-table']/div[1]/div[1]/div/div[1]/table")));
                    }
                    case 5:{
                        return new
                                SelenideTable(
                                $(By.xpath("//*[@id='ga-expense-6-table']/div[1]/div[1]/div/div[1]/table")));
                    }
                    case 6:{
                        return new
                                SelenideTable(
                                $(By.xpath("//*[@id='ga-expense-7-table']/div[1]/div[1]/div/div[1]/table")));
                    }
                    case 7:{
                        return new
                                SelenideTable(
                                $(By.xpath("//*[@id='ga-expense-8-table']/div[1]/div[1]/div/div[1]/table")));
                    }
                    case 8:{
                        return new
                                SelenideTable(
                                $(By.xpath("//*[@id='ga-expense-9-table']/div[1]/div[1]/div/div[1]/table")));
                    }
                    case 9:{
                        return new
                                SelenideTable(
                                $(By.xpath("//*[@id='ga-expense-10-table']/div[1]/div[1]/div/div[1]/table")));
                    }
                }
        }
        return null;

    }

    public SelenideTable getTable(){
        switch (tab){
            case KrivieNB:{
                return new
                        SelenideTable($(By.xpath("//*[@id='nb-curve-table']/div[1]/div[1]/div/div[1]/table")));
            }
            case PoteriNapora:{
                return new
                        SelenideTable($(By.xpath("//*[@id='h-losses-table']/div[1]/div[1]/div/div[1]/table")));
            }
            case HidroVB:{
                return new
                        SelenideTable($(By.xpath("//*[@id='vb-curve-table']/div[1]/div[1]/div/div[1]/table")));
            }
            case PropuskVodosbrosa:{
                return new
                        SelenideTable($(By.xpath("//*[@id='spillways-table']/div[1]/div[1]/div/div[1]/table")));
            }
            case RashodSelfNeed:{
                return new
                        SelenideTable($(By.xpath("//*[@id='ownExpensesLosses']/div[1]/div[1]/div/div[1]/table")));
            }
            }

        return null;
    }

    public void save(){
       $("#save-characteristics-button").click();
    }

    public void importCharacteristics(){
        $("#import-chars-dialog-button").click();
    }

    public void vbCurves(int choiceTable,int str,int rows,String number){
        $("#vbCurves").click();
        tab = Tab.KrivieVB;
        getTable(choiceTable).typeInTable(str,rows,(choiceTable==0)?"#vb-curve-table":"#surface-curve-table"+
                " > div.handsontableInputHolder > textarea",number);
    }
    public void expenseChars(int choiceTable,int str,int rows,String number){
        $("#expenseChars").click();
        tab = Tab.RashodCharacteristics;
        getTable(choiceTable).
                typeInTable(str,rows,"#ga-expense-"+(1+choiceTable)+"-table > div.handsontableInputHolder > textarea",
                        number);
    }
    public void nbCurves(int str,int rows,String number){
        $("#hydroNbCurve").click();
        tab = Tab.KrivieNB;
        getTable().typeInTable(str,rows,"#nb-curve-table > div.handsontableInputHolder > textarea",number);

    }
    public void poteriNapora(int str,int rows,String number){
        $("#dhCurves").click();
        tab = Tab.PoteriNapora;
        getTable().typeInTable(str,rows,"#h-losses-table > div.handsontableInputHolder > textarea",number);
    }
    public void hidroVB(int str,int rows,String number){
        $("#hydroVbCurve").click();
        tab = Tab.HidroVB;
        getTable().typeInTable(str,rows,"#vb-curve-table > div.handsontableInputHolder > textarea",number);
    }
    public void spillwayCapacity(int str,int rows,String number){
        $("#spillwayCapacity").click();
        tab = Tab.PropuskVodosbrosa;
        getTable().typeInTable(str,rows,"#spillways-table > div.handsontableInputHolder > textarea",number);
    }
    public void ownExpensesLosses(int str,int rows,String number){
        $("#ownExpensesLosses").click();
        tab = Tab.RashodSelfNeed;
        getTable().typeInTable(str,rows,"#ownExpensesLosses > div.handsontableInputHolder > textarea",number);
    }



}
