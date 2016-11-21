package ru.dserg.autotest.page.Reports;

import com.codeborne.selenide.Condition;
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
    private int bad;
    public void selectStation(){
        $("#station-id").selectOptionByValue("11907059");
    }
    public void show(){
        $("#showreport-id").click();
    }
    public boolean ok(){
        $("#table-id").$(By.tagName("table")).waitUntil(Condition.visible,30000);
        SelenideTable table = new SelenideTable($("#table-id").$(By.tagName("table")));
        label:for(int i = 1; i<$("#table-id").$$(By.tagName("tr")).size()-4; i=i+4){
            for(int j=1;j<=4;j++){
                System.out.println("td "+ j+" "+table.choiceTr(i,j).getText().replace(',','.'));
                if ( Float.parseFloat( table.choiceTr(i,j).getText().replace(',','.') ) > 0){
                    continue label ;
                }
            }

            //System.out.println("эта строка не ня "+i);
            return false;
    }
        return  true;
}
}
