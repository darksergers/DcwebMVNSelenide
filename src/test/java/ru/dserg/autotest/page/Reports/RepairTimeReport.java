package ru.dserg.autotest.page.Reports;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.dserg.autotest.Utils.Util;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 10.11.2016.
 */
public class RepairTimeReport {
    public void selectStation(){
        $("#station-id").selectOptionByValue("11907059");
    }
    public void show(){
        $("#showreport-id").click();
    }
    public boolean ok(){
        SelenideTable table = new SelenideTable($("#table-id").$(By.tagName("table")));
        label:for(int i = 1; i<$("#table-id").$$(By.tagName("tr")).size(); i=i+4){
            for(int j=1;i<=4;j++){
                if (table.choiceTr(i,j).getText().length()>0){
                    continue label ;
                }
            }


            return false;
    }
        return  true;
}
}
