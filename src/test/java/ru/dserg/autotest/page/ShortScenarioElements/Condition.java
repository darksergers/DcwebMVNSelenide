package ru.dserg.autotest.page.ShortScenarioElements;

import org.openqa.selenium.By;
import ru.dserg.autotest.Utils.SelenideTable;
import ru.dserg.autotest.Utils.Util;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kalinin.S on 08.08.2016.
 */
public class Condition {
    private SelenideTable table=
            new SelenideTable($(By.xpath("//*[@id=\'ga-condition-table\']/div[1]/div[1]/div/div[1]/table")));

    public void  editTable(int str,int rows,String condition){

            table.choiceTr(str, rows).doubleClick();
            switch (condition){
                case "ВКЛ": {
                    $("#ga-condition-table > select").click();
                   Util.selectSelelector($("#ga-condition-table > select"),0).click();
                    break;
                }
                case "ХР": {
                    $("#ga-condition-table > select").click();
                    Util.selectSelelector($("#ga-condition-table > select"),1).click();
                    break;
                }
                case "ТР": {
                    $("#ga-condition-table > select").click();
                    Util.selectSelelector($("#ga-condition-table > select"),2).click();
                    break;
                }
                case "СР": {
                    $("#ga-condition-table > select").click();
                    Util.selectSelelector($("#ga-condition-table > select"),3).click();
                    break;
                }
                case "КР": {
                    $("#ga-condition-table > select").click();
                    Util.selectSelelector($("#ga-condition-table > select"),4).click();
                    break;
                }
                case "АР": {
                    $("#ga-condition-table > select").click();
                    Util.selectSelelector($("#ga-condition-table > select"),5).click();
                    break;
                }
                case "НР": {
                    $("#ga-condition-table > select").click();
                    Util.selectSelelector($("#ga-condition-table > select"),6).click();
                    break;
                }
                case "ВПР": {
                    $("#ga-condition-table > select").click();
                    Util.selectSelelector($("#ga-condition-table > select"),7).click();
                    break;
                }
                case "ЗРР": {
                    $("#ga-condition-table > select").click();
                    Util.selectSelelector($("#ga-condition-table > select"),8).click();
                    break;
                }
                case "КН": {
                    $("#ga-condition-table > select").click();
                    Util.selectSelelector($("#ga-condition-table > select"),9).click();
                    break;
                }
                case "ИСП": {
                    $("#ga-condition-table > select").click();
                    Util.selectSelelector($("#ga-condition-table > select"),10).click();
                    break;
                }

        }
            table.choiceTr(str,rows+2).click();
    }


    public void save(){
        $("#saveGaCondition").click();
    }

    public void loadModes(){
        $("#loadGaConditionFromModes").click();
    }

    public void date(int  choice){
        $("#pagination").$(By.tagName("label"),choice).click();
    }
}
