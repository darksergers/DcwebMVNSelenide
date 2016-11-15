package ru.dserg.autotest.page.Reports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.dserg.autotest.Utils.SelenideTable;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 14.11.2016.
 */
public class ReportEquipmentOperatingRegime {
    public void datebegin(){

        $("#filter-form").$(By.tagName("input")).sendKeys(Keys.chord(Keys.SHIFT,Keys.HOME,Keys.DELETE)+"01.11.2016");
    }
    public void selectStation(){
        $("#filter-form").$(By.tagName("select")).selectOption("Новосибирская ГЭС");
    }
    public void ga(){
        $("#filter-form").$(By.tagName("button")).click();
        $("#filter-form").$(By.tagName("ul")).$(By.tagName("label")).click();
    }
    public void show(){
       $("#show").click();
    }
    public boolean ok(){
        SelenideTable table = new SelenideTable($("#report-table"));
        label:for (int i = 3;i<=$("#report-table").$(By.tagName("tbody")).$$(By.tagName("tr")).size()-2;i++){
            if(Float.parseFloat(table.choiceTr(i,1).getText().replace(',','.'))>0){
            for(int j = 3; j<6;j++){
                if(Float.parseFloat(table.choiceTr(i,j).getText().replace(',','.'))>0) continue  label;

            }
                return  false;
            }else continue ;

        }

        return  true;
    }
    public void selectSource(){
        $("#filter-form").$(By.tagName("select"),1).selectOption("ОИК");
    }


}
