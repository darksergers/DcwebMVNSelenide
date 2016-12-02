package ru.dserg.autotest.page.LongScenarioElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.dserg.autotest.Utils.Util;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Kalinin.S on 11.08.2016.
 */
public class Results {
    SelenideTable table= new SelenideTable($("#results-table").$(By.tagName("table")));

    public void play() throws Exception {
        $("#calculate-button").click();
        Util.findError();
    }
    public void refresh(){
       $("#refresh-button") .click();

    }
    public void export(int choice){
        $("#grid-region > div > div:nth-child(1) > div:nth-child(1) > div > div.col-md-7 > div > div > button").click();
        $(By.xpath("//*[@id=\"grid-region\"]/div/div[1]/div[1]/div/div[1]/div/div/ul"))
                .$(By.tagName("a"),choice).click();

    }
    public void checkLimits(){
        $("#use-limits").click();
    }
    public void typeInTable(int str,String nameColumn,int numberChar,String number){
        table.typeInTable(str,choiceColumn(nameColumn,numberChar),"#results-table > div.handsontableInputHolder > textarea",number);

        //table.choiceTr(str,choiceColumn(nameColumn,numberChar)).click();


    }
    public void choiceDg(int str){
        //table.choiceTr(str, choiceColumn("Параметр",8)).doubleClick();
        table.choiceTr(str, choiceColumn("Параметр",8)).$(By.tagName("div")).click();
        $(By.className("handsontableEditor")).waitUntil(Condition.visible,30000);
        SelenideTable tableChoice= new SelenideTable($(By.className("handsontableEditor")).$(By.tagName("table")));
        tableChoice.choiceTr(1,0).click();



    }
    //"ZВБкон"
    public int choiceColumn(String str,int numberChar){
        StringBuilder builder = new StringBuilder("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        for(int i=0;i<$("#results-table").$(By.tagName("table")).$$(By.tagName("th")).size();i++){
            builder.replace(0,table.choiceTh(i).getText().length(),table.choiceTh(i).getText());
            if(builder.substring(0,numberChar).equals(str))
            return i;
        }
        return -1;
    }





}
