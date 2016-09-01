package test.page.LongScenarioElements;

import org.openqa.selenium.By;
import test.Utils.SelenideTable;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 11.08.2016.
 */
public class DG {
    private SelenideTable table = new SelenideTable($(By.xpath("//*[@id=\"dg-table\"]/div[1]/div[2]/div/div/div[1]/table")));
    public void importButton(){
        $("#import-button").click();
    }
    public void exportButton(){
        $("#export-button").click();
    }
    public void save(){
        $("#save-dispgraph-button").click();
    }
    public void changeTable(int str,int row,String number){
        table.typeInTable(str, row,"#dg-table > div:nth-child(3) > textarea",number);
    }

}
