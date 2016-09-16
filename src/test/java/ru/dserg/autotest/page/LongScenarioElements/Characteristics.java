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
            case KrivieVB:{
               if (choice==0)
                   return new SelenideTable($("#vb-curve-table").$(By.tagName("table")));
                else
                   return new
                           SelenideTable($("#surface-curve-table").$(By.tagName("table")));
            }

        }
        return null;

    }

    public SelenideTable getTable(){
        switch (tab){
            case KrivieNB:{
                return new
                        SelenideTable($("#nb-curve-table").$(By.tagName("table")));
            }
            case VbWinter:{
                return new
                        SelenideTable($("#vb-winter-table") .$(By.tagName("table")));
            }
            case NbWinter:{
                return new
                        SelenideTable($("#nb-winter-table") .$(By.tagName("table")));
            }

            case PoteriNapora:{
                return new
                        SelenideTable($("#h-losses-table").$(By.tagName("table")));
            }
            case HidroVB:{
                return new
                        SelenideTable($("#vb-curve-table").$(By.tagName("table")));
            }
            case PropuskVodosbrosa:{
                return new
                        SelenideTable($("#spillways-table").$(By.tagName("table")));
            }
            case RashodSelfNeed:{
                return new
                        SelenideTable($("#ownExpensesLosses").$(By.tagName("table")));
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
