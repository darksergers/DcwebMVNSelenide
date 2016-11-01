package ru.dserg.autotest.page;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.dserg.autotest.Utils.Util;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 16.08.2016.
 */
public class OptimizationPage {
    private boolean isShow=false;
    private SelenideTable table=
            new SelenideTable($(By.xpath("//*[@id='results-table']/div[1]/div[1]/div/div[1]/table")));
    public void show(){
        $("#show-results").click();
        $("#results-table").waitUntil(Condition.visible,30000);
        isShow=true;
    }
    public void select(int choice){
        Util.selectSelelector($("#target-station"),choice).click();

    }
    public void calculate(){
        $("#calculate").click();
    }
    public void export(){
        $("#export").click();
    }
    public void refresh(){
        $("#refresh").click();
    }
    public void changeTable(int str, int rows,String number){
        table.typeInTable(str,rows,"#results-table > div:nth-child(3) > textarea",number);
    }


}
