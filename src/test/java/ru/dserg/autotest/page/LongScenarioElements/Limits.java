package test.page.LongScenarioElements;

import org.openqa.selenium.By;
import test.Utils.SelenideTable;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 11.08.2016.
 */
public class Limits {
    private SelenideTable table =
            new SelenideTable($(By.xpath("//*[@id=\"limit-table\"]/div[1]/div[2]/div/div/div[1]/table")));

    public void changeTable(int str,int row,String number){
        table.typeInTable(str, row,"#limit-table > div:nth-child(2) > textarea",number);
    }

    public void save(){
        $("#save-limits").click();
    }



}
