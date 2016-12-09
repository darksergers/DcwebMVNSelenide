package ru.dserg.autotest.page.Reports;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.dserg.autotest.Utils.Util;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Kalinin.S on 09.11.2016.
 */
public class RepairReport {

    public void selectStation(int choice){
        Util.selectSelelector($("#station-id"),choice).click();
    }
    public void datebegin(){
        //$("#datebegin-id").$(By.tagName("input")).c
        $("#datebegin-id").$(By.tagName("input")).sendKeys(Keys.chord(Keys.SHIFT,Keys.HOME,Keys.DELETE)+"09.09.2016");
    }
    public void show(){
        $("#showreport-id").click();
    }
    public  boolean  ok() throws Exception {
        $("#table-id").$(By.tagName("table")).waitUntil(Condition.visible,30000);
        boolean mspOk= false;
        boolean asuOK= false;
        SelenideTable table = new SelenideTable($("#table-id").$(By.tagName("table")));
      label:  for(int i=1;i<$("#table-id").$(By.tagName("table")).$$(By.tagName("tr")).size()-1;i++){
            for(int j=1;j<8;j++){
               if(j== 4) continue;
               if (table.choiceTr(i,j).getText().length()>0){
                   if(j<4) mspOk= true;
                   if (j>4) asuOK = true;
                   continue label;
               }
            }

          return false;
        }
        if (!(mspOk && asuOK)) return  false;
        return true;
    }
}
