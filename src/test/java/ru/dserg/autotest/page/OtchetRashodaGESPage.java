package ru.dserg.autotest.page;

import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.dserg.autotest.Utils.Util;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 11.10.2016.
 */
public class OtchetRashodaGESPage {

    public void listStation(int choice){
        $("#stationNameSelectedForm").click();
        Util.selectSelelector($("#stationNameSelectedForm"),choice). doubleClick();

    }
    public void date(String date){
        Util.choiseDate("#datepicker",date);
    }

    public void clickGetData(){
        $("#get-outcome-data").click();

    }

    public boolean isPositive(){
        SelenideTable table = new SelenideTable($("#outcomeTable").$(By.tagName("table")));
        for (int i=0;i<24;i++) {
            for (int j = 1; j < 25; j++) {
                if(!(Integer.valueOf(table.choiceTr(0, 1).getText()) >= 0)) return true;

            }
        }
        return false;
    }


}
