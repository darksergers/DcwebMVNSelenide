package ru.dserg.autotest.page.LongScenarioElements;

import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 11.08.2016.
 */
public class Remont {
    private SelenideTable table =
            new SelenideTable($("#RepairsTable").$(By.tagName("table")));

    public  void loadFromREO(){
        $("#loadFromREO").click();

    }
    public void loadFromDB(){
        $("#loadFromDB").click();

    }
    public void removeRepairs(){
        $("#removeRepairs").click();
    }
    public void save(){
        $("#saveRepairs").click();
    }
    public void typeInTable(int str,int row,String number){//внести значение в ячейку пргнз подпора
        table.typeInTable(str, row,"#RepairsTable > div.handsontableInputHolder > textarea",number);
    }


}
